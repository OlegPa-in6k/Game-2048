import Console.GameController;
import Console.InputController;
import Field.GameField;
import Printer.ANSIPrinter;

/**
 * Created by employee on 10/20/15.
 */
public class Game {

/*
stty -icanon min 1 time 0
mvn compile
target class name
cd target /classes
java name
*/

    public static void main(String[] args) {
        ANSIPrinter printer = new ANSIPrinter();
        InputController input = new InputController(System.in);
        GameField gameField = new GameField();
        GameController gameController = new GameController(gameField, printer, input);

        gameController.startGame();
    }
}
