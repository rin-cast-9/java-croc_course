import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


public class Main {

    /**
     * <p> Checks if the passed file path is valid </p>
     * @param path path to file
     * @return ture if the path is valid, false otherwise
     */
    public static boolean isValidPath (String path) {
        try {
            Paths.get(path); // converts the string to Path and if it's possible then the path is valid
        }
        catch (InvalidPathException | NullPointerException exception) { // if the path is invalid or there's a null pointer returns false
            return false;
        }
        return true;
    }

    /**
     * <p> Normalizes the path passed </p>
     * @param path path to file
     * @return a string of the normalized path
     */
    public static String normalizePath (String path) {
        String[] splittedPath = path.split("/"); // splits the path by slash sign

        Deque <String> pathElements = new ArrayDeque <> (); // stack implemented with deque where path elements (i.e. folders) is stored temporarily

        for (String pathElement : splittedPath) { // loops through elements of the path
            if (pathElement.equals("..")) { // checks if the element is ".."
                pathElements.removeFirst(); // if it is then pops the first element from the stack
                if (pathElements.isEmpty()) { // checks if the stack is empty after this
                    pathElements.addFirst(".."); // if it is then it pushes ".." to denote the parent directory
                }
            }
            else { // otherwise, adds the element into the stack
                pathElements.addFirst(pathElement);
            }
        }

        StringBuffer result = new StringBuffer(); // initializes result as a StringBuffer

        boolean slashFlag = false; // this flag is to not print the first slash character 
        while (!pathElements.isEmpty()) { // while the deque isn't empty
            if (slashFlag == true) {
                result.append("/"); // executed everytime except for the first one
            }
            slashFlag = true;
            result.append(pathElements.peekLast()); // appends the last element
            pathElements.removeLast(); // removes the last element from the deque
        }

        return result.toString(); // returns the result converted to string 
    }

    public static void main(String[] args) {
        
        try (Scanner in = new Scanner(System.in)) { // try with Scanner
            System.out.println("Enter the file path:");
            String path = in.nextLine(); // reads a path from a user
            if (isValidPath(path)) { // checks if the path is valid
                System.out.println(normalizePath(path)); // normalizes it and prints it if it's valid
            }
            else { // otherwise tells the user that the path is not valid
                System.err.println("Invalid string");
            }
        }

    }

}