package epicode.blog.blog;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
public class PostRequest {

    //@NotBlank: Questa annotazione indica che il campo non puo essere vuoto

    @NotBlank (message = "Il campo categoria non puo essere vuoto")
    private String categoria;

    @NotBlank (message = "Il campo titolo non puo essere vuoto")
    private String titolo;

    @NotBlank (message = "Il campo contenuto non puo essere vuoto")
    private String contenuto;

    private String cover;

    @NotBlank (message = "Il campo contenuto non puo essere vuoto")
    private int TempoDiLetturaMinuti;
}
