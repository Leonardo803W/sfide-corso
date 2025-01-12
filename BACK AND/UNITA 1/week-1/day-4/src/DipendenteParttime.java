public class DipendenteParttime extends Dipendente {

    private int ore;

    public DipendenteParttime(String matricola, double guadagno, Dipartimento dipartimento)
    {
        super(matricola, guadagno, dipartimento);
        this.ore = 0;
    }

    public void aumentaOreFulltime(int time)
    {
        if (ore > 0)
        {
            System.out.println("ore aggiunte: " + time);
            ore += time;
        }
        else
        {
            System.out.println("non si puo avere ore in negqativo");
        }
    }

    public void diminuisciOreFulltime(int time)
    {
        if (ore > 0)
        {
            System.out.println("ore tolte: " + time);
            ore -= time;
        }
        else
        {
            System.out.println("non si puo avere ore in negativo");
        }
    }

    @Override
    public String toString() {
        return "matricola: " + getMatricola() + ", stipendio: " + getStipendio() + ", dipartimento: " + getDipartimento() + ", ore all'attivo: " + ore;
    }
}
