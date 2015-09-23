package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Book> libraryBooks = new ArrayList<>();

        Book book1 = new Book("book1", "author1", 2010);
        Book book2 = new Book("Programmers Guide to Programming", "Natasha", 2005);
        Book book3 = new Book("Thoughtworks: A How To", "Lucy", 2008);
        libraryBooks.add(book1);
        libraryBooks.add(book2);
        libraryBooks.add(book3);

        Library library = new Library(libraryBooks);

        Application app = new Application(System.out, library);
        app.start();
    }
}
