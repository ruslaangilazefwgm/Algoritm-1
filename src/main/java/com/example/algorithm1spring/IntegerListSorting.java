package com.example.algorithm1spring;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class IntegerListSorting {
    public static void main(String[] args) {
        Random r = new Random(100_000);
        int i = r.nextInt();
        Integer[] arr = new Integer[100_000];
        Arrays.fill(arr, i);

        Integer[] arr2 = Arrays.copyOf(arr, 100_000);

        Integer[] arr3 = Arrays.copyOf(arr, 100_000);

        long start = System.currentTimeMillis();
        sortBubble(arr);         ///// = 14594
        System.out.println(System.currentTimeMillis() - start);
        sortSelection(arr2);     ///// = 22539
        System.out.println(System.currentTimeMillis() - start);
        sortInsertion(arr3);     ///// = 81452
        System.out.println(System.currentTimeMillis() - start);
    }

    private static void swapElements(Integer[] arr, int indexA, int indexB) {   //// избавление от дублирующего кода
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    public static void sortBubble(Integer[] arr) {    ////Пузырьковая сортировка
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }
    public static void sortSelection(Integer[] arr) { /////Сортировка выбором
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }
    public static void sortInsertion(Integer[] arr) {    ////Сортировка вставкой
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
}
