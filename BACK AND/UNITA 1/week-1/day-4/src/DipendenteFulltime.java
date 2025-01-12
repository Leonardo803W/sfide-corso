public class DipendenteFulltime extends Dipendente {

    private int ore;

    public DipendenteFulltime(String matricola, double guadagno, Dipartimento dipartimento)
    {
        super(matricola, guadagno, dipartimento);
        this.ore = 40;
    }

    @Override
    public String toString() {
        return "matricola: " + getMatricola() + ", stipendio: " + getStipendio() + ", dipartimento: " + getDipartimento() + ", ore all'attivo: " + ore;
    }
}
