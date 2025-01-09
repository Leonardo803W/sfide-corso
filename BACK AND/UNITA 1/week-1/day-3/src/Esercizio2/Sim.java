package Esercizio2;

public class Sim {

    private String telefono;
    private double credito;
    private Chiamata[] listaChiamate;

    public Sim (String phon)
    {
        this.telefono = phon;
        this.credito = 0;
        this.listaChiamate = new Chiamata[5];
    }

    public void aggiungiCredito(double plusCredit)
    {
        System.out.println("Credito aumentato di: " + plusCredit + " Euro");
        this.credito += plusCredit;
    }

    public void setListaChiamate(Chiamata[] listaChiamate)
    {
        this.listaChiamate = listaChiamate;
    }

    public void stampaCredito()
    {
        System.out.println("Credito attualmente: " + this.credito);
    }

    public void usareCredito(double consumo)
    {
        double total;

        if(this.credito > 0)
        {
            total = credito - consumo;
            System.out.println("credito restante: " + total);
            this.credito = total;
        }
        else
        {
            System.out.println("Credito insufficiente");
        }
    }

    public  void stampaDati()
    {
        int contatore = 0;
        int i = 1;

        System.out.println("Sim: " + this.telefono);
        System.out.println("Credito a disposizione: " + this.credito + " Euro");

        do
        {
            System.out.println(i + " chiamata da: " + listaChiamate[contatore].getTelefonata() + "; durata della chiamata: " + listaChiamate[contatore].getDurata());
            contatore++;
            i++;

        }while (listaChiamate[contatore] != null);

    }
}
