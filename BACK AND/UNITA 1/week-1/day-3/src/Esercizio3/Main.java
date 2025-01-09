package Esercizio3;

public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente(001, "lorenzo", "mucci", "lore@gmial.com", "24/05/2020");
        Articolo telefono = new Articolo(001, "telefono", 500);

        telefono.stampaProdotto();
        telefono.setStock(1000);
        telefono.stampaMagazzino();
    }
}
