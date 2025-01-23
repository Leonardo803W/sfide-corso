package epicode.entitys;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "dataevento")
    private LocalDate dataEvento;

    @Column(name = "descrizione")
    private String descrizione;

    @Enumerated
    @Column(name = "tipoevento")
    private TipoEvento tipoEvento;

    @Column(name = "numeromassimopartecipanti")
    private int numeroMassimoPartecipanti;

    public Evento(){

    }

    public Evento (String title, LocalDate date, String description, TipoEvento evento, int maxP)
    {
        this.titolo = title;
        this.dataEvento = date;
        this.descrizione = description;
        this.tipoEvento = evento;
        this.numeroMassimoPartecipanti = maxP;
    }


    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public Long getId() {
        return id;
    }
}
