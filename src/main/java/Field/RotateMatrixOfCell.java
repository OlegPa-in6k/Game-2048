package Field;

/**
 * Created by employee on 10/19/15.
 */
public class RotateMatrixOfCell {
    int lenght = GameField.FIELD_LENGTH;

    public void rotateRight(Cell[][] gameField) {
        for (int i = 0; i < lenght / 2; i++) {
            for (int j = 0; j < Math.ceil(((double) lenght) / 2.); j++) {
                Cell temp = gameField[i][j];
                gameField[i][j] = gameField[lenght - 1 - j][i];
                gameField[lenght - 1 - j][i] = gameField[lenght - 1 - i][lenght - 1 - j];
                gameField[lenght - 1 - i][lenght - 1 - j] = gameField[j][lenght - 1 - i];
                gameField[j][lenght - 1 - i] = temp;
            }
        }
    }

}
