package controllers;

import console.InputController;
import field.GameField;
import printer.AbstractPrinter;

/**
 * Created by employee on 11/12/15.
 */
public abstract class interfaceController {
    GameField gameField;
    AbstractPrinter printer;
    InputController input;

    public interfaceController(GameField gameField, AbstractPrinter printer, InputController input) {
        this.gameField = gameField;
        this.printer = printer;
        this.input = input;
    }
}
