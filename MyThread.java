import java.io.BufferedReader;
import java.io.FileReader;

public class MyThread extends Thread{

    private String fileName; // Text-file name (without type).
    private int total; // Total amount of lines in text file.

    /**
     * Constructor.
     * Initializes String & integer fields.
     * @param fileName String value, name of text-file.
     */
    public MyThread(String fileName) {
        this.fileName = fileName;
        total = 0;
    }

    /**
     * Calculates total amount of lines in text-file.
     */
    @Override
    public void run() {

        BufferedReader bufferedReader;

        try {
            bufferedReader = new BufferedReader(new FileReader(fileName + ".txt"));
            while (bufferedReader.readLine() != null) total++;
            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getFileName() {
        return fileName;
    }

    public int getTotal() {
        return total;
    }
}
