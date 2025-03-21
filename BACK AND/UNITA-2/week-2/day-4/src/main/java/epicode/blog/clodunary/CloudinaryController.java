package epicode.blog.clodunary;

import com.cloudinary.Cloudinary;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

//RestController specifico che questa classe sia un rest ovvero responsabile della gestione delle richieste HTTP e della restituzione di risposte in formato JSON.
//RequestMapping specifico il percorso base per le richieste HTTP che saranno gestite da questa classe
//RequiredArgsConstructor genera automaticamente un costruttore che inizializza i campi finali della classe. In questo caso, inizializza aziendaRepository e faker

@RestController
@RequestMapping("/api/images")
@RequiredArgsConstructor
public class CloudinaryController {
    private final Cloudinary cloudinary;

    //Il metodo post metodi avranno alla base dell'url questo: http://localhost:8080/api/images
    //questa classe permette di salvare le immagine che poi verranno visualizzate in cloudinary
    //consumes specifica il tipo di dati che verranno inviati nella richiesta HTTP
    //MediaType.MULTIPART_FORM_DATA_VALUE specifica il formato dei dati inviati nella richiesta HTTP

    @PostMapping(path="/uploadme", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void upload(@RequestPart("file")MultipartFile file) {

        //@RequestPart: Questa annotazione indica che il parametro verrà preso da un valore presente nella richiesta HTTP.
        //"file": Questo è il nome del campo che contiene il file nella richiesta HTTP. In genere, questo nome corrisponde al nome dell'attributo name del tag
        //<input type="file"> nel form HTML che invia la richiesta.
        //MultipartFile file: Questa parte dichiara il parametro file come un oggetto di tipo MultipartFile.
        //La classe MultipartFile è una classe di Spring che rappresenta un file caricato tramite una richiesta HTTP.

        try {

            //Map result = cloudinary.uploader().upload(...):
            //Qui stai invocando il metodo upload dell'oggetto uploader di Cloudinary. Questo metodo è responsabile per caricare il file sul server di Cloudinary.
            //Map result: La variabile result è una mappa che conterrà i risultati del caricamento, come l'URL del file caricato e altre informazioni.

            //file.getBytes():
            //Questo metodo estrae i byte del file caricato, che sono necessari per il caricamento.
            //file è un oggetto di tipo MultipartFile, che rappresenta il file caricato dall'utente.

            //Cloudinary.asMap(...):
            //Questo metodo crea una mappa di opzioni da passare al metodo di upload. In questo caso, stai specificando due parametri:
            //"folder", "FS0824": Questo indica che il file deve essere caricato nella cartella denominata FS0824 su Cloudinary.
            //"public_id", file.getOriginalFilename(): Qui stai impostando l'ID pubblico del file caricato. Utilizzi il nome originale del file
            //(getOriginalFilename()) come ID pubblico, il che significa che il file sarà accessibile tramite questo nome.

            Map result = cloudinary.uploader().upload(file.getBytes(),  Cloudinary.asMap("folder", "FS0824", "public_id", file.getOriginalFilename()));

            //String url = result.get("secure_url").toString();:
            //Dopo il caricamento, stai estraendo l'URL sicuro del file caricato dalla mappa result.
            //result.get("secure_url"): Questo recupera l'URL sicuro del file, che è l'indirizzo web attraverso il quale il file può essere accessibile.
            //.toString(): Converte l'oggetto in una stringa.

            String url = result.get("secure_url").toString();

        } catch (IOException e) {

            throw new RuntimeException(e);
        }

    }

}
