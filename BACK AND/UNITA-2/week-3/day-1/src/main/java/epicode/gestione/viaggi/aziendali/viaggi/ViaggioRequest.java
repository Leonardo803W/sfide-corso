package epicode.gestione.viaggi.aziendali.viaggi;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

//@Data: Questa annotazione, fornita da Lombok, genera automaticamente metodi getter e setter per ogni campo della classe, oltre ai metodi equals, hashCode e toString.
//@AllArgsConstructor: Questa annotazione genera un costruttore che accetta come parametri tutti i campi della classe.
//@NoArgsConstructor: Questa annotazione genera un costruttore senza parametri.

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViaggioRequest {

    //@NotBlank: questa annotazione indica che il campo non puo essere vuoto
    //@NotNull: questa annotazione indica che il campo non puo essere null

    @NotBlank(message = "Il campo destinazione non puo essere vuoto")
    private String destinazione;

    @NotNull(message = "La data del viaggio non puo essere null")
    private LocalDate dataViaggio;

    @NotBlank(message = "Il campo destinazione non puo essere vuoto")
    private StatoViaggio statoViaggio;

    private int dipendenteId;
}