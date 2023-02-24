public class Calculator {

    private MathUtils mathUtils;

    public Calculator() {
        mathUtils = new MathUtils();
    }

    public void setMathUtils(MathUtils mathUtils) {
        this.mathUtils = mathUtils;
    }

    public int add(int x, int y) {
        return x + y;
    }

    public int subtract(int x, int y) {
        return x - y;
    }

    public int multiply(int x, int y) {
        return x * y;
    }

    public int divide(int x, int y) {
        if (y == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return mathUtils.divide(x, y);
    }
}