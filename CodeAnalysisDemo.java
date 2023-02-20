import java.util.ArrayList;

public class CodeAnalysisDemo {
    private int count = 0; // Unused variable

    public void increment() {
        count++;
    }

    public void foo() {
        String str = "Hello"; // Unused variable

        if (count > 10) { // Complex condition
            for (int i = 0; i < 5; i++) { // Nested loop
                System.out.println("Count is greater than 10 and i is " + i);
            }
        }

        String[] arr = new String[]{"foo", "bar", "baz"}; // Inefficient use of array
        for (int i = 0; i < arr.length; i++) { // Use of for loop instead of enhanced for loop
            System.out.println(arr[i]);
        }

        String input = "1'; DROP TABLE users;--"; // SQL injection vulnerability
        String query = "SELECT * FROM users WHERE id = '" + input + "'"; // Vulnerable query

        System.out.println(query);
    }

    @SuppressWarnings("deprecation") // Use of deprecated method
    public void bar() {
        Date date = new Date(2022, 1, 1); // Use of deprecated constructor
        System.out.println(date.toString());
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("foo");
        list.add("bar");
        list.add(null); // this will trigger the NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE bug
        for (String s : list) {
            System.out.println(s.toUpperCase()); // this will trigger the NP_NULL_PARAM_DEREF_ALL_TARGETS_DANGEROUS bug
        }
        Integer i = new Integer(10); // this will trigger the DM_NUMBER_CTOR bug
        System.out.println(i);
    }
}
