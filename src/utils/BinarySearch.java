/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;


public class BinarySearch {

    public static int search(int[] searchThis, int lIndex, int rIndex, int toSearch) {
        if (lIndex > rIndex) {
            return -1;
        }
        int mid = (lIndex + rIndex) / 2;
        if (toSearch == searchThis[mid]) {
            return mid;
        } else if (toSearch < searchThis[mid]) {
            return search(searchThis, lIndex, mid - 1, toSearch);
        } else {
            return search(searchThis, mid + 1, rIndex, toSearch);
        }
    }

    public static int search(float[] searchThis, int lIndex, int rIndex, float toSearch) {
        if (lIndex > rIndex) {
            return -1;
        }
        int mid = (lIndex + rIndex) / 2;
        if (toSearch == searchThis[mid]) {
            return mid;
        } else if (toSearch < searchThis[mid]) {
            return search(searchThis, lIndex, mid - 1, toSearch);
        } else {
            return search(searchThis, mid + 1, rIndex, toSearch);
        }
    }

    public static int search(String[] searchThis, int lIndex, int rIndex, String toSearch) {
        if (lIndex > rIndex) {
            return -1;
        }
        int mid = (lIndex + rIndex) / 2;
        if (toSearch.equals(searchThis[mid])) {
            return mid;
        } else if (toSearch.compareTo(searchThis[mid]) < 0) {
            return search(searchThis, lIndex, mid - 1, toSearch);
        } else {
            return search(searchThis, mid + 1, rIndex, toSearch);
        }
    }

    public static void main(String[] args) {
        String[] a = {"Bigmovies", "Fcube", "Qfx"};
        int i = search(a, 0, a.length - 1, "Qfx");
        System.out.println(i);
    }
}
