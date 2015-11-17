package core.field;

/**
 * Created by employee on 10/19/15.
 */
public class Cell {

    private int value;
    private int colomnNumber;
    private int LineNumber;
    private boolean isMult = true;

    public boolean isMult() {
        return isMult;
    }

    public void setIsMult(boolean isMult) {
        this.isMult = isMult;
    }

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

    public void doubleValue() {
        setValue(getValue() * 2);
    }


}
