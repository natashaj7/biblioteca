package com.thoughtworks.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by lsantano on 9/22/15.
 */
public class Library {

    private ArrayList<Book> books;

    public Library(ArrayList<Book> books){
        this.books = books;
    }

    public void showBooks(PrintStream printStream) {
        String bookList = "";
        for(Book item:books){
            bookList.concat(item+"\n");
        }
        printStream.println(bookList);
    }
}
