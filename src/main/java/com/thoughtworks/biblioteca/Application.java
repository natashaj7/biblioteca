package com.thoughtworks.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by lsantano on 9/22/15.
 */
public class Application {

    private PrintStream printStream;
    private Library library;

    public Application(PrintStream printStream, Library library) {
        this.printStream = printStream;
        this.library = library;
    }

    public void start() {
        printStream.println("Welcome!");
        library.showBooks(printStream);
    }


}
