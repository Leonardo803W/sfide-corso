package epicode.gestione.viaggi.aziendali.sicurezza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//@Configuration: Questa annotazione indica che la classe SecurityConfig è una classe di configurazione per Spring Boot.
//Le classi di configurazione vengono utilizzate per definire le configurazioni dell'applicazione.
//@EnableWebSecurity: Questa annotazione abilita la sicurezza web di Spring Security.
//@EnableGlobalMethodSecurity(prePostEnabled = true): Questa annotazione abilita la sicurezza a livello di metodo.
//La proprietà prePostEnabled indica che le annotazioni di pre-autorizzazione (@PreAuthorize) e post-autorizzazione
//(@PostAuthorize) possono essere utilizzate per controllare l'accesso ai metodi.

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class SecurityConfig {

    //@Autowired: Questa annotazione permette l'iniettazione di dipendenze da altre classi.
    //@Bean: Questa annotazione indica che questa classe è un bean Spring, che viene utilizzata per la gestione delle operazioni di autenticazione e autorizzazione.

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        //.csrf(csrf -> csrf.disable()): Questa riga disabilita la protezione CSRF (Cross-Site Request Forgery).
        //.authorizeHttpRequests(authorize -> authorize ...): Questa riga configura le regole di autorizzazione per le richieste HTTP.

        http
                .csrf(csrf -> csrf.disable()) // Disabilita CSRF

                .authorizeHttpRequests(authorize -> authorize

                        .requestMatchers("/api/admin/**").hasRole("ADMIN") // Solo gli utetenti admin possono accedere a questo percorso
                        .requestMatchers("/api/user/**").hasAnyRole("USER", "ADMIN") // Gli utenti user e admin possono accedere a questo percorso
                        .requestMatchers(HttpMethod.GET, "/api/**").hasAnyRole("USER", "ADMIN") // Gli utenti user e admin possono fare richieste GET
                        .requestMatchers(HttpMethod.POST, "/api/**").hasAnyRole( "ADMIN") // solo Gli utenti l'admin puo fare richieste POST
                        .requestMatchers(HttpMethod.PUT, "/api/**").hasAnyRole( "ADMIN") // solo Gli utenti l'admin puo fare richieste PUT
                        .requestMatchers(HttpMethod.DELETE, "/api/**").hasAnyRole( "ADMIN") // solo Gli utenti l'admin puo fare richieste DELETE


                        //parte sotto per swagger
                        //.requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll(): Questa riga specifica che tutti gli utenti possono accedere ai percorsi
                        //"/swagger-ui/" e "/v3/api-docs/", che sono i percorsi utilizzati per l'interfaccia utente di Swagger.
                        //.anyRequest().permitAll(): Questa riga consente l'accesso a tutte le altre richieste.

                        //.requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll() // Accesso libero a Swagger
                        //.requestMatchers("/api/**").permitAll()
                        .anyRequest().permitAll()

                        //.sessionManagement(session -> session ...): Questa riga configura la gestione delle sessioni.
                        //.sessionCreationPolicy(SessionCreationPolicy.STATELESS): Questa riga specifica che l'applicazione non manterrà le sessioni HTTP.

                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        //http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class): Questa riga aggiunge il filtro JWT alla catena di filtri di sicurezza.
        //Il filtro JWT viene aggiunto prima del filtro di autenticazione standard di Spring Security.

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        //return http.build(): Questa riga restituisce un'istanza di SecurityFilterChain, che è la catena di filtri di sicurezza configurata.

        return http.build();
    }

    //@Bean: Questa annotazione indica che questo metodo crea un bean chiamato "authenticationManager". I bean sono oggetti gestiti da Spring che possono
    //essere iniettati in altre parti dell'applicazione.
    //public AuthenticationManager: Questo indica che il metodo restituisce un'istanza di AuthenticationManager.
    //authenticationManager(AuthenticationConfiguration authenticationConfiguration): Questo è il nome del metodo e accetta un parametro di tipo AuthenticationConfiguration.
    //throws Exception: Questo indica che il metodo può lanciare un'eccezione.

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {

        //return authenticationConfiguration.getAuthenticationManager();: Questo codice restituisce l'oggetto AuthenticationManager ottenuto
        //dall'oggetto AuthenticationConfiguration. L'oggetto AuthenticationConfiguration fornisce un modo per configurare l'autenticazione in Spring Security.

        return authenticationConfiguration.getAuthenticationManager();
    }

    //@Bean: Questa annotazione indica che questo metodo crea un bean chiamato "passwordEncoder".
    //public PasswordEncoder: Questo indica che il metodo restituisce un'istanza di PasswordEncoder.

    @Bean
    public PasswordEncoder passwordEncoder() {

        //return new BCryptPasswordEncoder();: Questo codice restituisce un'istanza di BCryptPasswordEncoder, che è un'implementazione di PasswordEncoder
        //che utilizza l'algoritmo BCrypt per crittografare le password.

        return new BCryptPasswordEncoder();
    }
}