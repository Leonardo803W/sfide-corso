package epicode.blog.blog;

import epicode.blog.autori.Autore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//utilizzo l'annotazione NoArgsConstructor poiche il databese richiede un costruttore senza parametri
//data e AllArgsConstructor per avere tutti i metodi e un costruttore con parametri senza scriverli
//queste annotazioni posso utilizzare grazie alla dependency lombok
//Entity indica che la classe che la contiene rappresenta un'entità che può essere mappata in un database relazionale

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    //id serve per specificare alla tabella quale la chiave
    //GeneratedValue serve per specificare come viene generata la chiave

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;

    //Column serve per specificare il nome della colonna nel caso il nome differisce da quello della classe

    @Column(name = "tempo_di_lettura")
    private int TempoDiLetturaMinuti;

    //Many to One indica che un post appartiene ad un autore

    @ManyToOne
    @JoinColumn(name = "autoreId")
    Autore autore;
}
