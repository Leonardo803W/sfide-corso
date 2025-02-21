package org.example.locations;

import jakarta.persistence.*;

//@Table questa annotazione specifica il nome della tabella se il nome e uguale al nome della tabella non serve specificare con name tra parentesi
//entity per far gestire al framwork la classe, in oltre se non specifico il nome facendo: (name = "dipendenti"), il databese non avra problemi a riconoscere quale tabella fa parte l'entita
//Entity e Table posso utilizzarle grazie alle dipendenze runtime e spring-boot-starter-data-jpa

@Entity
@Table(name = "location")
public class Location {

    //l'id serve per specificare alla tabella quale la chiave primaria
    //@GeneratedValue: Questa annotazione specifica come gestire la generazione del valore della chiave primaria
    //strategy = GenerationType.SEQUENCE: Questa opzione specifica che il framework usi un sequenza per gestire la chiave primaria

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String citta;

    public Location() {

    }

    public Location(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }
}