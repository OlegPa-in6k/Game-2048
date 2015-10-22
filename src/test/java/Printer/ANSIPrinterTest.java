package Printer;

import Field.GameField;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/20/15.
 */
public class ANSIPrinterTest {

    GameField gameField = new GameField();
    ANSIPrinter ansiPrinter = new ANSIPrinter(gameField);

    @Test
    public void testPrintEmptyField() throws Exception {
        gameField.setEmptyBoard();

        assertThat(ansiPrinter.getString(gameField), is(
                "Score: 0\n----------------------------\n" +
                        "|     ||     ||     ||     |\n" +
                        "----------------------------\n" +
                        "|     ||     ||     ||     |\n" +
                        "----------------------------\n" +
                        "|     ||     ||     ||     |\n" +
                        "----------------------------\n" +
                        "|     ||     ||     ||     |\n" +
                        "----------------------------"
        ));


    }


}
