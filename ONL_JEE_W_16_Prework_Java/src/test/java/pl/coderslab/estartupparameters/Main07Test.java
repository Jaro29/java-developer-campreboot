package pl.coderslab.estartupparameters;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static junit.framework.TestCase.assertEquals;


public class Main07Test {


    private static final String FACTORIAL_10 = "3628800";
    private static final String FACTORIAL_1 = "1";

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void whenRun_withFactorial10_return3628800() {
        Main07.main(new String[]{"10"});
        assertEquals(FACTORIAL_10, systemOutRule.getLog().trim());
    }
    @Test
    public void whenRun_withFactorial1_return1() {
        Main07.main(new String[]{"1"});
        assertEquals(FACTORIAL_1, systemOutRule.getLog().trim());
    }


}
