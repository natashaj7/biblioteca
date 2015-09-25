package com.thoughtworks.biblioteca;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by lsantano on 9/22/15.
 */
public class Library {

    private ArrayList<Book> books;
    private PrintStream printStream;

    public Library(ArrayList<Book> books, PrintStream printStream){
        this.books = books;
        this.printStream = printStream;
    }

    public void showBooks() {
        String bookList = "";
        for(Book item:books){
            bookList+=(item.bookOutput() + "\n");
        }
        printStream.println(bookList);
    }

    public void checkOut(String bookTitle) {
        boolean bookExists = false;
        for(Book book: books){
            if (book.hasTitle(bookTitle)){
                bookExists = true;
                books.remove(book);
                printStream.println("Thank You! Enjoy the book.");
                break;
                //CollectionUtils.find(books, hasTitle(""));

            }
        }

        if(!bookExists){
            printStream.println("That book is not available.");
        }


    }

    public boolean contains(Book book1) {
        return books.contains(book1);
    }

    public void returnBook(String title, String author, String year) {
    }
}
