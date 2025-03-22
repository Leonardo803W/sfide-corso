package epicode.gestione.viaggi.aziendali.sicurezza;

import lombok.Data;

//le variabili segnato in questa classe saranno utilizzate per il login, ovvero quello che l'utente vedra per poter loggare in un sito
//@Data: Questa annotazione, fornita da Lombok, genera automaticamente metodi getter e setter per ogni campo della classe

@Data
public class LoginRequest {

    private String username;
    private String password;
}