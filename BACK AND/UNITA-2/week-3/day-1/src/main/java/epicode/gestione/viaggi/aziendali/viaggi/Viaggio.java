package epicode.gestione.viaggi.aziendali.viaggi;

import epicode.gestione.viaggi.aziendali.dipendenti.Dipendente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
public class Viaggio {

    //l'id serve per la tabella sul db (databese) avendole creata una primary key
    //invece GenerationType.SEQUENCE serve per non avere problemi in termini di id per eventuali copie identiche

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    //posso non utilizzare @Column poiche se il nome della variabile e uguale alla tabella capisci da solo di che colonna si tratta
    //se invece volessi usarla dovrei fare @Column (name = "username")

    private String destinazione;

    @Column(name = "data_viaggio")
    private LocalDate dataViaggio;

    //@Enumerated(EnumType.STRING) serve per indicare che il valore di statoViaggio deve essere salvato come una stringa e che sia un tipo enum

    @Column(name = "stato_viaggio")
    @Enumerated(EnumType.STRING)
    private StatoViaggio statoViaggio;

    //Many to One indica che un post appartiene ad un autore

    @ManyToOne
    @JoinColumn(name = "dipendenteId")
    private Dipendente dipendente;

}