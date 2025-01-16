package Esercizio3;

public class ContoOnline extends ContoCorrente
{
    private double maxPrelievo;

    public ContoOnline (String nome, double saldo, double maxP)
    {
        super(nome, saldo);
        this.maxPrelievo = maxP;
    }

    @Override
    public void stampaSaldo()
    {
        System.out.println("Titolare: " + getTitolare() + ", Saldo: " + getSaldo() + ", Num movimenti: " + getnMovimenti() + ", Massimo movimenti: " + getMaxMovimenti() + ", Massimo prelievi possibile: " + maxPrelievo);
    }

    @Override
    public void preleva (double x) throws BancaException
    {
        if (x >= maxPrelievo)
        {
            throw new BancaException("Attenzione!!! il prelievo supera il massimo disponibile.");
        }
        else
        {
            super.preleva(x);
        }
    }
}
