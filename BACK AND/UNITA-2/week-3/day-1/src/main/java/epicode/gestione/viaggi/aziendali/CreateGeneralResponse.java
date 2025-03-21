package epicode.gestione.viaggi.aziendali;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data: Questa annotazione, fornita da Lombok, genera automaticamente metodi getter e setter per ogni campo della classe, oltre ai metodi equals, hashCode e toString.
//@AllArgsConstructor: Questa annotazione genera un costruttore che accetta come parametri tutti i campi della classe.
//@NoArgsConstructor: Questa annotazione genera un costruttore senza parametri.

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateGeneralResponse {

    //classe per la gestione delle risposte di creazione solitamente utilizzata nei jason per avere l'id degli elementi
    //poiche json non restituisce l'id anche se sono presenti nelle tabelle dell databese, questo serve per generarlo per fare avbere l'id al frontend

    private Long id;
}