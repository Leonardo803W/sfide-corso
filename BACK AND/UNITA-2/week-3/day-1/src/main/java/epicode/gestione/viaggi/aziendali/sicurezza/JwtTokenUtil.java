package epicode.gestione.viaggi.aziendali.sicurezza;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

//@Component: questa annotazione indica che questa classe è un componente Spring, che viene utilizzata per la gestione delle operazioni di autenticazione e autorizzazione

@Component
public class JwtTokenUtil {

    //@Value: questa annotazione viene utilizzata per inizializzare le variabili di configurazione del token JWT che stanno nelle properties
    //la prima variabile e il nome del token la seconda e la durata del token

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long jwtExpirationInMs;

    // Estrae il nome utente dal token JWT
    public String getUsernameFromToken(String token) {


        //Utilizza il metodo getClaimFromToken() per ottenere il claim "subject" (che corrisponde al nome utente) dal token.
        //Il metodo getClaimFromToken() a sua volta utilizza getAllClaimsFromToken() per ottenere tutti i claims dal token e poi applica la funzione
        //Claims::getSubject per estrarre il valore del claim "subject".

        return getClaimFromToken(token, Claims::getSubject);
    }

    // Estrae la data di scadenza dal token JWT
    public Date getExpirationDateFromToken(String token) {

        //Utilizza il metodo getClaimFromToken() per ottenere il claim "expiration" (che corrisponde alla data di scadenza) dal token.
        //Il metodo getClaimFromToken() a sua volta utilizza getAllClaimsFromToken() per ottenere tutti i claims dal token e poi applica la funzione
        //Claims::getExpiration per estrarre il valore del claim "expiration".

        return getClaimFromToken(token, Claims::getExpiration);
    }

    // Estrae un claim specifico dal token JWT
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {

        //Utilizza getAllClaimsFromToken() per ottenere tutti i claims dal token.
        //Applica la funzione claimsResolver ai claims per ottenere il valore del claim desiderato.
        //La funzione claimsResolver deve essere una funzione che accetta un oggetto Claims e restituisce il valore del claim desiderato.

        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    // Estrae tutti i claims dal token JWT
    private Claims getAllClaimsFromToken(String token) {

        //Utilizza la libreria jjwt (JSON Web Token Java) per analizzare il token.
        //Imposta la chiave di firma (secret) per la verifica della firma del token.
        //Analizza il token e restituisce il corpo del token, che contiene tutti i claims.

        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    // Verifica se il token JWT è scaduto
    private Boolean isTokenExpired(String token) {

        //Utilizza getExpirationDateFromToken() per ottenere la data di scadenza del token.
        //Confronta la data di scadenza con la data corrente.
        //Restituisce true se il token è scaduto, false altrimenti.

        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    // Genera un token JWT per l'utente, includendo i ruoli
    public String generateToken(UserDetails userDetails) {

        //Ottiene i ruoli dell'utente da userDetails.getAuthorities().
        //Crea un nuovo builder di token JWT utilizzando Jwts.builder().
        //Imposta il nome utente come "subject" del token.
        //Aggiunge i ruoli come claim "roles".
        //Imposta la data di emissione e la data di scadenza del token.
        //Firma il token utilizzando l'algoritmo HS256 e la chiave segreta (secret).
        //Compatta il token e lo restituisce come stringa.

        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        List<String> roles = authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .claim("roles", roles)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationInMs))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    // Estrae i ruoli dal token JWT
    public List<String> getRolesFromToken(String token) {

        //Utilizza getAllClaimsFromToken() per ottenere tutti i claims dal token.
        //Ottiene il valore del claim "roles" come una lista di stringhe.

        Claims claims = getAllClaimsFromToken(token);
        return claims.get("roles", List.class);
    }

    // Valida il token JWT
    public Boolean validateToken(String token, UserDetails userDetails) {

        //Estrae il nome utente dal token utilizzando getUsernameFromToken().
        //Verifica se il nome utente nel token corrisponde al nome utente dell'utente.
        //Verifica se il token è scaduto utilizzando isTokenExpired().
        //Restituisce true se il token è valido, false altrimenti.

        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}