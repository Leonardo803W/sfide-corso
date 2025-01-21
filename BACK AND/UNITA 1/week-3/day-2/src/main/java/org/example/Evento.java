package org.example;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "eventi")

public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "data")
    private LocalDate date;

    @Column(name = "descrizione")
    private String descrizione;

    @Enumerated(EnumType.STRING)
    private tipoEvento tipoDelEvento;

    @Column(name = "maxPersone")
    private int numeroMassimoPartecipanti;

    public Evento (String title, LocalDate date, String description, tipoEvento event, int maxP)
    {
        this.titolo = title;
        this.date = date;
        this.descrizione = description;
        this.tipoDelEvento = event;
        this.numeroMassimoPartecipanti = maxP;
    }


    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitolo()
    {
        return titolo;
    }

    public void setTitolo(String titolo)
    {
        this.titolo = titolo;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public String getDescrizione()
    {
        return descrizione;
    }

    public void setDescrizione(String descrizione)
    {
        this.descrizione = descrizione;
    }

    public tipoEvento getTipoDelEvento()
    {
        return tipoDelEvento;
    }

    public void setTipoDelEvento(tipoEvento tipoDelEvento)
    {
        this.tipoDelEvento = tipoDelEvento;
    }

    public int getNumeroMassimoPartecipanti()
    {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti)
    {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }
}
