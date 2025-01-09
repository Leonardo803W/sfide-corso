package Esercizio2;

import java.util.Locale;

public class Chiamata {

    private String telefonata;
    private int durata;

    public Chiamata(String chiamata, int minuti)
    {
        this.telefonata = chiamata;
        this.durata = minuti;
    }

    public String getTelefonata()
    {
        return this.telefonata;
    }

    public int getDurata()
    {
        return  this.durata;
    }
}
