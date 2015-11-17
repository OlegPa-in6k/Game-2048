package core.field;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/20/15.
 */
public class MatrixRotationTest {
    GameField gameField = new GameField();
    MatrixRotation rotate = new MatrixRotation();

    @Test
    public void testRotateRight() throws Exception {

        gameField.setEmptyBoard();
        gameField.gameField[0][0].setValue(1);
        gameField.gameField[1][0].setValue(2);
        gameField.gameField[2][3].setValue(3);
        gameField.gameField[3][3].setValue(4);
        rotate.rotateRight(gameField.gameField);
        assertThat(gameField.toString(), is(
                "0 0 2 1 \n" +
                        "0 0 0 0 \n" +
                        "0 0 0 0 \n" +
                        "4 3 0 0 \n"
        ));


    }


}
