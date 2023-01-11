import java.io.*;
import java.util.Random;

public class Ex2_1 {

    /**
     * Creates text files (Exact amount specified by user).
     * @param n Number of text files.
     * @param seed
     * @param bound Used to generate random number.
     * @return String array of text file names.
     */
    public static String[] createTextFiles(int n, int seed, int bound){

        String[] names = new String[n]; // Names of text files.
        BufferedWriter bf; // Used to create text files.

        // Assigning file names.
        for (int i = 0; i < n; i++) names[i] = "file" + i;

        Random random = new Random(seed); // Random number generator.

        // Creating files & inserting text.
        for (int i = 0; i < n; i++) {

            int numOfLines = random.nextInt(bound);
            // System.out.println("For file: '" + names[i] + "', " + numOfLines + " in total.");

            try {

                bf = new BufferedWriter(new FileWriter(names[i] + ".txt"));

                // Insert text to file.
                for (int j = 0; j < numOfLines; j++) bf.write("Hakuna Matata [" + j + "]\n");

                bf.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return names;
    }

    /**
     * Retrieves amount of total lines in all files.
     * @param fileNames Array that contains names of text-files.
     * @return Total amount of lines in each file summed together.
     */
    public static int getNumOfLines(String[] fileNames){

        long startTime = System.currentTimeMillis(); // Used to measure execution time.

        BufferedReader bufferedReader;
        int total = 0; // Saves total amount of lines.

        for (String name : fileNames){

            try {

                bufferedReader = new BufferedReader(new FileReader(name + ".txt"));
                while (bufferedReader.readLine() != null) total++;
                bufferedReader.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Done calculation using standard function call.\n" +
                "Total amount of time in milliseconds: " + (endTime-startTime));

        return total;
    }




}
