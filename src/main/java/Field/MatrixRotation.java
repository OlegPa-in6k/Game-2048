package Field;

/**
 * Created by employee on 10/19/15.
 */
public class MatrixRotation {
    int lenght = GameField.FIELD_LENGTH;

    public void rotateRight(Cell[][] cells) {
        for (int i = 0; i < lenght / 2; i++) {
            for (int j = 0; j < Math.ceil(((double) lenght) / 2.); j++) {
                Cell temp = cells[i][j];
                cells[i][j] = cells[lenght - 1 - j][i];
                cells[lenght - 1 - j][i] = cells[lenght - 1 - i][lenght - 1 - j];
                cells[lenght - 1 - i][lenght - 1 - j] = cells[j][lenght - 1 - i];
                cells[j][lenght - 1 - i] = temp;
            }
        }
    }

}
