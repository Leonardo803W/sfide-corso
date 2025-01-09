package Esercizio3;

public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente(001, "lorenzo", "mucci", "lore@gmial.com", "24/05/2020");
        Cliente cliente2 = new Cliente(002, "gianni", "mucci", "bob@gmial.com", "24/05/2020");
        Articolo telefono = new Articolo("phone", "telefono", 500);
        Articolo tv = new Articolo("tv", "enorme", 1000);

        telefono.stampaProdotto();
        System.out.println("-----------------");
        cliente1.stampaDatiCliente();
        System.out.println("-----------------");
        telefono.setStock(1000);
        System.out.println("-----------------");

        Carello carello1 = new Carello(cliente1);
        Articolo[] listaArticoliComprati = {telefono, tv};
        carello1.setElencoArticoli(listaArticoliComprati);
        carello1.getElencoArticoli();
        carello1.getTotalCostoArticoli();
        //carello1.setCliente(cliente2);
        //Articolo[] listaArticoliComprati2 = {tv};
        Carello carello2 = new Carello(cliente2);
        carello2.getTotalCostoArticoli();
    }
}
