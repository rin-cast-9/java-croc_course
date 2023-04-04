import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    // the first realization using BufferedString
    public static int countWordsWithBufferedString (FileReader fileReader) throws IOException { // throws IOExcpetion 
        BufferedReader bufferedReader = new BufferedReader(fileReader); // intializes bufferedReader

        int count = -1; // intializes the count variable as -1 for counting words 
        String line = null; // intializes the line string for further usage 
        try {
            while ((line = bufferedReader.readLine()) != null) { // while readLine returns not null assigns 1 line from file to the line variable
                String[] words = (line.trim() + " ").split("\\s+"); // trims the line, appends a space in the end*, splits by multiple space (s+) and assigns it to the array of String
                // * so that empty lines be processed properly
                count += words.length; // adds the length (which is the words count) of the array
            }
        }
        catch (IOException exception) { // cathces IOException that might be thrown from the readLine method
            System.err.println("Couldn't read from file."); // prints a message
        }
        finally {
            bufferedReader.close(); // closes the file, might throw IOException so we have declared it up above
        }

        ++ count; // make up for that -1 during initialization

        return count; // returns count, it'd be some integer when everything goes smoothly or
                      // -1 when something wrong happens along the way or
                      // 0 when the file contains no words
    }

    // the second realization using Scanner
    public static int countWordsWithScanner (FileReader fileReader) {
        Scanner in = new Scanner(fileReader); // intializes in variable as Scanner

        int count = -1; // initializes the count varaible as -1 for counting words
        String line = null; // initializes the line string for further usage

        while (in.hasNext()) { // while the scanner has something to read
            line = in.next(); // reads a line from the file and assigns it to the line variable
            String[] words = (line.trim() + " ").split("\\s+"); // trims the line, appends a space in the end*, splits by multiple space (s+) and assigns it to the array of String
            // * so that empty lines be processed properly
            count += words.length; // adds the length (which is the words count) of the array
        }

        in.close(); // closes scanner

        ++ count; // make up for that -1 during initialization

        return count; // returns count, it'd be some integer when everything goes smoothly or
                      // -1 when something wrong happens along the way or
                      // 0 when the file contains no words
    }

    public static void main (String[] args) throws Exception {

        if (args.length == 0) { // checks if something is passed to args 
            System.err.println("No arguments were passed through the command line."); // if not then provides the message 
            throw new IllegalArgumentException(); // throws exception; the program won't be executed further
        }
        
        try (FileReader fileReader = new FileReader(args[0]); FileReader fileReader2 = new FileReader(args[0])) { // initializes 2 FileReaders with args[0] as a parameter
            // args[0] is the first argument passed when running from a command line
            System.out.println(countWordsWithScanner(fileReader)); // calls the countWrodsWithNext method and prints the returned result to the console 
            System.out.println(countWordsWithBufferedString(fileReader2)); // cals the countWordsWithBufferedString method and prints the returned result to the console
        }
        catch (FileNotFoundException exception) { // catches FileNotFoundException if the passed parameter has the wrong file name or path
            System.out.println("File not found."); // prints a message 
        }
        catch (IOException exception) {
            System.out.println("Couldn't read from file."); // prints a message 
        }
        
        System.exit(0);
    }
    
}
