import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

/**
 * Стартовый класс.
 */
public class Main {

    /**
     * Пример входной строки.
     */
    public static final String INPUT_STRING = "Невежество есть мать промышленности, как и суеверий." +
        " Сила размышления и воображения подвержена ошибкам; но привычка двигать рукой или ногой" +
        " не зависит ни от того, ни от другого. Поэтому мануфактуры лучше всего процветают там, где" +
        " наиболее подавлена духовная жизнь, так что мастерская может рассматриваться как машина," +
        " части которой составляют люди.";

    /**
     * Шаблон поиска символов в строке.
     */
    public static final String TEMPLATE = " ";

    /**
     * Точка входа в приложение.
     *
     * @param args аргументы командной строки.
     */
    public static void main(String[] args) {

        long current = System.currentTimeMillis();

        int sum = 0;
        ExecutorService executorService = Executors.newFixedThreadPool(INPUT_STRING.length()); // initializes ExecutorService with fixed thread pool the size of the INPUT_STRING length
        ArrayList <Future <Boolean>> results = new ArrayList <Future <Boolean>> (); // array of future of boolean type for storing the results of threads returned values

        // uses stream to iterate over each character in the given string
        // for each character it creates a new Callable task using a lambda expression that calls the Matcher.match() method
        // then submits this task to the executorService using the submit() method
        // the resulting Future <Boolean> object is then added to the results ArrayList
        IntStream.range(0, INPUT_STRING.length()).forEach(item -> {
            results.add(executorService.submit(() -> Matcher.match(String.valueOf(INPUT_STRING.charAt(item)), TEMPLATE)));
        });

        executorService.shutdown(); // shutdowns previously submitted and executing tasks

        // iterates over the results and retrieves the result of each task using the Future.get() method
        // if the result is true, it increments the sum variable
        for (var a : results) {
            try {
                if (a.get()) {
                    ++ sum;
                }
            }
            catch (CancellationException | ExecutionException | InterruptedException exception) { // catches any possible exception that may be thrown while retrieving the results
                System.err.println(exception.getMessage()); // prints the message
                exception.printStackTrace(); // prints the stack trace 
            }
        }

        System.out.println("Count of space: " + sum);

        System.out.println("Time: " + (System.currentTimeMillis() - current) / 1000 + " c.");
    }

}