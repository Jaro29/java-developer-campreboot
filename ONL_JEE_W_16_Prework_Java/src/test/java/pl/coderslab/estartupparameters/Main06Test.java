package pl.coderslab.estartupparameters;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.assertEquals;

public class Main06Test {

    private static final String EXPECTED_OUTPUT = "1x1=1" +
            "1x2=2" +
            "1x3=3" +
            "2x1=2" +
            "2x2=4" +
            "2x3=6" +
            "3x1=3" +
            "3x2=6" +
            "3x3=9";

    private String output;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Before
    public void setUp() {
        Main06.main(new String[]{"3"});
        output = systemOutRule.getLog();
    }

    @Test
    public void whenRun_thenSystemOut_Result() {
        assertEquals(EXPECTED_OUTPUT, output.replaceAll("\\s+",""));
    }
}
