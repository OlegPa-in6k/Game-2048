package Console;

import Field.Direction;

import java.util.Scanner;

/**
 * Created by employee on 10/20/15.
 */
public class InputController {

    Scanner scanner = new Scanner(System.in);



    public Direction getDirection() {

        System.out.println("4 8 6 2");

        char choise = scanner.next().charAt(0);
        switch (choise) {
            case '6':
                return Direction.RIGHT;
            case '4':
                return Direction.LEFT;
            case '8':
                return Direction.UP;
            case '2':
                return Direction.DOWN;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
