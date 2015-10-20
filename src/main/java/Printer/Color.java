package Printer;

/**
 * Created by employee on 10/20/15.
 */
public class Color {
    public static final String DEFAULT_COLOR = "\u001b[0m";
    public static final String COLOR_OF_2 = "\u001b[31m";
    public static final String COLOR_OF_4 = "\u001b[32m";
    public static final String COLOR_OF_8 = "\u001b[33m";
    public static final String COLOR_OF_16 = "\u001b[34m";
    public static final String COLOR_OF_32 = "\u001b[35m";
    public static final String COLOR_OF_64 = "\u001b[36m";
    public static final String COLOR_OF_BIG_NUMBERS = "\u001b[0m";


    Color() {
    }

    int numberColor;

    public String getColor(int number) {
        String color = "";
        switch (number) {
            case 2:
                color = "\u001b[31m";
                break;
            case 4:
                color = "\u001b[32m";
                break;
            case 8:
                color = "\u001b[33m";
                break;
            case 16:
                color = "\u001b[34m";
                break;
            case 32:
                color = "\u001b[35m";
                break;
            case 64:
                color = "\u001b[36m";
                break;
            default:
                color = "\u001b[37m";
                break;
        }

        return color;
    }

}
