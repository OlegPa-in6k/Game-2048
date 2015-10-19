package Field;

/**
 * Created by employee on 10/19/15.
 */
public class GameField {
    public static final int FIELD_LENGTH = 4;

    private Cell[][] gameField = new Cell[FIELD_LENGTH][FIELD_LENGTH];

    public void setEmptyBoard() {
        for (int i = 0; i < FIELD_LENGTH; i++) {
            for (int j = 0; j < FIELD_LENGTH; j++) {
                Cell cell = new Cell();
                cell.setNumber(0);
                gameField[i][j] = cell;
            }
        }
    }

    public String toString() {
        String string = "";
        for (int i = 0; i < FIELD_LENGTH; i++) {
            for (int j = 0; j < FIELD_LENGTH; j++) {
                string += "" + gameField[i][j].getNumber() + " ";
            }
            string += "\n";
        }
        return string;
    }


}
