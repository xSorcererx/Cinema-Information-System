/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.ArrayList;


public class MergeSort {

    public static void reverse(int[] array) {
        int array_copy[] = array.clone();
        int j = array.length - 1;
        for (int i = 0; i < array_copy.length; i++) {
            array[i] = array_copy[j];
            j -= 1;
        }
    }

    public static void reverse(ArrayList array) {
        ArrayList array_copy = (ArrayList) array.clone();
        int j = array.size() - 1;
        for (int i = 0; i < array_copy.size(); i++) {
            array.set(i, array_copy.get(j));
            j -= 1;
        }
    }

    public static void sort(ArrayList<Object[]> sortThis, boolean sortOnTicketPrice) {
        // new merge sort for the table data
        if (sortThis.size() <= 1) {
            return;
        }
        // Separating groups from the array
        ArrayList<Object[]> group1 = new ArrayList();
        ArrayList<Object[]> group2 = new ArrayList();
        int group1_length = sortThis.size() / 2;
        int group2_length = sortThis.size() - group1_length;
        // adding to the first group
        for (int i = 0; i < group1_length; i++) {
            group1.add(sortThis.get(i));
        }
        // adding to the second group
        for (int i = 0; i < group2_length; i++) {
            group2.add(sortThis.get(group1_length + i));
        }

        sort(group1, sortOnTicketPrice);
        sort(group2, sortOnTicketPrice);
        if (sortOnTicketPrice) {
            merge(group1, group2, sortThis);
        } else {
            mergeOnName(group1, group2, sortThis);
        }
    }

    public static void mergeOnName(ArrayList<Object[]> group1, ArrayList<Object[]> group2, ArrayList<Object[]> sortThis) {
        // Initializing index counters for each array.
        int group1_index = 0; // Index for group1
        int group2_index = 0; // Index for group2
        int sortThis_index = 0; // Index for sortThis

        // Adding values to the sortThis from group1 and group2
        while (group1_index < group1.size() && group2_index < group2.size()) {
            if (((String) group1.get(group1_index)[1]).toUpperCase().compareTo(((String) group2.get(group2_index)[1]).toUpperCase()) < 0) {
                sortThis.set(sortThis_index, group1.get(group1_index));
                group1_index++;
            } else {
                sortThis.set(sortThis_index, group2.get(group2_index));
                group2_index++;
            }
            sortThis_index++;
        }
        // Adding the remaining values from either group1 or group2 array.
        while (group1_index < group1.size()) {
            sortThis.set(sortThis_index, group1.get(group1_index));
            group1_index++;
            sortThis_index++;
        }
        while (group2_index < group2.size()) {
            sortThis.set(sortThis_index, group2.get(group2_index));
            group2_index++;
            sortThis_index++;
        }
    }

    public static void merge(ArrayList<Object[]> group1, ArrayList<Object[]> group2, ArrayList<Object[]> sortThis) {
        // Initializing index counters for each array.
        int group1_index = 0; // Index for group1
        int group2_index = 0; // Index for group2
        int sortThis_index = 0; // Index for sortThis

        // Adding values to the sortThis from group1 and group2
        while (group1_index < group1.size() && group2_index < group2.size()) {
            if ((float) group1.get(group1_index)[6] < (float) group2.get(group2_index)[6]) {
                sortThis.set(sortThis_index, group1.get(group1_index));
                group1_index++;
            } else {
                sortThis.set(sortThis_index, group2.get(group2_index));
                group2_index++;
            }
            sortThis_index++;
        }
        // Adding the remaining values from either group1 or group2 array.
        while (group1_index < group1.size()) {
            sortThis.set(sortThis_index, group1.get(group1_index));
            group1_index++;
            sortThis_index++;
        }
        while (group2_index < group2.size()) {
            sortThis.set(sortThis_index, group2.get(group2_index));
            group2_index++;
            sortThis_index++;
        }
    }

    public static void sort(int[] sortThis) {
        if (sortThis.length <= 1) {
            return;
        }
        // Seperating groups from the array
        int[] group1 = new int[sortThis.length / 2];
        int[] group2 = new int[sortThis.length - group1.length];

        // Adding to first group
        for (int i = 0; i < group1.length; i++) {
            group1[i] = sortThis[i];
        }
        // Adding to second group
        for (int i = 0; i < group2.length; i++) {
            group2[i] = sortThis[group1.length + i];
        }

        sort(group1);
        sort(group2);
        merge(group1, group2, sortThis);

    }

    public static void sort(String[] sortThis) {
        if (sortThis.length <= 1) {
            return;
        }
        // Seperating groups from the array
        String[] group1 = new String[sortThis.length / 2];
        String[] group2 = new String[sortThis.length - group1.length];

        // Adding to first group
        for (int i = 0; i < group1.length; i++) {
            group1[i] = sortThis[i];
        }
        // Adding to second group
        for (int i = 0; i < group2.length; i++) {
            group2[i] = sortThis[group1.length + i];
        }

        sort(group1);
        sort(group2);
        merge(group1, group2, sortThis);

    }

    public static void merge(String[] group1, String[] group2, String[] sortThis) {
        // Initializing index counters for each array.
        int group1_index = 0; // Index for group1
        int group2_index = 0; // Index for group2
        int sortThis_index = 0; // Index for sortThis

        // Adding values to the sortThis from group1 and group2
        while (group1_index < group1.length && group2_index < group2.length) {
            if (group1[group1_index].compareTo(group2[group2_index]) < 0) {
                sortThis[sortThis_index] = group1[group1_index];
                group1_index++;
            } else {
                sortThis[sortThis_index] = group2[group2_index];
                group2_index++;
            }
            sortThis_index++;
        }

        // Adding the remaining values from either group1 or group2 array.
        while (group1_index < group1.length) {
            sortThis[sortThis_index] = group1[group1_index];
            group1_index++;
            sortThis_index++;
        }
        while (group2_index < group2.length) {
            sortThis[sortThis_index] = group2[group2_index];
            group2_index++;
            sortThis_index++;
        }
    }

    public static void merge(int[] group1, int[] group2, int[] sortThis) {
        // Initializing index counters for each array.
        int group1_index = 0; // Index for group1
        int group2_index = 0; // Index for group2
        int sortThis_index = 0; // Index for sortThis

        // Adding values to the sortThis from group1 and group2
        while (group1_index < group1.length && group2_index < group2.length) {
            if (group1[group1_index] < group2[group2_index]) {
                sortThis[sortThis_index] = group1[group1_index];
                group1_index++;
            } else {
                sortThis[sortThis_index] = group2[group2_index];
                group2_index++;
            }
            sortThis_index++;
        }

        // Adding the remaining values from either group1 or group2 array.
        while (group1_index < group1.length) {
            sortThis[sortThis_index] = group1[group1_index];
            group1_index++;
            sortThis_index++;
        }
        while (group2_index < group2.length) {
            sortThis[sortThis_index] = group2[group2_index];
            group2_index++;
            sortThis_index++;
        }
    }

    public static void main(String[] args) {
        ArrayList<Object[]> arr = new ArrayList<Object[]>();
        Object[] a = {100, "Hello"};
        Object[] b = {105, "Hello"};
        Object[] c = {101, "Hello"};
        Object[] d = {106, "Hello"};
        Object[] e = {50, "Hello"};
        Object[] f = {124, "Hello"};
        arr.add(a);
        arr.add(b);
        arr.add(c);
        arr.add(d);
        arr.add(e);
        arr.add(f);
//        sort(arr);
        arr.forEach((z) -> {
            System.out.println(z[0] + " - " + z[1]);
        });
    }
}
