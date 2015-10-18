package epam.com.hadoop;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest extends Assert
{
    private LogItem[] logItems;

    @Before
    public void setup() {
        logItems = new LogItem[5];
        logItems[0] = new LogItem("1");
        logItems[1] = new LogItem("2");
        logItems[2] = new LogItem("3");
        logItems[3] = new LogItem("1");
        logItems[4] = new LogItem("2");
    }

    @Test
    public void parseOneLineTest() {
        Calculator calc = new Calculator();

        for (LogItem i: logItems) {
            calc.calculate(i);
        }

        assertEquals(calc.getResults().get("1"), new Long(2));
        assertEquals(calc.getResults().get("2"), new Long(2));
        assertEquals(calc.getResults().get("3"), new Long(1));
    }

}
