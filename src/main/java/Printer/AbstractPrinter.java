package Printer;

import Field.Cell;

import java.io.PrintStream;

/**
 * Created by employee on 10/19/15.
 */
public abstract class AbstractPrinter {
    Cell[][] cells;
    int length = cells.length;
    PrintStream stream;

    AbstractPrinter(Cell[][] cells, PrintStream stream) {

        this.cells = cells;
        this.stream = stream;

    }

    public void print() {
        printTitle();
        printScore();
        printField();
        printCondtions();
    }

    protected abstract void printCondtions();

    protected void printField() {

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                setColor();
                printCell(cells[i][j].getValue());
                setStandartColor();
            }

        }
    }

    protected abstract void setColor();

    protected abstract void printCell(int value);

    protected abstract void setStandartColor();

    protected abstract void printScore();

    protected abstract void printTitle();

}
