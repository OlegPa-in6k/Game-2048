package Console;

import Field.GameField;
import Printer.ANSIPrinter;


/**
 * Created by employee on 10/20/15.
 */
public class GameController {
    GameField gameField;
    ANSIPrinter printer;
    InputController input;

    public GameController(GameField gameField, ANSIPrinter printer, InputController input) {
        this.gameField = gameField;
        gameField.makeStartField();
        this.printer = printer;
        this.input = input;
    }


    public void startGame() {
        gameField.setEmptyBoard();
        gameField.makeStartField();

        while (gameField.isAvailableMove() && !gameField.isFinish()) {
            printer.printField(gameField);
            gameField.move(input.getDirection());
            gameField.addNewCell();
        }
    }

}
