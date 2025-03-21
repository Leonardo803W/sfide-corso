package epicode.gestione.viaggi.aziendali.sicurezza;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
}