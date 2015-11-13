package field;

/**
 * Created by employee on 10/19/15.
 */
public enum Direction {
    UP, DOWN, RIGHT, LEFT, NEW;

    public static Direction getDirection(String dir) {
        dir = dir.trim().toLowerCase();
        switch (dir) {
            case "left":
                return LEFT;
            case "right":
                return RIGHT;
            case "up":
                return UP;
            case "down":
                return DOWN;
            /*case "new":
                return NEW;*/
            default:
                return null;
        }
    }
}
