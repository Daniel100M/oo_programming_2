public class Testing {

    public static void main(String[] args) {

        LineCalculator object = new LineCalculator();

        String[] fileNames = Ex2_1.createTextFiles(10000, 1, 10);

        int thread = object.getNumOfLinesThreads(fileNames);
        System.out.println("threads = " + thread + "\n\n");

        int func = Ex2_1.getNumOfLines(fileNames);
        System.out.println("func = " + func + "\n\n");

        int pool = object.getNumOfLinesThreadPool(fileNames);
        System.out.println("pool = " + pool + "\n\n");
    }
}
