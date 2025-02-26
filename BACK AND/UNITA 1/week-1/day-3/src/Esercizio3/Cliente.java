package esercizio3;

import java.time.LocalDate;

public class Cliente {

    //private indico la sicurezza di questa variabile, essendo private la si puo utilizzare unicamente nella sua classe per poterla avere o cambiare devo creare metodi pubblici con i vari set e get
    //se fosse stata con public non servirebbero i set e i get poiche potrei cambiare i valori d'ovunque io mi trovi
    //con protected potrei cambiare i valori senza i get e i set solo nel puckege al di fuori di quello ho bisogno dei set e get

    private int code;
    private String name;
    private String surname;
    private String email;
    private LocalDate dataIscrizione;

    //il costruttore permette di creare le istanze della classe, ricevendo i valori o tramite parametri o che vengano settati dentro al costruttore senza che siano passati come parametri

    public Cliente(int code, String name, String surname, LocalDate dataIscrizione, String email) {
        this.code = code;
        this.name = name;
        this.surname = surname;
        this.dataIscrizione = dataIscrizione;
        this.email = email;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDataIscrizione() {
        return dataIscrizione;
    }

    public void setDataIscrizione(LocalDate dataIscrizione) {
        this.dataIscrizione = dataIscrizione;
    }

    public void stampaDati() {
        System.out.println("Codice: " + code);
        System.out.println("Nome: " + name);
        System.out.println("Cognome: " + surname);
        System.out.println("Email: " + email);
        System.out.println("Data iscrizione: " + dataIscrizione);
    }
}
