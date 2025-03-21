package epicode.blog.autori;

import epicode.blog.blog.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//utilizzo l'annotazione NoArgsConstructor poiche il databese richiede un costruttore senza parametri
//data e AllArgsConstructor per avere tutti i metodi e un costruttore con parametri senza scriverli
//queste annotazioni posso utilizzare grazie alla dependency lombok
//Entity indica che la classe che la contiene rappresenta un'entità che può essere mappata in un database relazionale

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Autore {

    //id serve per specificare alla tabella quale la chiave
    //GeneratedValue serve per specificare come viene generata la chiave

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;
    private String cognome;
    private String email;

    //Column serve per specificare il nome della colonna nel caso il nome differisce da quello della classe

    @Column(name = "data_di_nascita")
    private LocalDate dataNascita;
    private String avatar;
}
