package Field;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 10/19/15.
 */
public class GameField {

    public static final int FIELD_LENGTH = 4;

    public Cell[][] gameField = new Cell[FIELD_LENGTH][FIELD_LENGTH];
    private boolean isAction;

    public boolean isAction() {
        return isAction;
    }

    public void setIsAction(boolean isAction) {
        this.isAction = isAction;
    }



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

    public void makeStartField() {
        setEmptyBoard();
        addNewCell();
        addNewCell();
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
            int cellValue = new RandomCellValueGenerator().createValueForNewCell();
            gameField[cell.getLineNumber()][cell.getColomnNumber()].setValue(cellValue);
        }
    }

    public void rotateFieldRight() {

        for (int i = 0; i < FIELD_LENGTH / 2; i++) {
            for (int j = 0; j < Math.ceil(((double) FIELD_LENGTH) / 2.); j++) {
                Cell temp = gameField[i][j];
                gameField[i][j] = gameField[FIELD_LENGTH - 1 - j][i];
                gameField[FIELD_LENGTH - 1 - j][i] = gameField[FIELD_LENGTH - 1 - i][FIELD_LENGTH - 1 - j];
                gameField[FIELD_LENGTH - 1 - i][FIELD_LENGTH - 1 - j] = gameField[j][FIELD_LENGTH - 1 - i];
                gameField[j][FIELD_LENGTH - 1 - i] = temp;
            }
        }
    }

    public void slideLeft() {
        setIsAction(false);

        for (int i = 0; i < GameField.FIELD_LENGTH; i++) {

            for (int j = 1; j < GameField.FIELD_LENGTH; j++) {

                if (gameField[i][j].getValue() != 0) {

                    for (int k = j; k > 0; k--) {
                        if (gameField[i][k - 1].getValue() == 0) {
                            gameField[i][k - 1].setValue(gameField[i][k].getValue());
                            gameField[i][k].setValue(0);
                            setIsAction(true);

                        } else {
                            if (gameField[i][k - 1].getValue() == gameField[i][k].getValue() && gameField[i][k].isMult()) {

                                gameField[i][k - 1].doubleValue();
                                gameField[i][k - 1].setIsMult(false);
                                gameField[i][k].setValue(0);
                                // score.setScore(field.field[i][k-1].getNumber());
                                setIsAction(true);
                            }
                        }

                    }

                }
            }


        }
        setAllCellsNotMult();

    }

    public void setAllCellsNotMult() {
        for (int i = 0; i < FIELD_LENGTH; i++) {
            for (int j = 0; j < FIELD_LENGTH; j++) {
                gameField[i][j].setIsMult(true);
            }
        }

    }


    public enum Direction {
        UP, SOWN, LEFT, RIGHT;
    }




}
