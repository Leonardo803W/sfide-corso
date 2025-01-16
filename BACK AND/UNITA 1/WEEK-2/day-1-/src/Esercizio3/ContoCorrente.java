package Esercizio3;

public class ContoCorrente
{
    private String titolare;
    private int nMovimenti;
    private final int maxMovimenti = 50;
    private double saldo;
    private double commissione = 0.50;

    public ContoCorrente (String nome, double saldo)
    {
        this.titolare = nome;
        this.saldo = saldo;
        this.nMovimenti = 0;
    }

    public void preleva (double x) throws BancaException
    {
        if (saldo < 0)
        {
            throw new BancaException("Attenzione!!! il conto e in rosso.");
        }

        if(nMovimenti < maxMovimenti)
        {
            saldo -= x;
        }
        else
        {
            saldo -= x - commissione;
        }

        nMovimenti++;
    }

    public double doublerestituisciSaldo()
    {
        return saldo;
    }

    public String getTitolare()
    {
        return titolare;
    }

    public double getSaldo()
    {
        return saldo;
    }

    public int getnMovimenti()
    {
        return nMovimenti;
    }

    public int getMaxMovimenti()
    {
        return maxMovimenti;
    }

    public void stampaSaldo()
    {
        System.out.println("Titolare: " + getTitolare() + ", Saldo: " + getSaldo() + ", Num movimenti: " + getnMovimenti() + ", Massimo movimenti: " + maxMovimenti);
    }
}
