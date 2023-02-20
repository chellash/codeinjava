public class DebuggerDemo {

    private int age;

    public DebuggerDemo(int age) {
        this.age = age;
    }

    public void printAge() {
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        int x = 5;
        int y = 7;
        int sum = x + y;
        System.out.println("Sum: " + sum);

        DebuggerDemo demo = new DebuggerDemo(30);
        demo.printAge();

        for (int i = 0; i < 10; i++) {
            // Demonstrating the conditional statement
            if (i % 2 == 0) { // If i is divisible by 2 with no remainder
                System.out.println(i + " is even");
            } else {
                System.out.println(i + " is odd");
            }
        }

        String[] names = {"Alice", "Bob", "Charlie"};
        for (String name : names) {
            System.out.println("Name: " + name);
        }

        int[] nums = {1, 2, 3, 4, 5};
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
        }
        System.out.println("Product: " + product);

        // Demonstrating the breakpoint feature
        int breakpointVar = 42;
        System.out.println("Before breakpoint");
        // Add a breakpoint on the next line to pause execution and enter debug mode
        System.out.println("After breakpoint");

        // Demonstrating the step over feature
        System.out.println("First line of method1");
        method1();
        System.out.println("Last line of main");

        // Demonstrating the step into feature
        System.out.println("First line of main");
        method2();
        System.out.println("Last line of main");

        // Demonstrating the step out feature
        System.out.println("First line of main");
        method3();
        System.out.println("Last line of main");

        // Demonstrating the call stack feature
        foo();
    }

    // Demonstrating the step over feature
    private static void method1() {
        System.out.println("First line of method1");
        System.out.println("Last line of method1");
    }

    // Demonstrating the step into feature
    private static void method2() {
        System.out.println("First line of method2");
        method1();
        System.out.println("Last line of method2");
    }

    // Demonstrating the step out feature
    private static void method3() {
        System.out.println("First line of method3");
        method1();
        System.out.println("Last line of method3");
    }

    // Demonstrating the call stack feature
    private static void foo() {
        int a = 5;
        int b = 7;
        int c = bar(a, b);
        System.out.println("c: " + c);
    }

    private static int bar(int x, int y) {
        int z = x * y;
        return z;
    }
}