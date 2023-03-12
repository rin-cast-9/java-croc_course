public class homework1 {
    
    public static void main (String[] args) {

        for (int i = 1; i <= 100; ++ i) { // iterates through integers from 0 to 100 (including)
            if ((i % 3 == 0) && (i % 5 == 0)) { // checks if it's divisbile by 5 and divisible by 3 simultaneously
                System.out.printf("FizzBuzz "); // prints out FizzBuzz
            }
            else if (i % 3 == 0) { // checks if it is divisible by 3
                System.out.printf("Fizz "); // prints out Fizz
            }
            else if (i % 5 == 0) { // checks if it is divisible by 5
                System.out.printf("Buzz "); // prints out Buzz
            }
            else { // if none of the above IFs aren't met then this block of code will be executed
                System.out.printf("%d ", i); // prints out the integer
            }
        }

    }

}
