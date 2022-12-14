package dev.lpa;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[] myIntegers = getIntegers(5);
        sort(myIntegers,0,myIntegers.length-1);
        printArray(myIntegers);
    }

    public static int[] getIntegers(int count) {
        int[] intArray = new int[count];
        System.out.println("Please enter " + count + " integers.");
        for (int i = 0; i < intArray.length; i++) {
            System.out.println("Number " + i + ": ");
            int n = scanner.nextInt();
            intArray[i] = n;
        }

        return intArray;
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print("]");
        System.out.println();
    }

    public static void sort(int[] array, int begin, int end) {
        int middle = (begin + end) / 2;
        if (begin < end) {
            sort(array, begin, middle);
            sort(array, middle + 1, end);
            merge(array, begin, middle, end);
        }
    }

    private static void merge(int[] array, int begin, int middle, int end) {
        int leftSize = middle - begin + 1;
        int rightSize = end - middle;

        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        // now load the respective integers into these  arrays
        for (int i = 0; i < leftSize; i++) {
            left[i] = array[i];
        }

        for (int i = 0; i < rightSize; i++) {
            right[i] = array[middle+1+i];
        }

        // now, we merge the numbers back into array
        int left_index = 0;
        int right_index = 0;
        int finish_index = begin;

        while (left_index < leftSize && right_index < rightSize) {
            if (left[left_index] <= right[right_index]) {
                array[finish_index] = left[left_index];
                left_index++;
            } else {
                array[finish_index] = right[right_index];
                right_index++;
            }
            finish_index++;
        }

        // need to put in the remaining (if there are) sub array elements into the main array
        while (left_index < leftSize) {
            array[finish_index] = left[left_index];
            left_index++;
            finish_index++;
        }

        while (right_index < rightSize ) {
            array[finish_index] = right[right_index];
            right_index++;
            finish_index++;
        }
    }
}











