package epicode.gestione.viaggi.aziendali.sicurezza;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;


//utilizzo l'annotazione NoArgsConstructor poiche il databese richiede un costruttore senza parametri
//data e AllArgsConstructor per avere tutti i metodi e un costruttore con parametri senza scriverli
//queste annotazioni posso utilizzare grazie alla dependency lombok
//Entity indica che la classe che la contiene rappresenta un'entità che può essere mappata in un database relazionale

@Entity
@Table(name = "users")
@NoArgsConstructor
@Data
public class AppUser implements UserDetails {

    //id serve per specificare alla tabella quale la chiave
    //GeneratedValue serve per specificare come viene generata la chiave

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column: Questa annotazione indica che la variabile username è mappata a una colonna nel database.
    //nullable = false: Questo attributo indica che la colonna username non può essere vuota nel database. In altre parole, ogni utente deve avere un nome utente.
    //unique = true: Questo attributo indica che il valore nella colonna username deve essere univoco. Non possono esserci due utenti con lo stesso nome utente.

    @Column(nullable = false, unique = true)
    private String username;

    //@Column(nullable = false): Come prima, questo indica che la colonna password non può essere vuota nel database. Ogni utente deve avere una password.
    //@ToString.Exclude: Questa annotazione di Lombok indica che la variabile password non dovrebbe essere inclusa nella rappresentazione testuale dell'oggetto
    //(ad esempio, quando si usa il metodo toString()). Questo è importante per motivi di sicurezza, perché non si vuole che la password venga visualizzata in chiaro.

    @Column(nullable = false)
    @ToString.Exclude
    private String password;

    //@ElementCollection: Questa annotazione indica che roles è una collezione di elementi che vengono mappati a una tabella separata nel database.
    //fetch = FetchType.EAGER: Questo attributo indica che la collezione roles viene caricata immediatamente quando si carica l'oggetto utente.
    //@Enumerated(EnumType.STRING): Questa annotazione indica che l'enumerazione Role viene mappata al database come una stringa.

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    //accountNonExpired: Indica se l'account utente è scaduto.
    //accountNonLocked: Indica se l'account utente è bloccato.
    //credentialsNonExpired: Indica se le credenziali dell'account utente sono scadute.
    //enabled: Indica se l'account utente è abilitato.

    private  boolean accountNonExpired = true;
    private  boolean accountNonLocked = true;
    private  boolean credentialsNonExpired = true;
    private  boolean enabled = true;

    //@Override: Questa annotazione indica che il metodo getAuthorities() sovrascrive un metodo definito nella classe padre.
    //public Collection<GrantedAuthority> getAuthorities(): Questo è il metodo che restituisce un'istanza di Collection<GrantedAuthority>. In Spring Security,
    //GrantedAuthority rappresenta un'autorizzazione che un utente ha.
    //roles.stream(): Questo crea un flusso di elementi dalla collezione roles.
    //.map(role -> new SimpleGrantedAuthority(role.name())): Questo trasforma ogni elemento nel flusso (un ruolo) in un nuovo oggetto SimpleGrantedAuthority
    //che contiene il nome del ruolo.
    //.collect(Collectors.toList()): Questo raccoglie tutti gli elementi trasformati in una nuova lista.

    @Override
    public Collection<GrantedAuthority> getAuthorities() {

        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toList());
    }

    public AppUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {

        //this(username, password, true, true, true, true, authorities); Questo richiama un altro costruttore della classe AppUser che accetta parametri aggiuntivi.
        //In questo caso, sta impostando i valori predefiniti per enabled, accountNonExpired, credentialsNonExpired, accountNonLocked a true.

        this(username, password, true, true, true, true, authorities);
    }

    public AppUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {

        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.accountNonExpired = accountNonExpired;
        this.credentialsNonExpired = credentialsNonExpired;
        this.accountNonLocked = accountNonLocked;
    }
}