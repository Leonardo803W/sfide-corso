public class Dirigente extends Dipendente {

    public Dirigente(String matricola)
    {
        super(matricola, 2500, Dipartimento.AMMINISTRAZIONE);
    }

    @Override
    public String toString() {
        return "matricola: " + getMatricola() + ", stipendio: " + getStipendio() + ", dipartimento: " + getDipartimento();
    }
}
