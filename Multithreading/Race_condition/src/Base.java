import java.util.*;
import java.util.concurrent.*;

public class Base {

    // Shared queue, thread-safe
    public static Queue<Integer> queue = new PriorityQueue<>();

    // List of numbers to be added to the queue
    private List<Integer> numArr = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    // Method to add numbers from 1 to 10 to the shared queue
    public void method() {
        // Each thread adds the numbers from 1 to 10 to the queue, one by one
        for (int num : numArr) {
            // Insert into the queue in a thread-safe manner using synchronized block
            synchronized (queue) {
                queue.add(num);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Base base = new Base();

        // Create an ExecutorService to run tasks concurrently with 4 threads
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Submit tasks to the executor
        for (int i = 0; i < 4; i++) {
            executor.submit(() -> {
                // Each thread will call `method` to add numbers to the queue
                base.method();
            });
        }

        // Shut down the executor after tasks are submitted
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);  // Wait for threads to finish

        // Print the queue's contents
        synchronized (queue) {  // Make sure to synchronize when accessing the shared queue
            System.out.println("Final queue contents: " + queue);
        }
    }
}
