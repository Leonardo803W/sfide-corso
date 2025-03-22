package epicode.gestione.viaggi.aziendali.sicurezza;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration: Questa annotazione indica che la classe OpenApiConfig è una classe di configurazione per Spring Boot.
//Le classi di configurazione vengono utilizzate per definire le configurazioni dell'applicazione.

@Configuration
public class OpenApiConfig {

    //@Bean: Questa annotazione indica che il metodo customOpenAPI() crea un bean, che è un oggetto gestito da Spring.
    //I bean sono utilizzati per condividere le dipendenze tra le diverse parti dell'applicazione.

    //public OpenAPI customOpenAPI(): Questo metodo crea un'istanza di OpenAPI, che è la classe principale utilizzata per definire un'API RESTful in SpringDoc OpenAPI.

    @Bean
    public OpenAPI customOpenAPI() {

        //final String securitySchemeName = "bearerAuth": Questa riga definisce una variabile che contiene il nome dello schema di sicurezza.
        //In questo caso, il nome dello schema di sicurezza è "bearerAuth".

        final String securitySchemeName = "bearerAuth";

        //.addSecurityItem(new SecurityRequirement().addList(securitySchemeName)): Questa riga aggiunge un requisito di sicurezza all'API.
        //Il requisito di sicurezza indica che l'API richiede un token di autenticazione per accedere.

        //.components(new Components().addSecuritySchemes(securitySchemeName, ...)): Questa riga aggiunge uno schema di sicurezza ai componenti dell'API.
        //Lo schema di sicurezza definisce il tipo di autenticazione utilizzato dall'API.

        //new SecurityScheme().type(SecurityScheme.Type.HTTP): Questa riga specifica che il tipo di schema di sicurezza è HTTP.

        //.scheme("bearer"): Questa riga specifica che lo schema di autenticazione è "bearer". L'autenticazione "bearer" utilizza un token di autenticazione
        //che viene inviato nell'header della richiesta HTTP.

        //.bearerFormat("JWT"): Questa riga specifica che il formato del token di autenticazione è JWT (JSON Web Token).

        //.description("Inserisci il token JWT nel formato: Bearer {token}"): Questa riga fornisce una descrizione dello schema di sicurezza.
        //La descrizione spiega agli utenti come inviare il token di autenticazione.

        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(new Components().addSecuritySchemes(securitySchemeName,
                        new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                                .description("Inserisci il token JWT nel formato: Bearer {token}")
                ));
    }
}