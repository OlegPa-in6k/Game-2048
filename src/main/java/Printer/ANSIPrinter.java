package Printer;

import Field.GameField;

/**
 * Created by employee on 10/20/15.
 */
public class ANSIPrinter implements InterfacePrint {

    GameField gameField;
    int lenght = gameField.FIELD_LENGTH;

    public ANSIPrinter(GameField field) {
        this.gameField = gameField;

    }

    public void printField() {
        System.out.println("Score: " + gameField.getScore());
        for (int i = 0; i < lenght; i++) {
            System.out.println("---");
            for (int j = 0; j < lenght; j++) {
                if (gameField.gameField[i][j].getValue() == 0) {
                    System.out.print("|     |");
                } else {
                    System.out.print("|");
                    System.out.printf("%5s", gameField.gameField[i][j].getValue());
                    System.out.print("|");
                }
            }
            System.out.println("---");
        }
    }
}
