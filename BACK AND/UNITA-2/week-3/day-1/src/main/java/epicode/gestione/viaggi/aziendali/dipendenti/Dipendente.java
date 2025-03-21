package epicode.gestione.viaggi.aziendali.dipendenti;

import epicode.gestione.viaggi.aziendali.viaggi.Viaggio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

//utilizzo l'annotazione NoArgsConstructor poiche il databese richiede un costruttore senza parametri
//data e AllArgsConstructor per avere tutti i metodi e un costruttore con parametri senza scriverli
//queste annotazioni posso utilizzare grazie alla dependency lombok
//Entity indica che la classe che la contiene rappresenta un'entità che può essere mappata in un database relazionale
//@Tabble indica che la classe rappresenta una tabella in un database relazionale

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Dipendente {

    //l'id serve per la tabella sul db (databese) avendole creata una primary key
    //invece GenerationType.SEQUENCE serve per non avere problemi in termini di id per eventuali copie identiche

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    //posso non utilizzare @Column poiche se il nome della variabile e uguale alla tabella capisci da solo di che colonna si tratta
    //se invece volessi usarla dovrei fare @Column (name = "username")

    private String username;
    private String nome;
    private String cognome;
    private String email;

    //OneToMany serve per specificare una relazione di uno a molti
    //mappedBy serve per specificare la proprieta che rappresenta la chiave esterna

    @OneToMany(mappedBy = "dipendente", cascade = CascadeType.ALL)
    private List<Viaggio> viaggi = new ArrayList<>();
}
