package Console;


import Field.Direction;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Created by employee on 10/20/15.
 */

public class InputControllerTest {

    @Test
    public void testGameController() throws FileNotFoundException {
        InputStream inputDirection = new ByteArrayInputStream("8624".getBytes());
        InputController inputController = new InputController();

        assertThat(inputController.getDirection(), is(Direction.UP));
        assertThat(inputController.getDirection(), is(Direction.RIGHT));
        assertThat(inputController.getDirection(), is(Direction.DOWN));
        assertThat(inputController.getDirection(), is(Direction.LEFT));
    }


}

