package epicode.gestione.viaggi.aziendali.viaggi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

//data e AllArgsConstructor per avere tutti i metodi e un costruttore con parametri senza scriverli
//@AllArgsConstructor genera automaticamente un costruttore che inizializza i campi finali della classe
//@NoArgsConstructor genera automaticamente un costruttore che inizializza i campi finali della classe

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViaggioDettaglioResponse {

    private String destinazione;
    private LocalDate dataViaggio;
    private StatoViaggio statoViaggio;
}