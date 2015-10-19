package Field;

import java.util.Random;

/**
 * Created by employee on 10/19/15.
 */
public class RandomCellValueGenerator implements CellValueGeneratorInterface {

    public int createValueForNewCell() {

        Random random = new Random();

        int cellValue = 0;


        return cellValue = random.nextInt(10) == 1 ? 4 : 2;
    }
}
