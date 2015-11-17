package core.field;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/19/15.
 */
public class RandomCellValueGeneratorTest {


    @Test
    public void testGetValueOf4() throws Exception {
        int someValue = 2;
        String result = "";
        while (someValue == 2) {
            someValue = new RandomCellValueGenerator().createValueForNewCell();
            if (someValue == 4) {
                result += "4 can be generate";
            }

        }

        assertThat(result, is("4 can be generate"));

    }
}
