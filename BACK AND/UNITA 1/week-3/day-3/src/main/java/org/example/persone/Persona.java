package org.example.persone;

import jakarta.persistence.*;
import org.example.partecipazioni.Partecipazione;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

//@Table questa annotazione specifica il nome della tabella se il nome e uguale al nome della tabella non serve specificare con name tra parentesi
//entity per far gestire al framwork la classe, in oltre se non specifico il nome facendo: (name = "dipendenti"), il databese non avra problemi a riconoscere quale tabella fa parte l'entita
//Entity e Table posso utilizzarle grazie alle dipendenze runtime e spring-boot-starter-data-jpa

@Entity
@Table(name = "persona")
public class Persona {

    //l'id serve per specificare alla tabella quale la chiave primaria
    //@GeneratedValue: Questa annotazione specifica come gestire la generazione del valore della chiave primaria
    //strategy = GenerationType.SEQUENCE: Questa opzione specifica che il framework usi un sequenza per gestire la chiave primaria

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column serve in caso il nome di un dato non abbia lo stesso nome sulla tabella, con questa annotazione posso specificare in quale colonna sara destinata quella variabile

    private String nome;
    private String cognome;
    private String email;

    @Column(name = "data_nascita")
    private LocalDate dataNascita;

    //@Enumerated(EnumType.STRING) serve per specificare come gestire l'enumerazione

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoSesso sesso;

    //@OneToMany: Questa annotazione indica che un'istanza di ElementoMenu può avere molte istanze di Partecipazione associate.
    //mappedBy = "evento": Questa parte è fondamentale per definire la relazione come unidirezionale. Significa che la relazione è gestita solo dalla classe Partecipazione.

    @OneToMany(mappedBy = "persona")
    private List<Partecipazione> partecipazioni;

    public Persona() {

    }

    public Persona(String nome, String cognome, String email, TipoSesso sesso, LocalDate dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.sesso = sesso;
        this.dataNascita = dataNascita;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public TipoSesso getSesso() {
        return sesso;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public List<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSesso(TipoSesso sesso) {
        this.sesso = sesso;
    }

    public void setPartecipazioni(List<Partecipazione> partecipazioni) {
        this.partecipazioni = partecipazioni;
    }
}