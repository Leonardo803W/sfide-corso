//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //esercizio 1

        String stringaPariDispari = "aqunamatat";

        if(stringaPariDispari.length() % 2 == 0)
        {
            System.out.println("la stringa e pari");
        }
        else
        {
            System.out.println("la stringa e dispari");
        }

        annoBisestile(2024);
    }

        public static boolean annoBisestile(int anno) {

            if (anno % 400 == 0) {
            } else if (anno % 4 == 0 && anno % 100 != 0) {
                System.out.println("l'anno " + anno + " e bisestile");
            } else {
                System.out.println("l'anno " + anno + " non e bisestile");
            }
            return false;
        }
}