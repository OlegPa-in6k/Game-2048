package Printer;

import Field.GameField;
import org.junit.Test;

/**
 * Created by employee on 10/20/15.
 */
public class ANSIPrinterTest {

    GameField gameField = new GameField();
    ANSIPrinter ANSIPrinter = new ANSIPrinter(gameField);

    @Test
    public void testPrintEmptyField() throws Exception {
        gameField.setEmptyBoard();


    }
}
