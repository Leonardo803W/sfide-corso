package epicode.blog.autori;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

//La classe PostRequest è un oggetto di richiesta che rappresenta i dati necessari per creare un nuovo autore di autori.
//inoltre serve per aggiungere delle annotazioni utili per validare i payload

//@Data: Questa annotazione, fornita da Lombok, genera automaticamente metodi getter e setter per ogni campo della classe, oltre ai metodi equals, hashCode e toString.
//@AllArgsConstructor: Questa annotazione genera un costruttore che accetta come parametri tutti i campi della classe.
//@NoArgsConstructor: Questa annotazione genera un costruttore senza parametri.

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutoreRequest {

    //@NotBlank: Questa annotazione indica che il campo non puo essere vuoto e non puo contenere solo spazi
    //@Email: Questa annotazione indica che il campo deve essere un indirizzo email
    //@NotNull: Questa annotazione indica che il campo non puo essere nullo

    @NotBlank (message = "Il nome non puo essere vuoto")
    private String nome;

    @NotBlank (message = "Il cognome non puo essere vuoto")
    private String cognome;

    @NotBlank (message = "L'email non puo essere vuota")
    @Email (message = "L'email deve essere valida")
    private String email;

    private String avatar;

    @NotNull(message = "La data di nascita non può essere vuota")
    private LocalDate dataNascita;
}

