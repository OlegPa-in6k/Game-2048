package field;

import java.util.List;

/**
 * Created by employee on 10/19/15.
 */
public class StaticEmptyCellGetter implements EmptyCellGetter {

    public Cell getEmptyCell(List<Cell> emptyCells) {

        return emptyCells.get(0);

    }
}
