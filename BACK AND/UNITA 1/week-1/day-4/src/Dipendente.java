public abstract class Dipendente {

    private String matricola;
    private double stipendio;
    private Dipartimento dipartimento;

    public Dipendente (String matricola, double guadagno, Dipartimento dipartimento)
    {
        this.matricola = matricola;
        this.stipendio = guadagno;
        this.dipartimento = dipartimento;
    }

    public String getMatricola() {
        return matricola;
    }

    public double getStipendio() {
        return stipendio;
    }

    public Dipartimento getDipartimento() {
        return dipartimento;
    }

    public void setDipartimento(Dipartimento dipartimento) {
        this.dipartimento = dipartimento;
    }

    public String toString() {
        return "matricola: " + matricola + ", stipendio: " + stipendio + ", dipartimento: " + dipartimento;
    }
}
