package epicode.gestione.viaggi.aziendali.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

//Service identifica una classe come un componente di servizio. I servizi sono responsabili dell'esecuzione di operazioni specifiche
//all'interno di un'applicazione, Spring la riconosce come un bean e la gestisce per l'iniezione di dipendenze

@Service
public class EmailService {

    //Autowired cerca automaticamente una istanza gia pre-configurata della variabile di tipo JavaMailSender
    //un'interfaccia fornita da Spring che estende le funzionalità di invio email,
    //supporta l'invio di messaggi email sia semplici che MIME (Multipurpose Internet Mail Extensions)

    @Autowired
    private JavaMailSender mailSender;

    //in entrambi i metodi nei parametri ci sono due stringhe, una per l'indirizzo email del destinatario e
    //una per il subject ovvero il titolo, vi e anche una del body ovvero il corpo del messaggio
    //nel primo metodo il corpo del messaggio viene impostato come "Mail di spam"
    //nel secondo metodo il corpo del messaggio viene impostato come "mail di default" se il body e vuoto

    public void sendEmail(String to, String subject) throws MessagingException {

        sendEmail(to, subject, "Mail di spam");
    }

    public void sendEmail(String to, String subject, String body) throws  MessagingException {

        if (body == null)
        {
            body = "mail di default";
        }

        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message);

        //MimeMessage message = mailSender.createMimeMessage();:
        //Questa riga crea un nuovo oggetto MimeMessage, che rappresenta un messaggio email.
        //mailSender: È un'istanza di un oggetto che implementa l'interfaccia JavaMailSender di Spring, responsabile dell'invio di email.
        //createMimeMessage(): Questo metodo crea un nuovo oggetto MimeMessage basato sulle impostazioni del server di posta configurate in Spring.

        //MimeMessageHelper helper = new MimeMessageHelper(message);:
        //Questa riga crea un nuovo oggetto MimeMessageHelper, che fornisce un modo più semplice per popolare un oggetto MimeMessage.
        //MimeMessageHelper: È una classe di utilità di Spring che semplifica l'impostazione delle proprietà di un messaggio email.
        //message: Passa l'oggetto MimeMessage appena creato come parametro al costruttore.

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body, true);
        mailSender.send(message);

        //helper.setTo(to);:
        //Imposta il destinatario dell'email.
        //to: È una stringa che contiene l'indirizzo email del destinatario.

        //helper.setSubject(subject);:
        //Imposta l'oggetto dell'email.
        //subject: È una stringa che contiene l'oggetto dell'email.

        //helper.setText(body, true);:
        //Imposta il corpo dell'email.
        //body: È una stringa che contiene il corpo dell'email.
        //true: Indica che il corpo dell'email deve essere interpretato come HTML.

        //mailSender.send(message);:
        //Invia l'email utilizzando l'oggetto mailSender.
        //send(message): Questo metodo invia l'email al server di posta configurato in Spring.

        System.out.println("Email inviata con successo a " + to);
    }
}
