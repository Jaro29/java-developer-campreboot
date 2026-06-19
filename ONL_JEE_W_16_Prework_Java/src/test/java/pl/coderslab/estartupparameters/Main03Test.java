package pl.coderslab.estartupparameters;

import lombok.extern.slf4j.Slf4j;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.assertj.core.api.Assertions.within;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@Slf4j
public class Main03Test {

    private static final String FIRST_PARAMS_IN_LINE = "1 2 3 4";
    private static final String SECOND_PARAMS_IN_LINE = "10";
    private static final double AVG_FIRST_PARAMS = 2.5;
    private static final double SECOND_FIRST_PARAMS = 10;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void whenRun_withFirstLine_returnAvg() {
        Main03.main(FIRST_PARAMS_IN_LINE.split(" "));
        assertThat(Double.parseDouble(systemOutRule.getLog().trim())).isCloseTo(AVG_FIRST_PARAMS, within(0.1));
    }
    @Test
    public void whenRun_withSecondLine_returnAvg() {
        Main03.main(SECOND_PARAMS_IN_LINE.split(" "));
        assertThat(Double.parseDouble(systemOutRule.getLog().trim())).isCloseTo(SECOND_FIRST_PARAMS, within(0.1));
    }

}
