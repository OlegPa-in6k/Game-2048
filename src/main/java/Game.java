import console.InputController;
import controllers.ConsoleGameController;
import field.GameField;
import printer.ANSIPrinter;

/**
 * Created by employee on 10/20/15.
 */
public class Game {

/*
stty -icanon min 1 time 0
mvn compile

cd target/classes
java name
*/

    public static void main(String[] args) {

        InputController input = new InputController();
        GameField gameField = new GameField();
        ANSIPrinter printer = new ANSIPrinter(gameField);

        ConsoleGameController gameController = new ConsoleGameController(gameField, printer, input);

        gameController.startGame();

       /* ApplicationContext start = new ClassPathXmlApplicationContext("spring-console-context.xml");
        ConsoleGameController gc = start.getBean(ConsoleGameController.class);
        gc.startGame();*/
    }
}
