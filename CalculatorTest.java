import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class CalculatorTest {

    private Calculator calculator;

    // JUnit fixture - create an instance of Calculator before each test
    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    // Test data - define inputs and expected outputs for tests
    private static final int INPUT1 = 5;
    private static final int INPUT2 = 10;
    private static final int EXPECTED_SUM = 15;
    private static final int EXPECTED_DIFFERENCE = -5;

    @Test
    public void testAdd() {
        int result = calculator.add(INPUT1, INPUT2);
        assertEquals(EXPECTED_SUM, result);
    }

    @Test
    public void testSubtract() {
        int result = calculator.subtract(INPUT1, INPUT2);
        assertEquals(EXPECTED_DIFFERENCE, result);
    }

    // Mock - simulate the behavior of another class to isolate the unit under test
    @Mock
    private DataService dataService;

    @Before
    public void setUpMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCalculateAverage() {
        // Set up the mock to return test data
        when(dataService.getData()).thenReturn(new int[] {5, 10, 15});

        // Inject the mock into the unit under test
        calculator.setDataService(dataService);

        double result = calculator.calculateAverage();

        // Verify that the unit under test behaves as expected
        assertEquals(10.0, result, 0.01);
    }

}