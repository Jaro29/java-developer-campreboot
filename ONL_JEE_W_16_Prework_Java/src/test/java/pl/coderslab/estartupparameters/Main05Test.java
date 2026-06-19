package pl.coderslab.estartupparameters;

import lombok.extern.slf4j.Slf4j;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

@Slf4j
public class Main05Test {

    private static final String BAD_VALUES = "BADVALUE";
    private static final String A = "A";
    private static final String C = "C";
    private static final String E = "E";
    private static final String F = "F";

    @Rule
    public final SystemOutRule output = new SystemOutRule().enableLog();

    @Test
    public void whenRun_withToSmallValue_returnBadValues()  {
        Main05.main(new String[]{"-1"});
        assertEquals(BAD_VALUES, output.getLog().trim());
    }
    @Test
    public void whenRun_withToBigValue_returnBadValues()  {
        Main05.main(new String[]{"101"});
        assertEquals(BAD_VALUES, output.getLog().trim());
    }

    @Test
    public void whenRun_with98Points_returnAGrade()  {
        Main05.main(new String[]{"98"});
        assertEquals(A, output.getLog().trim());
    }

    @Test
    public void whenRun_with98Points_returnCGrade()  {
        Main05.main(new String[]{"71"});
        assertEquals(C, output.getLog().trim());
    }

    @Test
    public void whenRun_with71Points_returnEGrade()  {
        Main05.main(new String[]{"70"});
        assertEquals(E, output.getLog().trim());
    }

    @Test
    public void whenRun_with50Points_returnFGrade()  {
        Main05.main(new String[]{"50"});
        assertEquals(F, output.getLog().trim());
    }
}
