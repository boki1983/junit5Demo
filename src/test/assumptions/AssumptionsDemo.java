package assumptions;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import org.junit.jupiter.api.Test;


public class AssumptionsDemo {
    @Test
    void testOnDev()
    {
        System.setProperty("ENV", "DEV");
        assumeTrue("DEV".equals(System.getProperty("ENV")));
        //remainder of test will proceed
    }

    @Test
    void testOnProd()
    {
        System.setProperty("ENV", "PROD");
        assumeTrue("DEV".equals(System.getProperty("ENV")), AssumptionsDemo::message);
        //remainder of test will be aborted
    }

    private static String message () {
        return "TEST Execution Failed :: ";
    }

}
