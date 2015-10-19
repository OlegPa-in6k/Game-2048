package Field;

import java.util.Random;

/**
 * Created by employee on 10/19/15.
 */
public class RandomCellGenerator implements CellGeneratorInterface {

    public int createNewCell() {
        Random random = new Random();
        int cellValue = 0;
        switch (random.nextInt(10)) {
            case 1:
                cellValue = 4;
                break;
            default:
                cellValue = 2;
                break;

        }
        return cellValue;
    }
}
