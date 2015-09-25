package com.thoughtworks.biblioteca;

import java.io.PrintStream;

public class MainMenu {

    private PrintStream printStream;
    private Library library;
    private UserBufferedReader reader;

    public MainMenu(PrintStream printStream, Library library, UserBufferedReader reader) {
        this.printStream = printStream;
        this.library = library;
        this.reader = reader;
    }

    public void selectOption() {
        printStream.println("Please choose an option from below or type \"Quit\""+
                            "\n1 - List Books" +
                            "\n2 - Checkout" +
                            "\n3 - Return Book");
        String option="";

        while(!option.equals("Quit")){
            option = reader.readLine();

            if (option.equals("1")) {
                library.showBooks();
            }
            else if(option.equals("2")){
                String bookTitle = reader.readLine();
                library.checkOut(bookTitle);
            }
            else if(option.equals("3")){
                String bookTitle = reader.readLine();
                library.returnBook(bookTitle);

            }
            else if(!option.equals("Quit")) {
                printStream.println("Select Valid Option!");
            }

        }

        printStream.println("Done!");



    }

}
