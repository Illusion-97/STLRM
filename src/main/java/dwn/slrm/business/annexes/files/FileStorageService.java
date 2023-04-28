package dwn.slrm.business.annexes.files;

import dwn.slrm.business.annexes.Annexe;
import dwn.slrm.business.annexes.AnnexeRepo;
import dwn.slrm.generic.exceptions.FileStorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * The type File storage service.
 */
@Service
public class FileStorageService {
    private final Path fileStorageLocation;
    private final AnnexeRepo repo;

    /**
     * The Api files path.
     */
    private final String apiFilesPath;

    /**
     * Instantiates a new File storage service.
     *
     * @param repo         the repo
     * @param apiFilesPath
     */
    @Autowired
    public FileStorageService(AnnexeRepo repo, @Value("${APPLICATION_STORAGE_VOLUME}") String apiFilesPath) {
        this.apiFilesPath = apiFilesPath;
        this.fileStorageLocation = Paths.get(this.apiFilesPath)
                .toAbsolutePath().normalize();
        this.repo = repo;

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    /**
     * Save file Annexe.
     *
     * @param file     the file
     * @param fileName the file name
     * @return the Annexe
     * @throws FileStorageException the file storage exception
     */
    public Annexe saveFile(MultipartFile file, String fileName) throws FileStorageException {
        try {
            Annexe m = repo.saveAndFlush(
                    new Annexe(fileName,
                            getFileExtension(fileName),
                            file.getContentType())
            );
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(m.getId() + "." + m.getExtension());
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return m;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ", Please try again!", ex);
        }
    }

    private String getFileExtension(String name) {
        String[] split = name.split("\\.");
        return split[split.length - 1];
    }

    /**
     * Load resource.
     *
     * @param filename the filename
     * @return the resource
     */
    public Resource load(String filename) {
        try {
            Path file = this.fileStorageLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new FileStorageException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new FileStorageException("Error: " + e.getMessage(), e);
        }
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    public Annexe getById(long id) {
        return repo.getReferenceById(id);
    }

    /**
     * Delete.
     *
     * @param Annexe the Annexe
     */
    public void delete(Annexe Annexe) {
        String fileName = Annexe.getId() + "." + Annexe.getExtension();
        try {
            Files.delete(this.fileStorageLocation.resolve(fileName));
            repo.delete(Annexe);
        } catch (IOException e) {
            throw new FileStorageException("Could not delete file " + fileName + ", Please try again!", e);
        }
    }
}
