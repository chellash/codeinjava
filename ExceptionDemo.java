import java.io.IOException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class ExceptionDemo {
    public static void main(String[] args) {
        // NullPointerException
        String s = null;
        System.out.println(s.length());

        // ClassNotFoundException
        try {
            Class.forName("com.example.NonexistentClass");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // IOException
        try {
            throw new IOException("An I/O error occurred.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // ArithmeticException
        int x = 10, y = 0;
        System.out.println(x / y);

        // ArrayIndexOutOfBoundsException
        int[] arr = new int[5];
        System.out.println(arr[10]);

        // IllegalArgumentException
        List<Integer> list = new ArrayList<>();
        list.add(-1);

        // ConcurrentModificationException
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        for (String name : names) {
            names.add("Charlie");
        }

        // ClassCastException
        Object obj = "Hello";
        Integer num = (Integer) obj;

        // OutOfMemoryError
        List<Long> longList = new ArrayList<>();
        while (true) {
            longList.add(Long.MAX_VALUE);
        }

        // StackOverflowError
        recursiveMethod();
    }

    public static void recursiveMethod() {
        recursiveMethod();
    }
}