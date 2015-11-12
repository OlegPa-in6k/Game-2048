package printer;

import field.GameField;

import java.io.PrintStream;

/**
 * Created by employee on 10/20/15.
 */
public class ANSIPrinter extends AbstractPrinter {

    PrintStream stream;
    String s = "";
    Color color;

    public ANSIPrinter(GameField field) {
        super(field);
    }


    public void printField(GameField gameField) {
        System.out.println("Score: " + gameField.getScore());
        for (int i = 0; i < lenght; i++) {
            System.out.println("----------------------------");
            for (int j = 0; j < lenght; j++) {
                if (gameField.gameField[i][j].getValue() == 0) {
                    System.out.print("|     |");
                } else {
                    System.out.print("|");

                    System.out.printf("%5s", gameField.gameField[i][j].getValue());

                    System.out.print("|");
                }

            }
            System.out.println();


        }
        System.out.println("----------------------------");
    }

    @Override
    public void printHint() {
        System.out.println("4 - left, 8 - right, 6 - right, 2 - bottom");
    }

    public String getString(GameField gameField) {
        s += "Score: " + gameField.getScore() + "\n";
        for (int i = 0; i < lenght; i++) {
            s += "----------------------------" + "\n";
            for (int j = 0; j < lenght; j++) {
                if (gameField.gameField[i][j].getValue() == 0) {
                    s += "|     |";
                } else {
                    s += "|" + gameField.gameField[i][j].getValue() + "";
                }
            }
            s += "\n";
        }
        s += "----------------------------";
        return s;
    }

}
