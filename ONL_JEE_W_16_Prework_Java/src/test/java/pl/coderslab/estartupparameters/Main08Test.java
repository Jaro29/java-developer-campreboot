package pl.coderslab.estartupparameters;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static junit.framework.TestCase.assertEquals;


public class Main08Test {


    private static final String ANSWER_OK = "8";

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();


    @Test
    public void whenRun_withGoodValues_returnYes() {
        Main08.main(new String[]{"1000","864" });
        assertEquals(ANSWER_OK, systemOutRule.getLog().trim());
    }

}
