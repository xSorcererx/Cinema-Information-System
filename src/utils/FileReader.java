/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class FileReader {

    public static ArrayList<Object[]> read(String filePath) throws FileNotFoundException {
        String next;
        ArrayList<Object[]> file_contents = new ArrayList<>();
        Scanner file = new Scanner(new File(filePath));
        file.useDelimiter(", ");
        while (file.hasNextLine()) {
            next = file.nextLine();
            String[] data = next.split(", ");
            Object[] new_data = new Object[data.length];
            new_data[0] = Integer.parseInt(data[0]);
            new_data[1] = data[1];
            new_data[2] = data[2];
            new_data[3] = Long.parseLong(data[3]);
            new_data[4] = data[4];
            new_data[5] = data[5];
            new_data[6] = Float.parseFloat(data[6]);
            file_contents.add(new_data);
        }
        return file_contents;
    }

    public static ArrayList<Object[]> read(File file_to_read) throws FileNotFoundException {
        String next;
        ArrayList<Object[]> file_contents = new ArrayList<>();
        Scanner file = new Scanner(file_to_read);
        file.useDelimiter(", ");
        while (file.hasNextLine()) {
            next = file.nextLine();
            String[] data = next.split(", ");
            Object[] new_data = new Object[data.length];
            new_data[0] = Integer.parseInt(data[0]);
            new_data[1] = data[1];
            new_data[2] = data[2];
            new_data[3] = Long.parseLong(data[3]);
            new_data[4] = data[4];
            new_data[5] = data[5];
            new_data[6] = Float.parseFloat(data[6]);
            file_contents.add(new_data);
        }
        return file_contents;
    }

    public static void main(String[] args) {
        try {
            ArrayList<Object[]> contents = read("G:\\hamro-cinema\\src\\resources\\kathmandu.csv");
            for (Object[] data : contents) {
                System.out.println(data.length);
                System.out.println("==============================");
                for (Object datum : data) {
                    System.out.println(datum);
                }
                System.out.println("------------------------------");
            }
            System.out.println(contents.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
    }
}
