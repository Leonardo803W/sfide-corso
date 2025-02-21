package org.example.partecipazioni;

import jakarta.persistence.*;
import org.example.eventi.Evento;
import org.example.persone.Persona;

//@Table questa annotazione specifica il nome della tabella se il nome e uguale al nome della tabella non serve specificare con name tra parentesi
//entity per far gestire al framwork la classe, in oltre se non specifico il nome facendo: (name = "dipendenti"), il databese non avra problemi a riconoscere quale tabella fa parte l'entita
//Entity e Table posso utilizzarle grazie alle dipendenze runtime e spring-boot-starter-data-jpa

@Entity
@Table(name = "partecipazione")
public class Partecipazione {

    //l'id serve per specificare alla tabella quale la chiave primaria
    //@GeneratedValue: Questa annotazione specifica come gestire la generazione del valore della chiave primaria
    //strategy = GenerationType.SEQUENCE: Questa opzione specifica che il framework usi un sequenza per gestire la chiave primaria

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@ManyToOne: Questa annotazione indica che un'istanza di Partecipazione può essere associata a una sola istanza di Evento.
    //In altre parole, molti partecipanti possono essere associati allo stesso evento, ma ogni partecipante è associato a un solo evento.
    //@JoinColumn(name = "evento_id") Questa annotazione specifica come la relazione è implementata nel database

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    //@Enumerated(EnumType.STRING) serve per specificare come gestire l'enumerazione

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoPartecipazione stato;

    public Partecipazione(){

    }

    public Partecipazione(Persona persona, Evento evento, TipoPartecipazione stato) {
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }

    public Long getId() {
        return id;
    }

    public Persona getPersona() {
        return persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public TipoPartecipazione getStato() {
        return stato;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public void setStato(TipoPartecipazione stato) {
        this.stato = stato;
    }
}