package field;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/19/15.
 */
public class ConsoleGameControllerFieldTest {
    GameField gameField = new GameField();
    StaticEmptyCellGetter st = new StaticEmptyCellGetter();

    @Test
    public void testSetEmptyBoard() throws Exception {
        gameField.setEmptyBoard();
        assertThat(gameField.toString(), is(
                        "0 0 0 0 \n" +
                        "0 0 0 0 \n" +
                        "0 0 0 0 \n" +
                        "0 0 0 0 \n"));

    }

    @Test
    public void testStaticInsert() throws Exception {
        gameField.setEmptyBoard();

        for (int i = 0; i < 40; i++) {
            addNewCell();
        }
        assertThat(gameField.toString(), is(
                "8 8 8 8 \n" +
                        "8 8 8 8 \n" +
                        "8 8 8 8 \n" +
                        "8 8 8 8 \n"
        ));

    }

    public void addNewCell() {
        if (gameField.getListOfEmptyCells().size() > 0) {
            Cell cell = new StaticEmptyCellGetter().getEmptyCell(gameField.getListOfEmptyCells());
            int cellValue = new StaticCellValueGenerator().createValueForNewCell();
            gameField.gameField[cell.getLineNumber()][cell.getColomnNumber()].setValue(cellValue);
        }
    }


    @Test
    public void testRandomInsertWithStaticValue() throws Exception {
        gameField.setEmptyBoard();
        for (int i = 0; i < 16; i++) {
            addNewCellInRandomPlace();
        }
        assertThat(gameField.toString(), is(
                "2 2 2 2 \n" +
                        "2 2 2 2 \n" +
                        "2 2 2 2 \n" +
                        "2 2 2 2 \n"
        ));
    }

    public void addNewCellInRandomPlace() {

        if (gameField.getListOfEmptyCells().size() > 0) {
            int staticValue = new StaticCellValueGenerator().createValueForNewCell();
            Cell cell = new RandomEmptyCellGetter().getEmptyCell(gameField.getListOfEmptyCells());
            gameField.gameField[cell.getLineNumber()][cell.getColomnNumber()].setValue(staticValue);
        }
    }


    public void fillBoardWithDifferentNumbers() {
        int value = 0;
        for (int i = 0; i < gameField.FIELD_LENGTH; i++) {
            for (int j = 0; j < gameField.FIELD_LENGTH; j++) {
                gameField.gameField[i][j].setValue(value);
                value++;
            }
        }
    }

    @Test
    public void testSlideLeft() throws Exception {
        gameField.setEmptyBoard();

        for (int i = 0; i < 16; i++) {
            addNewCell();
        }
        gameField.gameField[0][0].setValue(128);
        gameField.gameField[0][1].setValue(128);
        gameField.gameField[1][0].setValue(128);
        gameField.gameField[1][3].setValue(128);


        gameField.slideLeft();
        assertThat(gameField.toString(), is(

                "256 16 0 0 \n" +
                        "128 16 128 0 \n" +
                        "16 16 0 0 \n" +
                        "16 16 0 0 \n"
        ));

    }

    @Test
    public void testSlideDown() throws Exception {
        gameField.setEmptyBoard();
        for (int i = 0; i < 16; i++) {
            addNewCell();
        }
        gameField.moveDown();

        assertThat(gameField.toString(), is(
                "0 0 0 0 \n" +
                        "0 0 0 0 \n" +
                        "4 4 4 4 \n" +
                        "4 4 4 4 \n"
        ));


    }

    @Test
    public void testSlideUp() throws Exception {
        gameField.setEmptyBoard();
        for (int i = 0; i < 16; i++) {
            addNewCell();
        }
        gameField.moveUp();


        assertThat(gameField.toString(), is(
                "4 4 4 4 \n" +
                        "4 4 4 4 \n" +
                        "0 0 0 0 \n" +
                        "0 0 0 0 \n"
        ));


    }

    @Test
    public void testSlideRight() throws Exception {
        gameField.setEmptyBoard();
        for (int i = 0; i < 16; i++) {
            addNewCell();
        }
        gameField.moveRight();


        assertThat(gameField.toString(), is(
                "0 0 4 4 \n" +
                        "0 0 4 4 \n" +
                        "0 0 4 4 \n" +
                        "0 0 4 4 \n"
        ));


    }

    @Test
    public void testSlideLeftWhen2244() throws Exception {
        gameField.setEmptyBoard();


        for (int i = 0; i < gameField.FIELD_LENGTH; i++) {
            for (int j = 0; j < gameField.FIELD_LENGTH; j++) {
                int value = 2;
                if (j > 1) {
                    value = 4;
                }
                gameField.gameField[i][j].setValue(value);

            }
        }
        gameField.slideLeft();
        assertThat(gameField.toString(), is(
                "4 8 0 0 \n" +
                        "4 8 0 0 \n" +
                        "4 8 0 0 \n" +
                        "4 8 0 0 \n"
        ));

    }

    @Test
    public void testMoveWithDirection() throws Exception {
        gameField.setEmptyBoard();
        for (int i = 0; i < gameField.FIELD_LENGTH; i++) {
            for (int j = 0; j < gameField.FIELD_LENGTH; j++) {
                int value = 2;
                if (j > 1) {
                    value = 4;
                }
                gameField.gameField[i][j].setValue(value);

            }
        }
        gameField.move(Direction.RIGHT);
        assertThat(gameField.toString(), is(
                        "0 0 4 8 \n" +
                        "0 0 4 8 \n" +
                        "0 0 4 8 \n" +
                        "0 0 4 8 \n"
        ));

    }
}




