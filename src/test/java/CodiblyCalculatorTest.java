import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CodiblyCalculatorTest {

    @Test
    void testCalculate()
    {
        String[] arguments = new String[]{"12", "2", "3", "4", "*", "10", "5", "/", "+", "*", "+"};
        Integer result = StackCalculator.calculateByStack(arguments);

        assertEquals(result, 40);
    }

    @Test
    void testCalculateWithWrongParameter()
    {
        String[] arguments = new String[]{"12", "2", "3", "4", "*", "10", "qwe", "5", "/", "+", "*", "+"};
        assertNull(StackCalculator.calculateByStack(arguments));
    }


    @Test
    void testCalculateEmpty()
    {
        String[] arguments = new String[]{};
        assertNull(StackCalculator.calculateByStack(arguments));
    }
}