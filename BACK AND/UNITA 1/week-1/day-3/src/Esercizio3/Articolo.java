package Esercizio3;

public class Articolo {

    private String nome;
    private String description;
    private double price;
    private int stock;

    public Articolo (String codice, String descrizione, double prezzo)
    {
        this.nome = codice;
        this.description = descrizione;
        this.price = prezzo;
        this.stock = 0;
    }

    public void stampaProdotto()
    {
        System.out.println("Codice prdotto: " + this.nome);
        System.out.println("Nome prdotto: " + this.description);
        System.out.println("Prezzo prdotto: " + this.price);
        System.out.println("Di questo prodotto ne abbiamo ancora in magazzino: " + this.stock);
    }

    public void stampaMagazzino ()
    {
        System.out.println("in magazzino ne abbiamo: " + this.stock);
    }

    public void setStock (int magazzino)
    {
        System.out.println("Arrivato carico di " + this.nome + ", quantita: " + magazzino);
        this.stock = magazzino;
    }

    public String getNome ()
    {
        return this.nome;
    }

    public double getPrice ()
    {
        return this.price;
    }

    public int getStock ()
    {
        return this.stock;
    }
}
