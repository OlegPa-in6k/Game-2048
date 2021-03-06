package Console;

import Field.Direction;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by employee on 10/20/15.
 */
public class InputController implements InterfaceInputController {

    InputStream input;
    private byte[] inputChar = new byte[1];

    public InputController() {
        this.input = System.in;
    }

    public Direction getDirection() {
        try {
            input.read(inputChar);
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (inputChar[0]) {
            case '6':
                return Direction.RIGHT;
            case '4':
                return Direction.LEFT;
            case '8':
                return Direction.UP;
            case '2':
                return Direction.DOWN;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
