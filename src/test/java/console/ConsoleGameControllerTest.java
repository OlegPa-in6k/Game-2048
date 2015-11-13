package console;

import field.Direction;
import field.GameField;
import field.InterfaceGameField;
import org.junit.Test;
import printer.AbstractPrinter;

/**
 * Created by employee on 10/20/15.
 */
public class ConsoleGameControllerTest extends AbstractPrinter implements InterfaceGameField, InterfaceInputController {
    String s;

    public ConsoleGameControllerTest(GameField field) {
        super(field);
    }


    public Direction getDirection() {
        return Direction.LEFT;
    }

    public void printField(GameField gameField) {
        s += "p";
    }


    public void printHint() {

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