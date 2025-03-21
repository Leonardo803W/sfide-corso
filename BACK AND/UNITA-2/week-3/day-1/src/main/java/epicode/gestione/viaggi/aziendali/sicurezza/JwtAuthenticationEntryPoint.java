package epicode.gestione.viaggi.aziendali.sicurezza;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component indica che la classe JwtAuthenticationEntryPoint sia un componente Spring

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    //Il metodo commence è parte della gestione delle eccezioni in Spring Security. Viene invocato quando si verifica un'eccezione di autenticazione,
    //ad esempio quando un utente non è autorizzato ad accedere a una risorsa protetta.

    //HttpServletRequest request: Questo parametro rappresenta la richiesta HTTP ricevuta. Può essere utilizzato per ottenere informazioni sulla richiesta,
    //come l'URL richiesto o i parametri della query.

    //HttpServletResponse response: Questo parametro rappresenta la risposta HTTP che verrà inviata al client.
    //Può essere utilizzato per impostare il codice di stato della risposta, gli header e il corpo della risposta.

    //AuthenticationException authException: Questo parametro rappresenta l'eccezione di autenticazione che è stata sollevata.
    //Contiene informazioni sull'errore di autenticazione, come il motivo per cui l'autenticazione è fallita.

    //throws IOException: Questo indica che il metodo può lanciare un'eccezione di tipo IOException,
    //che è comune quando si lavora con le operazioni di input/output, come la scrittura della risposta.

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {

        // Restituisce un errore 401 non autorizzato
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Accesso non autorizzato");
    }
}