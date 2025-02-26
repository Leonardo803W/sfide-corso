package esercizio3;

public class Articolo {

    //private indico la sicurezza di questa variabile, essendo private la si puo utilizzare unicamente nella sua classe per poterla avere o cambiare devo creare metodi pubblici con i vari set e get
    //se fosse stata con public non servirebbero i set e i get poiche potrei cambiare i valori d'ovunque io mi trovi
    //con protected potrei cambiare i valori senza i get e i set solo nel puckege al di fuori di quello ho bisogno dei set e get

    private int code;
    private String descriptions;
    private double price;
    private int quantity;

    //il costruttore permette di creare le istanze della classe, ricevendo i valori o tramite parametri o che vengano settati dentro al costruttore senza che siano passati come parametri

    public Articolo(int code, String descriptions, double price, int quantity) {
        this.code = code;
        this.descriptions = descriptions;
        this.price = price;
        this.quantity = quantity;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void stampaDati() {
        System.out.println("Code: " + code);
        System.out.println("Descriptions: " + descriptions);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }
}
