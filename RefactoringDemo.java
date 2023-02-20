public class RefactoringDemo {

    // Replace Magic Number with Symbolic Constant
    private static final int MAX_ITEMS = 5;

    private int[] items;

    // Extract Method
    private int calculateSum() {
        int sum = 0;
        for (int i = 0; i < MAX_ITEMS; i++) {
            sum += items[i];
        }
        return sum;
    }

    // Extract Variable
    private double calculateAverage() {
        int sum = calculateSum();
        double average = sum / (double) MAX_ITEMS;
        return average;
    }

    // Inline Variable
    private void printAverage() {
        System.out.println("The average of the first " + MAX_ITEMS + " items is: " + calculateAverage());
    }

    // Encapsulate Field
    public int[] getItems() {
        return items;
    }

    public void setItems(int[] items) {
        this.items = items;
    }

    public static void main(String[] args) {

        RefactoringDemo demo = new RefactoringDemo();
        demo.setItems(new int[] {1, 2, 3, 4, 5});

        // Introduce Parameter Object
        // Instead of passing multiple parameters to the method,
        // create a separate class that groups the related parameters
        // and pass an instance of that class to the method.
        printStatistics(demo.getItems(), new StatisticsOptions(true, false));

    }

    // Introduce Parameter Object
    private static void printStatistics(int[] items, StatisticsOptions options) {

        // Extract Class
        // Move related fields and methods into a separate class
        // to improve the design of the code.
        StatisticsCalculator calculator = new StatisticsCalculator(items, options);

        if (options.isPrintSum()) {
            System.out.println("Sum: " + calculator.calculateSum());
        }

        if (options.isPrintAverage()) {
            System.out.println("Average: " + calculator.calculateAverage());
        }

    }

    // Introduce Null Object
    // Instead of returning null, create a separate class
    // that represents a null value and return an instance of
    // that class when a null value is required.
    private static List<Integer> getItemsOrNull() {
        return null;
    }

    private static class StatisticsCalculator {

        private final int[] items;
        private final boolean printSum;
        private final boolean printAverage;

        public StatisticsCalculator(int[] items, StatisticsOptions options) {
            this.items = items;
            this.printSum = options.isPrintSum();
            this.printAverage = options.isPrintAverage();
        }

        private int calculateSum() {
            int sum = 0;
            for (int i : items) {
                sum += i;
            }
            return sum;
        }

        private double calculateAverage() {
            int sum = calculateSum();
            double average = sum / (double) items.length;
            return average;
        }

    }

    private static class StatisticsOptions {
        private final boolean printSum;
        private final boolean printAverage;

        public StatisticsOptions(boolean printSum, boolean printAverage) {
            this.printSum = printSum;
            this.printAverage = printAverage;
        }

        public boolean isPrintSum() {
            return printSum;
        }

        public boolean isPrintAverage() {
            return printAverage;
        }
    }

}
