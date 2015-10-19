package Field;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/19/15.
 */
public class StaticCellGeneratorTest {
    StaticCellValueGenerator st = new StaticCellValueGenerator();

    @Test
    public void testGetNewCellValue() throws Exception {
        assertThat(st.createValueForNewCell(), is(2));

    }
}
