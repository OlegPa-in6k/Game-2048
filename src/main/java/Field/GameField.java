package Field;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 10/19/15.
 */
public class GameField {

    public static final int FIELD_LENGTH = 4;

    public Cell[][] gameField = new Cell[FIELD_LENGTH][FIELD_LENGTH];

    public void setEmptyBoard() {
        for (int i = 0; i < FIELD_LENGTH; i++) {
            for (int j = 0; j < FIELD_LENGTH; j++) {
                Cell cell = new Cell();
                cell.setValue(0);
                gameField[i][j] = cell;
            }
        }
    }

    public String toString() {
        String string = "";
        for (int i = 0; i < FIELD_LENGTH; i++) {
            for (int j = 0; j < FIELD_LENGTH; j++) {
                string += "" + gameField[i][j].getValue() + " ";
            }
            string += "\n";
        }
        return string;
    }

    public List<Cell> getListOfEmptyCells() {
        List<Cell> emptyCells = new ArrayList<Cell>();
        for (int i = 0; i < FIELD_LENGTH; i++) {
            for (int j = 0; j < FIELD_LENGTH; j++) {
                if (gameField[i][j].getValue() == 0) {
                    gameField[i][j].setLineNumber(i);
                    gameField[i][j].setColomnNumber(j);
                    emptyCells.add(gameField[i][j]);
                }
            }
        }
        return emptyCells;
    }


    public void addNewCell() {
        if (getListOfEmptyCells().size() > 0) {
            Cell cell = new RandomEmptyCellGetter().getEmptyCell(getListOfEmptyCells());
            gameField[cell.getLineNumber()][cell.getColomnNumber()].setValue(new RandomCellValueGenerator().createValueForNewCell());
        }
    }

}
