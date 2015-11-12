package web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by employee on 11/12/15.
 */
@Controller
@RequestMapping(value = "/game")
public class GameController extends BaseController {


    @RequestMapping(method = RequestMethod.GET)
    public String selectSeats(ModelMap modelMap) {
        gameField.setEmptyBoard();
        gameField.makeStartField();
        modelMap.addAttribute("gameField", gameField.gameField);
        return "game";
    }

}
