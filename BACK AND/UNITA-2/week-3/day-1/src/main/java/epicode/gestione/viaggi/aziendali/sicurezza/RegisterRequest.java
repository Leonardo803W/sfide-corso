package epicode.gestione.viaggi.aziendali.sicurezza;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

//questa classe viene utilizzata per registrare un nuovo utente, tutto cio che verra chiesto all'utente in fase di registrazione ad un sito
//@Data: Questa annotazione, fornita da Lombok, genera automaticamente metodi getter e setter per ogni campo della classe

@Data
public class RegisterRequest {

    //@NotBlank: Questa annotazione indica che il campo non puo essere vuoto
    //message: Questo indica un messaggio di errore personalizzato

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;
}