package dwn.slrm.generic.controllers;

import dwn.slrm.business.annexes.files.FileStorageService;
import dwn.slrm.generic.Constants;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Controller
@ControllerAdvice // Indique des traitements (@ModelAttribute, @ExceptionHandler, ...) devant être exécutés par tous les controllers de mon application
@RequestMapping
public class GlobalController {

    private final FileStorageService service;

    public GlobalController(FileStorageService service) {
        this.service = service;
    }

    @GetMapping
    public String index() {
        return "index";
    }

    // -> Controller.paths
    @ModelAttribute(name = "paths")
    public List<String> getPaths() {
        /*Field[] declaredFields = Constants.class.getDeclaredFields();// Récupère les noms de champs présents dans la classe Constants
        List<String> paths = new ArrayList<>();
        for (Field field : declaredFields) {
            try {
                paths.add((String) field.get(null)); // avec un object instancié ceci va me récupérer les valeurs en cours de l'objet / avec null ceci va récupérer les valeurs de champs "static"
            } catch (Exception ignored) {}
        }
        return paths;*/
        return Arrays.stream(Constants.class.getDeclaredFields()).map(field -> {
            try {
                return (String) field.get(null);
            } catch (Exception e) {
                return null;
            }
        })
                .filter(Objects::nonNull) // .filter(string -> string != null)
                .toList();
    }

    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> load(@PathVariable String filename){
        Resource file = service.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
}
