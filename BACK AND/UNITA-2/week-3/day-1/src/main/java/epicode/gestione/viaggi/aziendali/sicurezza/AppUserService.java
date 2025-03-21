package epicode.gestione.viaggi.aziendali.sicurezza;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

//@Service: questa annotazione indica che questa classe è un servizio Spring, che viene utilizzata per la gestione delle operazioni di autenticazione e autorizzazione

@Service
public class AppUserService {

    //@Autowired: questa annotazione indica che questo campo viene iniettato automaticamente dal framework Spring

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    //metodo per registrare l'utente
    public AppUser registerUser(String username, String password, Set<Role> roles) {

        if (appUserRepository.existsByUsername(username)) {
            throw new EntityExistsException("Username già in uso");
        }

        AppUser appUser = new AppUser();
        appUser.setUsername(username);
        appUser.setPassword(passwordEncoder.encode(password));
        appUser.setRoles(roles);
        return appUserRepository.save(appUser);
    }

    //metodo per trovare l'utente
    public Optional<AppUser> findByUsername(String username) {

        return appUserRepository.findByUsername(username);
    }

    //metodo per autenticare l'utente
    public String authenticateUser(String username, String password)  {

        //utilizzo del try-catch: per gestire eventuali errori che potrebbero verificarsi durante il processo di autenticazione.

        try {

            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

            //authenticationManager.authenticate(...): Questo metodo viene utilizzato per autenticare un utente. Il metodo authenticate() accetta un oggetto
            //Authentication come argomento. In questo caso, viene creato un nuovo oggetto UsernamePasswordAuthenticationToken con il nome utente (username)
            //e la password (password) forniti dall'utente.

            //new UsernamePasswordAuthenticationToken(username, password): Questo crea un nuovo token di autenticazione basato su nome utente e password.

            //Authentication authentication: Questo memorizza il risultato dell'autenticazione, che sarà un oggetto Authentication se l'autenticazione è riuscita.

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            //UserDetails userDetails = (UserDetails) authentication.getPrincipal(): Se l'autenticazione è riuscita, questo codice estrae le informazioni
            //dell'utente autenticato dall'oggetto Authentication. Le informazioni dell'utente sono rappresentate da un oggetto UserDetails.

            return jwtTokenUtil.generateToken(userDetails);

            //return jwtTokenUtil.generateToken(userDetails): Se l'autenticazione è riuscita, questo codice genera un token JWT utilizzando le informazioni dell'utente autenticato.

        } catch (AuthenticationException e) {

            throw new SecurityException("Credenziali non valide", e);

            //SecurityException con un messaggio che indica che le credenziali dell'utente non sono valide.
            //L'eccezione originale viene passata come causa dell'eccezione SecurityException.

        }
    }


    public AppUser loadUserByUsername(String username)  {

        AppUser appUser = appUserRepository.findByUsername(username).orElseThrow(() -> new EntityNotFoundException("Utente non trovato con username: " + username));


        return appUser;
    }
}