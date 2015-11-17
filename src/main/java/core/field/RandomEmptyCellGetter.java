package core.field;

import java.util.List;
import java.util.Random;

/**
 * Created by employee on 10/19/15.
 */
public class RandomEmptyCellGetter implements EmptyCellGetter {

    public Cell getEmptyCell(List<Cell> emptyCells) {
        Random random = new Random();
        int cellNumber = random.nextInt(emptyCells.size());

        return emptyCells.get(cellNumber);
    }
}
