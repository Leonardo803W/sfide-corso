package Esercizio3;

public class Cliente {

    private int codeClint;
    private String nameClinte;
    private String cognome;
    private String email;
    private String date;

    public Cliente (int codiceClint, String nomeClinte, String cognomeClint, String emailClint, String data)
    {
        this.codeClint = codiceClint;
        this.nameClinte = nomeClinte;
        this.cognome = cognomeClint;
        this.email = emailClint;
        this.date = data;
    }

    public void stampaDatiCliente()
    {
        System.out.println("Codice del cliente: " + this.codeClint);
        System.out.println("Nome del cliente: " + this.nameClinte);
        System.out.println("Cognome del cliente: " + this.cognome);
        System.out.println("Email del cliente: " + this.email);
        System.out.println("Data di iscrizione del cliente: " + this.date);
    }

    public int getCodeClint ()
    {
        return this.codeClint;
    }

    public String getNameClinte ()
    {
        return this.nameClinte;
    }

    public String getCognome ()
    {
        return this.cognome;
    }

    public String getEmail ()
    {
        return this.email;
    }

    public String getDate ()
    {
        return this.date;
    }
}
