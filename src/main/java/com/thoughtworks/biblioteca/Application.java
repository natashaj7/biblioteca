package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by lsantano on 9/22/15.
 */
public class Application {

    private PrintStream printStream;
    private Library library;
    private MainMenu mainMenu;

    public Application(PrintStream printStream, Library library, MainMenu mainMenu) {
        this.printStream = printStream;
        this.library = library;
        this.mainMenu = mainMenu;
    }

    public void start() throws IOException {
        printStream.println("Welcome!");
        library.showBooks();
    }

    private void runMainMenu() throws IOException {
        mainMenu.display();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
    }
}
