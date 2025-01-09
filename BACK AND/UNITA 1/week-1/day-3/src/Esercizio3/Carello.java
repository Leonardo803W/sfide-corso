package Esercizio3;

public class Carello {

    private Cliente cliente;
    private Articolo[] elencoArticoli;

    public Carello (Cliente consumatore)
    {
        this.cliente = consumatore;
        this.elencoArticoli = new Articolo[0];
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Articolo[] getElencoArticoli() {
        return elencoArticoli;
    }

    public void setElencoArticoli(Articolo[] elencoArticoli) {
        this.elencoArticoli = elencoArticoli;
    }

    public double getTotalCostoArticoli()
    {
        double total = 0;

        for (int i = 0; i < elencoArticoli.length; i++)
        {
            int disponibilita = elencoArticoli[i].getStock();

            if (disponibilita == 0)
            {
                System.out.println("Abbiamo terminato la disponibilità di: " + elencoArticoli[i].getName());
            }
            else
            {
                total += elencoArticoli[i].getPrice();
            }
        }
        return  total;
    }
}
