import Console.GameController;
import Console.InputController;
import Field.GameField;
import Printer.ANSIPrinter;

/**
 * Created by employee on 10/20/15.
 */
public class Game {


    public static void main(String[] args) {
        ANSIPrinter printer = new ANSIPrinter();
        InputController input = new InputController(System.in);
        GameField gameField = new GameField();
        GameController gameController = new GameController(gameField, printer, input);

        gameController.startGame();
    }
}
