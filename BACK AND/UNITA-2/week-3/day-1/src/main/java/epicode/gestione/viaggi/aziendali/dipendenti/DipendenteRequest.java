package epicode.gestione.viaggi.aziendali.dipendenti;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

//@Data: Questa annotazione, fornita da Lombok, genera automaticamente metodi getter e setter per ogni campo della classe, oltre ai metodi equals, hashCode e toString.
//@AllArgsConstructor: Questa annotazione genera un costruttore che accetta come parametri tutti i campi della classe.
//@NoArgsConstructor: Questa annotazione genera un costruttore senza parametri.

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DipendenteRequest {

    //@NotBlank: questa annotazione indica che il campo non puo essere vuoto
    //@Email: questa annotazione indica che il campo deve essere un indirizzo email
    //(message = "Email non valida"): questa annotazione indica un messaggio personalizzato per l'errore

    @NotBlank(message = "Il campo username non puo essere vuoto")
    private String username;

    @NotBlank(message = "Il campo username non puo essere vuoto")
    private String nome;

    @NotBlank(message = "Il campo username non puo essere vuoto")
    private String cognome;

    @NotBlank(message = "Il campo username non puo essere vuoto")
    @Email(message = "Email non valida")
    private String email;
}
