package controllers;

import console.InputController;
import field.GameField;

/**
 * Created by employee on 11/12/15.
 */
public class WebGameController {

    GameField gameField;

    InputController input;

    public void startGame() {

        gameField.setEmptyBoard();
        gameField.makeStartField();
        while (gameField.isAvailableMove() && !gameField.isFinish()) {
            gameField.move(input.getDirection());
            gameField.addNewCell();
        }
    }


}
