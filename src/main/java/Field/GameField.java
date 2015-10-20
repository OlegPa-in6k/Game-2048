package Field;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by employee on 10/19/15.
 */
public class GameField implements InterfaceGameField {

    private int score = 0;

    MatrixRotation rotate = new MatrixRotation();

    public static final int FIELD_LENGTH = 4;

    private boolean isFinish = false;

    private boolean availableMove = true;

    public Cell[][] gameField = new Cell[FIELD_LENGTH][FIELD_LENGTH];

    private boolean isAction = true;


    public boolean isAction() {
        return isAction;
    }

    public void setIsAction(boolean isAction) {
        this.isAction = isAction;
    }

    public boolean isAvailableMove() {
        return availableMove;
    }

    public void setAvailableMove(boolean availableMove) {
        this.availableMove = availableMove;
    }

    public boolean isFinish() {
        return isFinish;
    }

    public void setIsFinish(boolean isFinish) {
        this.isFinish = isFinish;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
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
        setIsAction(false);
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
        if (isAction()) {
            if (getListOfEmptyCells().size() > 0) {
                Cell cell = new RandomEmptyCellGetter().getEmptyCell(getListOfEmptyCells());
                int cellValue = new RandomCellValueGenerator().createValueForNewCell();
                gameField[cell.getLineNumber()][cell.getColomnNumber()].setValue(cellValue);
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
                            if (gameField[i][k - 1].getValue() == gameField[i][k].getValue()
                                    && gameField[i][k - 1].isMult()) {

                                gameField[i][k - 1].doubleValue();
                                gameField[i][k - 1].setIsMult(false);
                                gameField[i][k].setValue(0);
                                if (gameField[i][k - 1].getValue() > 1024) {
                                    setIsFinish(true);
                                }
                                setScore(gameField[i][k - 1].getValue());
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

    public void availableMove() {

        if (!isAction()) {
            int pairCells = 0;
            for (int i = 0; i < FIELD_LENGTH; i++) {
                for (int j = 1; j < FIELD_LENGTH; j++) {
                    if (gameField[i][j] == gameField[i][j - 1]) {
                        pairCells++;
                    }
                }
            }
            rotate.rotateRight(gameField);
            for (int i = 0; i < FIELD_LENGTH; i++) {
                for (int j = 1; j < FIELD_LENGTH; j++) {
                    if (gameField[i][j] == gameField[i][j - 1]) {
                        pairCells++;
                    }
                }
            }
            rotate.rotateRight(gameField);
            rotate.rotateRight(gameField);
            rotate.rotateRight(gameField);
            if (pairCells == 0) {
                setIsFinish(true);
            }
        }
    }

    public void move(Direction direction) {
        switch (direction) {
            case LEFT:
                moveLeft();
                break;
            case RIGHT:
                moveRight();
                break;
            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
        }
    }

    public void moveUp() {
        rotate.rotateRight(gameField);
        rotate.rotateRight(gameField);
        rotate.rotateRight(gameField);
        slideLeft();
        rotate.rotateRight(gameField);
    }

    public void moveLeft() {
        slideLeft();
    }

    public void moveDown() {
        rotate.rotateRight(gameField);
        slideLeft();
        rotate.rotateRight(gameField);
        rotate.rotateRight(gameField);
        rotate.rotateRight(gameField);
    }

    public void moveRight() {
        rotate.rotateRight(gameField);
        rotate.rotateRight(gameField);
        slideLeft();
        rotate.rotateRight(gameField);
        rotate.rotateRight(gameField);
    }
}
