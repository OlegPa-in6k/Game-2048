package Field;

/**
 * Created by employee on 10/19/15.
 */
public class Cell {

    private int value;
    private int colomnNumber;
    private int LineNumber;

    public int getLineNumber() {
        return LineNumber;
    }

    public void setLineNumber(int lineNumber) {
        LineNumber = lineNumber;
    }

    public int getColomnNumber() {
        return colomnNumber;
    }

    public void setColomnNumber(int colomnNumber) {
        this.colomnNumber = colomnNumber;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }



}
