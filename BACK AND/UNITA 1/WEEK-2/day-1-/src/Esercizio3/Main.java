package Esercizio3;

public class Main {
    public static void main(String[] args) {

        ContoCorrente conto1 = new ContoCorrente("Stefano", 500);
        ContoOnline online1 = new ContoOnline("Carlo", 5000, 1000);

        try {
            conto1.preleva(50);
            online1.preleva(50);
        }
        catch (BancaException e)
        {
            throw new RuntimeException(e.getMessage());
        }


        conto1.stampaSaldo();
        online1.stampaSaldo();

        try {
            conto1.preleva(500);
            conto1.preleva(100);
            online1.preleva(5000);
        }
        catch (BancaException e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }
}