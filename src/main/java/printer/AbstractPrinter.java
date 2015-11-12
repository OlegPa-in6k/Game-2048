package printer;

import field.GameField;

import java.io.PrintStream;

/**
 * Created by employee on 10/20/15.
 */
public abstract class AbstractPrinter {

    PrintStream output;
    GameField gameField;

    public AbstractPrinter(GameField field) {
        this.gameField = field;

    }

    int lenght = gameField.FIELD_LENGTH;

    public void printField(GameField gameField) {

    }

    public void printHint() {

    }

}
