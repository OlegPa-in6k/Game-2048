import Field.StaticCellGenerator;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/19/15.
 */
public class StaticCellGeneratorTest {
    StaticCellGenerator st = new StaticCellGenerator();

    @Test
    public void testGetNewCellValue() throws Exception {
        assertThat(st.createNewCell(), is(4));

    }
}
