import Console.GameController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

        //  InputController input = new InputController(System.in);
        //  GameField gameField = new GameField();
        //  ANSIPrinter printer = new ANSIPrinter(gameField);

        //  GameController gameController = new GameController(gameField, printer, input);
        ApplicationContext start = new ClassPathXmlApplicationContext("XMLApplication.xml");
        GameController gc = (GameController) start.getBean("gameController");
        gc.startGame();
    }
}
