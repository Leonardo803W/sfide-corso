import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //esercizio 1.1:

        //System.out.println("inserrire il primo numero a scelta: ");
        //int intero1 = scanner.nextInt();

        int intero1 = 5;

        //System.out.println("scegliere il secondo numero a scelta: ");
        //int intero2 = scanner.nextInt();
        int intero2 = 5;

        int prodotto = 0;

        System.out.println("il prodotto dei numeri e: " + intero1 * intero2);

        //esercizio 1.2:

        String world = "ciao";
        int number = 6;

        System.out.println(world + number);

        //esercizio 1.3:

        String[] resultArray = new String[6];

        String[] inputArray = {"A", "B", "C", "D", "E"};
        String word = "X";

        resultArray[0] = inputArray[0];
        resultArray[1] = inputArray[1];

        resultArray[2] = word;

        resultArray[3] = inputArray[2];
        resultArray[4] = inputArray[3];
        resultArray[5] = inputArray[4];

        System.out.println(Arrays.toString(resultArray));

        //esercizio 2.1:

        Scanner scanner = new Scanner(System.in);

        System.out.println("prima frase: ");
        String one = scanner.nextLine();

        System.out.println("seconda frase: ");
        String two = scanner.nextLine();

        System.out.println("terza frase: ");
        String three = scanner.nextLine();

        System.out.println("concatenazione: " + one + two + three);
        System.out.println("concatenzaione inversa: " + three + two + one);

        //esercizio 3.1:

        int n1 = 10;
        double n2 = 12.5;
        double perimeter = 0;
        perimeter =+ n1 + n2 + n1 + n2;

        System.out.println(perimeter);

        //esercizio 3.2

        int n3 = 4;

        if(n3 % 2 == 0)
        {
            System.out.println(0);
        }
        else
        {
            System.out.println(1);
        }

        //esercizio 3.3:

        double a = 2.5;
        double b = 4.2;
        double c = 5.6;

        double perimetro = a + b + c;
        System.out.println("Il perimetro del triangolo è: " + perimetro);

        double s = perimetro / 2;
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));

        System.out.println("L'area del triangolo è: " + area);
    }
}