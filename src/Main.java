package src;

import java.util.*;
import java.time.Duration;
import java.time.Instant;

public class Main {
    public static void selectionSort(ArrayList<Integer> sortIntArr) {
        for (int i = 0; i < sortIntArr.size(); i++) {
            int pos = i;
            int min = sortIntArr.get(i);
            //цикл выбора наименьшего элемента
            for (int j = i + 1; j < sortIntArr.size(); j++) {
                if (sortIntArr.get(j) < min) {
                    //pos - индекс наименьшего элемента
                    pos = j;
                    min = sortIntArr.get(j);
                }
            }
            sortIntArr.set(pos, sortIntArr.get(i));
            //меняем местами наименьший с sortArr[i]
            sortIntArr.set(i, min);
        }
    }

    public static void printIntArray(ArrayList<Integer> sortIntArr) {
        System.out.println("Beginning or array");
        for (Integer i : sortIntArr) {
            System.out.print(i + " ");
        }
        System.out.println("End or array");
    }

    public static void duration(Instant start, Instant end) {
        System.out.println("Time taken: " + Duration.between(start, end).toMillis() + " milliseconds");
    }

    public static void main(String args[]) {
        int length = (int) ((Math.random() * 1000) + 100000);

        Instant start;
        Instant end;

        ArrayList<Integer> sortArr = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            sortArr.add(i, (int) (Math.random() * 30));
        }

        ArrayList<Integer> sortArr2;
        sortArr2 = sortArr;

        //размер массива не позволяет его вывести наглядно
        //printIntArray(sortArr);

        start = Instant.now();

        selectionSort(sortArr);

        end = Instant.now();

        duration(start, end);

        //размер массива не позволяет его вывести наглядно
        //printIntArray(sortArr);

        start = Instant.now();

        Collections.sort(sortArr2);

        end = Instant.now();

        duration(start, end);

    }
}