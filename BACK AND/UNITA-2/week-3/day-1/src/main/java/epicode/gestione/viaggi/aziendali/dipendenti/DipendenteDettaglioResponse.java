package epicode.gestione.viaggi.aziendali.dipendenti;

//tale classe posso utilizzarla per personarizzare la risposta che ricevera il client in formato json

import epicode.gestione.viaggi.aziendali.viaggi.Viaggio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//data e AllArgsConstructor per avere tutti i metodi e un costruttore con parametri senza scriverli
//@AllArgsConstructor genera automaticamente un costruttore che inizializza i campi finali della classe
//@NoArgsConstructor genera automaticamente un costruttore che inizializza i campi finali della classe

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DipendenteDettaglioResponse {

    private String email;
    private Viaggio viaggio;
}
