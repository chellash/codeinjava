public class PerformanceDemo {
    public static void main(String[] args) {
        // Create an object and assign it to a variable
        Object firstObject = new Object();
        // The 'firstObject' object is now in scope and takes up memory

        // Create a new object inside a code block
        {
            Object secondObject = new Object();
            // The 'secondObject' object is now in scope and takes up memory

            // Assign 'secondObject' to 'firstObject' to create a reference
            firstObject = secondObject;
            // The 'firstObject' variable now points to the 'secondObject' object

            // Add a delay to allow us to inspect the application with jvisualvm
            // In this case, we're waiting for 5 seconds
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // The 'secondObject' object is now out of scope and eligible for garbage collection

        // Trigger garbage collection
        System.gc();

        // Add a delay to allow us to inspect the application with jvisualvm
        // In this case, we're waiting for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Create a new object inside a method
        createObjectInMethod();

        // The 'firstObject' variable is still in scope and takes up memory
    }

    public static void createObjectInMethod() {
        // Create an object inside the method
        Object thirdObject = new Object();
        // The 'thirdObject' object is now in scope and takes up memory

        // Add a delay to allow us to inspect the application with jvisualvm
        // In this case, we're waiting for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // The 'thirdObject' object is now out of scope and eligible for garbage collection
    }
}