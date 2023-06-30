package dwn.slrm.business.projets;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dwn.slrm.business.Personne.PersonneService;
import dwn.slrm.business.annexes.files.FileStorageService;
import dwn.slrm.business.competence.CompetenceService;
import dwn.slrm.generic.Constants;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import java.util.Objects;


import static  org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProjetController.class) // Préparer l'environnement de Spring pour tester la classe demandée
class ProjetControllerTest {

    @Autowired
    MockMvc mockMvc; // Pour le test des requêtes vers l'API

    @MockBean
    ProjetService service; // On ne teste que le contrôleur donc on mock le service

    // On mock également les autres dépendances nécessaires au contrôleur
    @MockBean
    PersonneService personneService;
    @MockBean
    CompetenceService competenceService;


    // Au cas où un contrôleur superviserait la racine, il faut mocker également ses dépendances
    @MockBean
    FileStorageService fileStorageService;


    @Test
    void givenNothing_whenAll_thenReturnDtos() throws Exception {

        ProjetDto projetDto1 = new ProjetDto(1L, 0,"News",List.of(),List.of(),List.of());
        ProjetDto projetDto2 = new ProjetDto(2L, 0,"Comparator",List.of(),List.of(),List.of());
        ProjetDto projetDto3 = new ProjetDto(3L, 0,"Otto",List.of(),List.of(),List.of());
        ProjetDto projetDto4 = new ProjetDto(4L, 0,"Wayred",List.of(),List.of(),List.of());
        List<ProjetDto> dtos = List.of(projetDto1,projetDto2, projetDto3, projetDto4);

        when(service.all()).thenReturn(dtos);

        mockMvc.perform( // Perform Request
                get("/" + Constants.PROJET_PREFIX)
                        // Création d'utilisateur pour spring security
                        .with(user("user").password("pswrd").roles("TEST"))
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    void givenDto_whenSave_thenReturnUpdatedDto() throws Exception {
        ProjetDto projetDto = new ProjetDto(0L, 0,"News",List.of(),List.of(),List.of());
        when(service.save(projetDto)).thenAnswer(invocationOnMock -> {
            projetDto.setId(1L);
            return projetDto;
        });
        mockMvc.perform(post("/" + Constants.PROJET_PREFIX)
                        .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(projetDto))
                        .with(csrf())
                .with(user("user").password("pswrd").roles("TEST")))
                .andExpect(status().isFound());
    }

    private String toJson(Object object) {
        try {
            return new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return "";
        }
    }
}
