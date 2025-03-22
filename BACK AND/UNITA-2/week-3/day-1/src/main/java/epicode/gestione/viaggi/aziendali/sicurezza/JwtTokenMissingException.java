package epicode.gestione.viaggi.aziendali.sicurezza;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus: Questa annotazione indica che la classe che la contiene rappresenta un errore di risposta HTTP con un codice di stato specifico.

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class JwtTokenMissingException extends RuntimeException {

    //public JwtTokenMissingException(String message): Questo costruttore accetta un messaggio di errore come argomento e
    //lo passa al costruttore della classe padre (Exception). Il messaggio di errore verrà utilizzato per fornire informazioni sull'eccezione quando viene sollevata.

    public JwtTokenMissingException(String message) {

        super(message);
    }

    //public JwtTokenMissingException(String message, Throwable cause): Questo costruttore accetta un messaggio di errore e una causa come argomenti.
    //La causa è un'altra eccezione che potrebbe aver causato l'eccezione corrente.
    //Questo costruttore passa il messaggio di errore e la causa al costruttore della classe padre.

    public JwtTokenMissingException(String message, Throwable cause) {

        super(message, cause);
    }

    //public JwtTokenMissingException(Throwable cause): Questo costruttore accetta una causa come argomento e la passa al costruttore della classe padre.
    //Questo costruttore viene utilizzato quando l'eccezione corrente è causata da un'altra eccezione e non è necessario un messaggio di errore personalizzato.

    public JwtTokenMissingException(Throwable cause) {

        super(cause);
    }

    //public JwtTokenMissingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace): Questo costruttore accetta
    //un messaggio di errore, una causa, un valore booleano che indica se la soppressione delle eccezioni è abilitata e un valore booleano che indica se la traccia
    //dello stack è scrivibile. Questo costruttore passa tutti questi argomenti al costruttore della classe padre.

    public JwtTokenMissingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {

        super(message, cause, enableSuppression, writableStackTrace);
    }

    //public JwtTokenMissingException(): Questo è il costruttore predefinito della classe. Non accetta alcun argomento e viene utilizzato quando non è necessario
    //fornire un messaggio di errore o una causa.

    public JwtTokenMissingException() {
    }
}