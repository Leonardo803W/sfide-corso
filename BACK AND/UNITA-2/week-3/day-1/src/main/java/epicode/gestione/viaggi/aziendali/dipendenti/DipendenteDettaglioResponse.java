package epicode.gestione.viaggi.aziendali.dipendenti;

//tale classe posso utilizzarla per personarizzare la risposta che ricevera il client in formato json

import epicode.gestione.viaggi.aziendali.viaggi.Viaggio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

//data e AllArgsConstructor per avere tutti i metodi e un costruttore con parametri senza scriverli
//@AllArgsConstructor genera automaticamente un costruttore che inizializza i campi finali della classe
//@NoArgsConstructor genera automaticamente un costruttore che inizializza i campi finali della classe

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DipendenteDettaglioResponse {

    private String username;
    private String nome;
    private String cognome;
    private String email;
    private List<Viaggio> viaggi = new ArrayList<>();
}
