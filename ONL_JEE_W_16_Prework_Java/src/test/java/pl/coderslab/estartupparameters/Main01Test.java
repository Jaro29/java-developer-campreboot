package pl.coderslab.estartupparameters;

import lombok.extern.slf4j.Slf4j;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@Slf4j
public class Main01Test {

    private static final String FIRST_PARAMS_IN_LINE = "1 John 4 Kowalski";
    private static final String SECOND_PARAMS_IN_LINE = "qwe qwe";

    private String output;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void whenRun_withFirstParams_returnInLine() {
        Main01.main(FIRST_PARAMS_IN_LINE.split(" "));
        output = systemOutRule.getLog();
        assertThat(output.trim()).contains(FIRST_PARAMS_IN_LINE);

    }
    @Test
    public void whenRun_withSecondParams_returnInLine() {
        Main01.main(SECOND_PARAMS_IN_LINE.split(" "));
        output = systemOutRule.getLog();
        assertThat(output.trim()).contains(SECOND_PARAMS_IN_LINE);
    }
}
