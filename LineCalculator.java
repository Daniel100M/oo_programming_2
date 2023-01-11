import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Used to declare and implement further functions,
 * calculating total amount of lines using multi-threading.
 */
public class LineCalculator {

    /**
     * Calculates total amount of lines summed from each file.
     * @param fileNames Text-file names for line calculation.
     * @return Total amount of lines.
     */
    public int getNumOfLinesThreads(String[] fileNames){

        long startTime = System.currentTimeMillis(); // Used to measure execution time.

        /*
        List of threads.
        Each will calculate total amount of lines
        in a particular text-file.
         */
        List<MyThread> myThreads = new ArrayList<>();

        MyThread myThread;
        int total = 0; // Saves total amount of lines.

        for (String name : fileNames){

            myThread = new MyThread(name);
            myThreads.add(myThread);
            myThread.start();
        }

        for (MyThread thread : myThreads){
            while (thread.isAlive()); // Waiting for thread to die. Only then computing total.
            total += thread.getTotal();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Done calculation using threads.\n" +
                "Total amount of time in milliseconds: " + (endTime-startTime));

        return total;
    }

    /**
     * Use a thread-pool to calculate total amount of lines in text-files.
     * @param fileNames String values representing names of files.
     * @return Total amount of lines calculated.
     */
    public int getNumOfLinesThreadPool(String[] fileNames){

        long startTime = System.currentTimeMillis(); // Used to measure execution time.

        ExecutorService executorService = Executors.newFixedThreadPool(fileNames.length); // Creating a fixed thread pool.
        List<Future<Integer>> futures = new ArrayList<>(); // Will hold pending integers.

        int total = 0; // Total amount of lines in all files.

        Callable<Integer> task; // Object of class which implements 'Callable' interface.
        for (String name : fileNames){
            // Creating a separate task for each text-file.
            task = new MyEnhancedThread(name);
            futures.add(executorService.submit(task));
        }

        for (Future<Integer> future : futures){
            /*
            Note that if 'get()' hasn't finished calculation,
            the program will be stuck (blocked), until value has returned.
             */
            try {
                total += future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();

        long endTime = System.currentTimeMillis();

        System.out.println("Done calculation using thread-pool.\n" +
                "Total amount of time in milliseconds: " + (endTime-startTime));

        return total;
    }

}
