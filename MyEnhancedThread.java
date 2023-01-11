import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.Callable;

public class MyEnhancedThread implements Callable<Integer> {

    private String fileName; // Text-file name (without type).

    /**
     * Constructor.
     * @param fileName String representing name of text-file.
     *                 Number of lines in file will be calculated by
     *                 {@code call} function.
     */
    public MyEnhancedThread(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Calculates amount of lines which text-file consists of.
     * @return Total number of lines.
     * @throws Exception By default.
     */
    @Override
    public Integer call() throws Exception {

        BufferedReader bufferedReader;
        int total = 0; // Saves total amount of lines.

        // Calculating amount of lines in text-file:
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName + ".txt"));
            while (bufferedReader.readLine() != null) total++;
            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return total; // Autoboxing.
    }
}
