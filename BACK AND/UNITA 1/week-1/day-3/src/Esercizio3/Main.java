package esercizio3;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente(1, "Mario", "Rossi", LocalDate.of(2023, 1, 1), "qB8xT@example.com");

        Articolo[] articoli = new Articolo[4];
        articoli[0] = new Articolo(1, "Televisore", 10.0, 5);
        articoli[1] = new Articolo(2, "Panda", 20.0, 2);
        articoli[2] = new Articolo(3, "Cuscino", 15.0, 3);
        articoli[3] = new Articolo(4, "pettine", 10.0, 0);

        Carrello carrello = new Carrello(articoli, cliente1);
        carrello.totale();
    }
}