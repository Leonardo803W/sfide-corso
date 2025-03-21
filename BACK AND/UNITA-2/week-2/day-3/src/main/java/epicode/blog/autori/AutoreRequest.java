package epicode.blog.autori;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

//La classe PostRequest è un oggetto di richiesta che rappresenta i dati necessari per creare un nuovo autore di autori.

//@Data: Questa annotazione, fornita da Lombok, genera automaticamente metodi getter e setter per ogni campo della classe, oltre ai metodi equals, hashCode e toString.
//@AllArgsConstructor: Questa annotazione genera un costruttore che accetta come parametri tutti i campi della classe.
//@NoArgsConstructor: Questa annotazione genera un costruttore senza parametri.

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutoreRequest {

    private String nome;
    private String cognome;
    private String email;
    private String avatar;
    private LocalDate dataNascita;
}

