package console.controllers;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by employee on 11/12/15.
 */
public class ConsoleStream {

    public static InputStream input() {
        return System.in;
    }

    public static OutputStream output() {
        return System.out;
    }
}
