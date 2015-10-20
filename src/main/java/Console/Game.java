package Console;

import Field.GameField;
import Printer.ANSIPrinter;


/**
 * Created by employee on 10/20/15.
 */
public class Game {
    GameField gameField;
    ANSIPrinter printer;
    InputController input;

    Game() {
        gameField = new GameField();
        gameField.makeStartField();
        printer = new ANSIPrinter();

    }


    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }

    public void startGame() {
        while (gameField.isAvailableMove() && !gameField.isFinish()) {
            printer.printField(gameField);

            input = new InputController(System.in);
            gameField.move(input.getDirection());
            gameField.addNewCell();
        }
    }

}
