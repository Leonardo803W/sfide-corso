package epicode.blog.blog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

//La classe PostRequest è un oggetto di richiesta che rappresenta i dati necessari per creare un nuovo post di blog.

//@Data: Questa annotazione, fornita da Lombok, genera automaticamente metodi getter e setter per ogni campo della classe, oltre ai metodi equals, hashCode e toString.
//@AllArgsConstructor: Questa annotazione genera un costruttore che accetta come parametri tutti i campi della classe.
//@NoArgsConstructor: Questa annotazione genera un costruttore senza parametri.

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {

    private String categoria;
    private String titolo;
    private String contenuto;
    private String cover;
    private int TempoDiLetturaMinuti;
}
