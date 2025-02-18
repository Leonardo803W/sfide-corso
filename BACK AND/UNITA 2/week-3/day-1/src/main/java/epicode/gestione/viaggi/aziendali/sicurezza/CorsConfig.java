package epicode.viaggi.sicurezza;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration indica che la classe CorsConfig è una classe di configurazione per Spring, contiene informazioni su come configurare l'applicazione.

@Configuration
public class CorsConfig {

    //@Bean utilizza le istanze per creare un nuovo ogetto di tipo WebMvcConfigurer, necessita di @configration

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Consente tutte le richieste su tutti gli endpoint
                        .allowedOrigins("*") // Consente richieste da qualsiasi origine
                        .allowedMethods("*") // Consente tutti i metodi (GET, POST, PUT, DELETE, PATCH, OPTIONS)
                        .allowedHeaders("*") // Consente tutti gli header
                        .allowCredentials(false); // Consente l'invio di credenziali, mettere false se allowedOrigins è "*"
            }
        };
    }
}