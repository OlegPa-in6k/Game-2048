package Console;

import Field.Direction;
import Field.GameField;
import Field.InterfaceGameField;
import Printer.InterfacePrint;
import org.junit.Test;

/**
 * Created by employee on 10/20/15.
 */
public class GameTest implements InterfacePrint, InterfaceGameField, InterfaceInputController {
    String s;

    public Direction getDirection() {
        return Direction.LEFT;
    }

    public void printField(GameField gameField) {
        s += "p";
    }

    public void move(Direction direction) {
        switch (direction) {
            case LEFT:
                s += "L";
                break;
            case RIGHT:
                s += "R";
                break;
            case DOWN:
                s += "D";
                break;
            case UP:
                s += "U";
                break;
        }
    }

    @Test
    public void testGame() throws Exception {


    }
}
