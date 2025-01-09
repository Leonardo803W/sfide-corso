package Esercizio3;

public class Articolo {

    private int code;
    private String name;
    private double price;
    private int stock;

    public Articolo (int codice, String nome, double prezzo)
    {
        this.code = codice;
        this.name = nome;
        this.price = prezzo;
        this.stock = 0;
    }

    public void stampaProdotto()
    {
        System.out.println("Codice prdotto: " + this.code);
        System.out.println("Nome prdotto: " + this.name);
        System.out.println("Prezzo prdotto: " + this.price);
        System.out.println("Di questo prodotto ne abbiamo ancora in magazzino: " + this.stock);
    }

    public void stampaMagazzino ()
    {
        System.out.println("in magazzino ne abbiamo: " + this.stock);
    }

    public void setStock (int magazzino)
    {
        this.stock = magazzino;
    }

    public int getCode ()
    {
        return this.code;
    }

    public String getName ()
    {
        return this.name;
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
