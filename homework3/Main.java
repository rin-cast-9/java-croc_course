import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main (String[] args) {

        ChessboardCoordinates chessboardCoordinates = new ChessboardCoordinates(); // initializes empty object of chessboardCoordinates class

        try (Scanner in = new Scanner(System.in)) { // so that we won't need to in.close()
            boolean flag = true; // flag for the while loop below
            while (flag) {
                System.out.println("enter chessboard coordinates: (e.g. \"3 2\")"); // asks a user to enter the coordinates providing with an example "3 2"
                try { 
                    chessboardCoordinates.setX(in.nextInt()); // reads x coordinate
                    chessboardCoordinates.setY(in.nextInt()); // reads y coordinate
                    System.out.println(chessboardCoordinates.toString()); // prints coordinates using the actual chessboard notation
                }
                catch (InputMismatchException exception) { // catches exception thrown by the nextInt() method i.e. an incorrect input
                    System.err.printf("Incorrect input. Try again...%n"); // provides a user with an appropriate message
                }
                catch (IllegalArgumentException exception) { // catches exception thrown by our setX() and setY() methods
                    System.err.printf("%s. Try again...%n", exception.getMessage()); // provides a user with an appropriate message
                }
                in.nextLine(); // as a user presses enter there's a line that would otherwise skip the nextInt() below  
                System.out.println("continue? 0 to stop / 1 or any integer to continue"); // asks a user whether to continue or to stop the programm 
                int check = in.nextInt(); // takes input from a user
                flag = (check != 0); // sets the flag according to the user's input
            }
        }

    }

}