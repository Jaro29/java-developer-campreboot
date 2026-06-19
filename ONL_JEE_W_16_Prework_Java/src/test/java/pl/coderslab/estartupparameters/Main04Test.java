package pl.coderslab.estartupparameters;

import lombok.extern.slf4j.Slf4j;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@Slf4j
public class Main04Test {

    private static final String GOOD_A ="1";
    private static final String GOOD_B ="1";
    private static final String GOOD_C ="1";

    private static final String BAD_A ="1";
    private static final String BAD_B ="1";
    private static final String BAD_C ="10";

    private static final String ANSWER_OK = "YES";
    private static final String ANSWER_NOT_OK = "NO";

    private String output;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void whenRun_withGoodValues_returnYes() {
        Main04.main(new String[]{GOOD_A, GOOD_B, GOOD_C});
        output = systemOutRule.getLog();
        assertThat(output.trim()).contains(ANSWER_OK);

    }
    @Test
    public void whenRun_withBadValues_returnNo() {
        Main04.main(new String[]{BAD_A, BAD_B, BAD_C});
        output = systemOutRule.getLog();
        assertThat(output.trim()).contains(ANSWER_NOT_OK);
    }
}
