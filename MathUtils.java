public class MathUtils {

    public int divide(int x, int y) {
        return x / y;
    }

    public int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Cannot compute factorial of negative number");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

}
