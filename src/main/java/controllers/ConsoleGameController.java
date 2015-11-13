package controllers;

import console.InputController;
import field.GameField;
import printer.AbstractPrinter;


/**
 * Created by employee on 10/20/15.
 */
public class ConsoleGameController extends interfaceController {


    public ConsoleGameController(GameField gameField, AbstractPrinter printer, InputController input) {
        super(gameField, printer, input);
    }
    public void startGame() {

        gameField.setEmptyBoard();
        gameField.makeStartField();
        while (gameField.isAvailableMove() && !gameField.isFinish()) {
            printer.printHint();
            printer.printField(gameField);
            gameField.move(input.getDirection());
            gameField.addNewCell();
        }
    }

}
