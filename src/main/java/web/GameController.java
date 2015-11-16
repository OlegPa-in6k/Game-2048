package web;

import field.Direction;
import field.GameField;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@SessionAttributes(value = "gameField")
@Scope("session")
public class GameController extends BaseController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getMainPage() {
        return "main";
    }

    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public String getGamePage(@ModelAttribute("gameField") GameField gameField, ModelMap model) {
        model.addAttribute("gameField", gameField);
        return "game";
    }

    @RequestMapping(value = "/game", method = RequestMethod.POST)
    public
    @ResponseBody
    String makeMove(@RequestParam("direction") String direction) {
        gameField.move(Direction.getDirection(direction));
        gameField.addNewCell();
        String field = "";
        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {
                field += gameField.gameField[i][j].getValue() + ",";
            }
        }
        field += gameField.getScore();
        return field;
    }

    @ModelAttribute("gameField")
    public GameField createGameField() {
        GameField gameField = new GameField();
        gameField.makeStartField();
        this.gameField = gameField;
        return gameField;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String startNewGame() {
        createGameField();
        return "redirect:/game";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;

    }

    //for 403 access denied page
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {

        ModelAndView model = new ModelAndView();

        //check if user is login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            model.addObject("username", userDetail.getUsername());
        }

        model.setViewName("403");
        return model;

    }



}
