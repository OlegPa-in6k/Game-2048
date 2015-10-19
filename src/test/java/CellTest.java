import Field.Cell;
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
        cell.setNumber(0);
        cell.getNumber();
        assertThat(cell.getNumber(), is(0));
    }

    @Test
    public void testGetNumber() throws Exception {

        cell.setNumber(10);
        cell.getNumber();
        assertThat(cell.getNumber(), is(10));


    }
}
