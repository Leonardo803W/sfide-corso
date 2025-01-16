package Esercizio3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main3
{
    public static void main(String[] args)
    {
        int n = 5;

        List<Integer> randomIntegers = getRandomList(n);
        List<Integer> reverse = reverseList(randomIntegers);

        System.out.println("numeri casuali: ");
        printList(randomIntegers);
        System.out.println("--------------------");
        System.out.println("numeri invertiti: ");
        printList(reverse);
        System.out.println("--------------------");
        System.out.println("numeri pari: ");
        pasteList(randomIntegers, true);
        System.out.println("--------------------");
        System.out.println("numeri dispari: ");
        pasteList(randomIntegers, false);
        System.out.println("--------------------");
        System.out.println("numeri pari: ");
        pasteList(reverse, true);
        System.out.println("--------------------");
        System.out.println("numeri dispari: ");
        pasteList(reverse, false);
        System.out.println("--------------------");
    }

    public static List<Integer> getRandomList(int n)
    {
        List<Integer> arr = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 0; i < n; i++)
        {
            arr.add(rnd.nextInt(0, 101));
        }

        Collections.sort(arr);
        return arr;
    }

    public static List<Integer> reverseList(List<Integer> list)
    {
        List<Integer> arr = new ArrayList<>(list);

        for (int i = list.size() - 1; i >= 0; i--)
        {
            arr.add(list.get(i));
        }
        return arr.reversed();
    }

    public static void printList(List<Integer> list)
    {
        System.out.println(list.size());
        int index = 0;

        for (Integer intero : list)
        {
            index++;
            System.out.println("Posizione " + index + ": " + intero);

        }
    }

    public static void pasteList (List<Integer> list, boolean show)
    {
        System.out.println(list.size());
        String dinamic = show ? "pari" : "dispari";
        int index = 0;

        for (Integer intero : list)
        {
            index++;

            if (show)
            {
                if (index % 2 == 0)
                {
                    System.out.println("Posizione " + index + ": " + intero);
                }
            }
            else
            {
                if (index % 2 != 0)
                {
                    System.out.println("Posizione " + index + ": " + intero);
                }
            }
        }
    }
}
