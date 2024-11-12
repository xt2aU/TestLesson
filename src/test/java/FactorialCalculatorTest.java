import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FactorialCalculatorTest {

    private FactorialCalculator calculator;

    @BeforeClass
    public void setUp() {
        calculator = new FactorialCalculator();
    }

    @Test
    public void testFactorialOfZero() {
        Assert.assertEquals(calculator.factorial(0), 1, "Факториал 0 должен быть 1");
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        Assert.assertEquals(calculator.factorial(5), 120, "Факториал 5 должен быть 120");
        Assert.assertEquals(calculator.factorial(3), 6, "Факториал 3 должен быть 6");
        Assert.assertEquals(calculator.factorial(10), 3628800, "Факториал 10 должен быть 3628800");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialOfNegativeNumber() {
        calculator.factorial(-1);
    }
}