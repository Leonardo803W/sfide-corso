package epicode.gestione.viaggi.aziendali.exceptions;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import lombok.extern.slf4j.Slf4j;

//@RestControllerAdvice: Questa annotazione indica che la classe è un "controller advisor", ovvero un componente che intercetta le eccezioni che si verificano nei controller.
//@Slf4j: Questa annotazione indica che la classe utilizza il logger slf4j per la registrazione di messaggi di log.

@RestControllerAdvice
@Slf4j
public class ExceptionsHandler {

    //ExceptionHandler: i metodi con sopra questa annotazioni si occupano di gestire le eccezioni
    //eccezzioni che possono essere personalizzate non solo in base al nome del metodo ma tra parentesi sia dell'anotazione sia del metodo ci devono essere delle classi di ecezzione
    //in questo caso le classi di eccezioni sono BadRequestException e NotFoundException che sono personalizzate, mentre le classi di eccezione generali sono Exception
    //tutti i metodi stampano i messaggi di errore, ma possono farlo finche ci sia una classe Error contenente il messaggio,
    //inoltre serve poiche nel momento in cui voglio utilizzare le class personalizate delle eccezzioni avro bisogno di poter accedere alle proprieta della classe padre Error
    //@ResponseStatus: Questa annotazione indica che il metodo restituirà una risposta HTTP con il codice di stato e tra parentesi posso personalizzare il codice di stato,
    //per esempio con (HttpStatus.BAD_REQUEST) in questo caso lo stato che ricevero sara di 400 - Bad Request.

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorsPayload handleBadRequest(BadRequestException e) {

        return new ErrorsPayload(e.getMessage(), LocalDateTime.now());
    }
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorsPayload handleNotFound(NotFoundException e) {

        return new ErrorsPayload(e.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorsPayload handleGeneric(Exception e) {

        e.printStackTrace();
        return new ErrorsPayload("Errore generico, risolveremo il prima possibile", LocalDateTime.now());
    }

}
