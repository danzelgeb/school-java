package de.theunycraft.sfs;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] index = { 1, 3, 2, 5, 4, 7, 6, 12, 14, 8, 13, 15, 9, 10, 11 };
        //hello world
        System.out.println("Hello World!");
        //bubble sort
        bubbleSort(index);

        System.out.println(" ");
        System.out.println(" quick sort ");
        System.out.println("-----------------");

        //do quick sort
        quickSort(index);
        System.out.println("-----------------");

        System.out.println("Place input here: ");

        String input = "Hello World!";

        try (Scanner scanner = new Scanner(System.in)) {
            input = scanner.nextLine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("You entered: " + input);

        System.out.println("Deafult input = Hello World!");

    }

    
    public static void bubbleSort(int[] index) {
        int n = index.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (index[i] > index[j]) {
                    int temp = index[i];
                    index[i] = index[j];
                    index[j] = temp;
                }
            }
        }
        for (int i : index) {
            System.out.println(i);
        }

        print(index);

    }

    public static void quickSort(int[] index) {
        int low = 0;
        int high = index.length - 1;
        quickSort(index, low, high);
    }

    public static void quickSort(int[] index, int low, int high) {
        if (low < high) {
            int pi = partition(index, low, high);
            quickSort(index, low, pi - 1);
            quickSort(index, pi + 1, high);
            System.out.println(index[pi]);
        }
    }

    public static int partition(int[] index, int low, int high) {
        int pivot = index[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (index[j] < pivot) {
                i++;
                int temp = index[i];
                index[i] = index[j];
                index[j] = temp;
            }
        }
        int temp = index[i + 1];
        index[i + 1] = index[high];
        index[high] = temp;
        return i + 1;
    }

    private static void print(int[] index) {

        StringBuilder sb = new StringBuilder();
        for (int i : index) {
            sb.append(i);
            if (i != index[index.length - 1]) {
                sb.append(", ");
            }
        }
        System.out.println(sb);
    }

    public static void mergeSort(int[] index) {
        int n = index.length;

        if (n < 2) {
            return;
        }

        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = index[i];
        }

//        System.arraycopy(index, mid, right, 0, n - mid);

        for (int i = mid; i < n; i++) {
            right[i - mid] = index[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(index, left, right);
    }

    public static void merge(int[] index, int[] left, int[] right) {
        int nL = left.length;
        int nR = right.length;
        int i = 0, j = 0, k = 0;
        while (i < nL && j < nR) {
            if (left[i] <= right[j]) {
                index[k] = left[i];
                i++;
            } else {
                index[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < nL) {
            index[k] = left[i];
            i++;
            k++;
        }
        while (j < nR) {
            index[k] = right[j];
            j++;
            k++;
        }
    }
}
