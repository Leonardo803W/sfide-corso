package esercizio2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //inizializzo nuovi ogetti con new tramite le istanze di sim e di chiamata, ovvero metto cio il costruttore ha bisogno come parametri
        //le chiamate sono un array, e posso settare come un array perche nel metodo di set di Sim gli ho detto che riceve come parametro un array
        Sim sim1 = new Sim("1234567890");

        Chiamata[] listaChiamate = new Chiamata[5];
        listaChiamate[0] = new Chiamata("1234567890", 10);
        listaChiamate[1] = new Chiamata("1234567890", 20);
        listaChiamate[2] = new Chiamata("1234567890", 30);

        //con get ottengo i valori delle istanze dell'ogetto appena creato

        System.out.println(sim1.getNumberPhon());
        System.out.println(sim1.getCredit());

        //Arrays.toString(): Questa funzione Java prende un array come input e lo converte in una stringa leggibile. Questa stringa rappresenta gli elementi dell'array separati da virgole e racchiusi tra parentesi quadre
        System.out.println(Arrays.toString(sim1.getContacts()));

        //con set cambio i valori delle istanze dell'ogetto
        //in caso di Chiamata cambio il valore ma essendo un array gli devo dire quale valore cambio in quale posizione

        System.out.println("Seconda chiamata dal numero: " + listaChiamate[1].getNumberPhon());
        System.out.println("Durata della chiamata: " + listaChiamate[1].getDuration());
        listaChiamate[1].setNumberPhon("3459160462");
        listaChiamate[1].setDuration(50);
        System.out.println("Seconda chiamata dal numero: " + listaChiamate[1].getNumberPhon());
        System.out.println("Durata della chiamata: " + listaChiamate[1].getDuration());

        sim1.setCredit(1000);
        sim1.setNumberPhon("3459160462");
        sim1.setContacts(listaChiamate);


        sim1.stampaDati();
    }
}