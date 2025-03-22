package epicode.gestione.viaggi.aziendali.sicurezza;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

//@Component: questa annotazione indica che questa classe è un componente Spring, che viene utilizzata per la gestione delle operazioni di
//autenticazione e autorizzazione

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    //@Attowired: questa annotazione indica che questa classe è una classe di configurazione Spring, che viene utilizzata per la gestione delle operazioni di
    //autenticazione e autorizzazione
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response,FilterChain chain) throws ServletException, IOException {

        final String requestTokenHeader = request.getHeader("Authorization");

        if(shouldNotFilter(request)) {
            chain.doFilter(request, response);
            return;
        }
        String username = null;
        String jwtToken = null;

        // Estrae il token JWT dal header Authorization
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {

            jwtToken = requestTokenHeader.substring(7);

            //Il filtro inizia cercando l'header "Authorization" nella richiesta HTTP.
            //Se l'header è presente e inizia con "Bearer ", il token JWT viene estratto dalla stringa.
            //Se l'header non è presente o non inizia con "Bearer ", il filtro genera un errore "JWT Token is missing" e reindirizza la richiesta alla pagina di errore "/error".
            //Validazione del token:

            try {

                username = jwtTokenUtil.getUsernameFromToken(jwtToken);

            } catch (IllegalArgumentException e) {

                System.out.println("Impossibile ottenere il token JWT");
            } catch (ExpiredJwtException e) {

                System.out.println("Il token JWT è scaduto");
            }
        } else {

            request.setAttribute("javax.servlet.error.exception", new JwtTokenMissingException("JWT Token is missing"));
            request.getRequestDispatcher("/error").forward(request, response);
            return;
        }

        // Valida il token e configura l'autenticazione nel contesto di sicurezza
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(username);

            //Se il token è stato estratto, viene validato usando il metodo jwtTokenUtil.validateToken().
            //Questo metodo controlla se il token è valido, non è scaduto e se la firma è corretta.
            //Se la validazione fallisce, il filtro stampa un messaggio di errore in console.
            //Se il token è valido, il filtro ottiene le informazioni sull'utente dal CustomUserDetailsService usando il nome utente estratto dal token.

            if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {

                //Se l'utente è trovato, il filtro crea un oggetto UsernamePasswordAuthenticationToken e lo imposta nel contesto di sicurezza di Spring Security. Questo processo autentica l'utente e gli permette di accedere alle risorse protette.
                //Passaggio della richiesta:

                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());

                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        //Infine, il filtro chiama chain.doFilter(request, response) per passare la richiesta al prossimo filtro nella catena.

        chain.doFilter(request, response);
    }

    // AntPathMatcher viene utilizzato per confrontare il percorso della richiesta con i modelli di URL nella lista EXCLUDED_URLS

    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    //shouldNotFilter(HttpServletRequest request): Questo metodo riceve una richiesta HTTP e determina se il filtro JWT deve essere applicato a quella richiesta.

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {

        //String path = request.getRequestURI().substring(request.getContextPath().length());: Questo calcola il percorso della richiesta,
        //ovvero la parte dell'URL che segue il contesto dell'applicazione. Ad esempio, se il contesto dell'applicazione è "/myapp" e l'URL
        //della richiesta è "/myapp/api/users", il percorso sarà "/api/users".
        //EXCLUDED_URLS: Questa lista contiene le URL che non devono essere filtrate dal filtro JWT. In questo caso, le URL escluse sono:

        //api/public: Questa potrebbe essere un'area pubblica del tuo sito web o API che non richiede l'autenticazione.
        //api/auth/**: Questo potrebbe essere l'endpoint per l'autenticazione, dove gli utenti possono ottenere un token JWT.
        //swagger-ui/**: Questo è l'endpoint per la documentazione Swagger, che potrebbe essere accessibile a tutti.
        //v3/api-docs/**: Questo è l'endpoint per la documentazione OpenAPI, che potrebbe essere accessibile a tutti.
        //error: Questo è l'endpoint per la gestione degli errori, che potrebbe essere accessibile a tutti.
        //sw.js: Questo è un file Javascript per la gestione del servizio worker, che potrebbe essere accessibile a tutti.
        //return EXCLUDED_URLS.stream().anyMatch(pattern -> antPathMatcher.match(pattern, path));:
        //Questo codice controlla se il percorso della richiesta corrisponde a uno dei modelli nella lista EXCLUDED_URLS.
        //Se c'è una corrispondenza, il metodo restituisce true, il che significa che il filtro JWT non deve essere applicato.

        String path = request.getRequestURI().substring(request.getContextPath().length());
        return EXCLUDED_URLS.stream().anyMatch(pattern -> antPathMatcher.match(pattern, path));
    }

    private static final List<String> EXCLUDED_URLS = Arrays.asList(
            "/api/public",
            "/api/auth/**",
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/error",
            "/sw.js"
    );


}