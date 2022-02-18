package edu.wctc;

import java.io.*;
import java.util.Scanner;

public class Main {
    private static Scanner keyboard = new Scanner(System.in);;

    private static PaintCalculator paintCalculator;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        paintCalculator = new PaintCalculator();
        String selection = "";
        while (!selection.equals("exit program")) {
            printMenu();
            selection = keyboard.nextLine();

            switch(selection){
                case "add room":
                    createRoom();
                    break;
                case "view rooms":
                    System.out.println(paintCalculator.toString());
                    break;
                case "read rooms from file":
                    readFile();
                    break;
                case "write rooms to file":
                    try {//
                        writeFile();//
                    } catch (IOException e) {
                        System.out.println();
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }

        }
    }

    private static void printMenu() {
        System.out.println("Options: add room, view rooms, read rooms from file, " +
                "write rooms to file, exit program");
    }

    private static double promptForDimension(String dimensionName) {
        System.out.println("Enter a number for the " + dimensionName);
        return Double.parseDouble(keyboard.nextLine());
    }

    private static void createRoom() {
        double dimensions1 = promptForDimension("length");
        double dimensions2 = promptForDimension("width");
        double dimensions3 = promptForDimension("height");
        paintCalculator.addRoom(dimensions1, dimensions2, dimensions3);
    }

    private static void readFile() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("paintrooms.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);

        // read a single object from file
        paintCalculator = (PaintCalculator)ois.readObject();

    }

    private static void writeFile() throws IOException {
        FileOutputStream fos = new FileOutputStream("paintrooms.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // write a single object to file
        oos.writeObject(paintCalculator);

        oos.close();

    }
}
