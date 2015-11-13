package web;

import field.GameField;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by employee on 11/12/15.
 */

public class BaseController {
    @Autowired
    GameField gameField;

}
