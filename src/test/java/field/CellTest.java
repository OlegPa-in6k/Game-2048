package field;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/19/15.
 */
public class CellTest {
    Cell cell = new Cell();

    @Test
    public void testName() throws Exception {
        cell.setValue(0);
        cell.getValue();
        assertThat(cell.getValue(), is(0));
    }

    @Test
    public void testGetNumber() throws Exception {

        cell.setValue(10);
        cell.getValue();
        assertThat(cell.getValue(), is(10));


    }
}
