package pl.coderslab.estartupparameters;

import lombok.extern.slf4j.Slf4j;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@Slf4j
public class Main02Test {

    private static final String FIRST_PARAMS_IN_LINE = "1 John 4 Kowalski";
    private static final String FIRST_PARAMS_IN_LINE_REVERSE = "Kowalski 4 John 1";


    private String output;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void whenRun_withFirstParams_returnInLine() {
        Main02.main(FIRST_PARAMS_IN_LINE.split(" "));
        output = systemOutRule.getLog();
        log.info(output);
        assertThat(output.trim()).contains(FIRST_PARAMS_IN_LINE_REVERSE);

    }
}
