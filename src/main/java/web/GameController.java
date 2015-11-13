package web;

import field.Direction;
import field.GameField;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created by employee on 11/12/15.
 */
@Controller
@SessionAttributes(value = "gameField")
@Scope("session")
public class GameController extends BaseController {

   /* @Autowired
    private GameField gameField;*/

  /*  @RequestMapping(method = RequestMethod.GET)
    public String selectSeats(ModelMap modelMap) {
        modelMap.addAttribute("gameField", gameField.gameField);
        return "game";
    }*/

   /* @RequestMapping(method = RequestMethod.GET)
    public String getMainPage() {
        return "main";
    }*/

    @RequestMapping(method = RequestMethod.GET)
    public String getMainPage() {
        return "main";
    }

    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public String getGamePage(@ModelAttribute("gameField") GameField gameField, ModelMap model) {
        model.addAttribute("gameField", gameField);
        return "game";
    }

    @RequestMapping(value = "/game", method = RequestMethod.POST)
    public String makeMove(@RequestParam("direction") String direction) {
        gameField.move(Direction.getDirection(direction));
        gameField.addNewCell();
        return "redirect:/game";
    }

    @ModelAttribute("gameField")
    public GameField createGameField() {
        GameField gameField = new GameField();
        gameField.setEmptyBoard();
        gameField.makeStartField();
        this.gameField = gameField;
        return gameField;
    }


}
