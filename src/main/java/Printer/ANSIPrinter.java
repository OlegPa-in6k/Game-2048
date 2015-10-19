package Printer;

import Field.Cell;

import java.io.PrintStream;

/**
 * Created by employee on 10/19/15.
 */
public class ANSIPrinter extends AbstractPrinter {
    ANSIPrinter(Cell[][] cells, PrintStream stream) {
        super(cells, stream);
    }


    @Override
    protected void printCondtions() {

    }

    @Override
    protected void setColor() {

    }

    @Override
    protected void printCell(int value) {
        if (value == 0) {
            stream.print("|     |");
        } else {
            stream.print("|");
            stream.printf("%5s", value);
            stream.print("|");
        }

    }

    @Override
    protected void setStandartColor() {

    }

    @Override
    protected void printScore() {

    }

    @Override
    protected void printTitle() {

    }
}
