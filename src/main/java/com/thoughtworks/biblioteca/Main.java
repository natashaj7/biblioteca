package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        ArrayList<Book> availableBooks = new ArrayList<>();
        ArrayList <Book> checkedOutBooks = new ArrayList<>();
        Book book1 = new Book("book1", "author1", "2010");
        Book book2 = new Book("Programmers Guide to Programming", "Natasha", "2005");
        Book book3 = new Book("Thoughtworks: A How To", "Lucy", "2008");
        Book book4 = new Book("CheckIn", "Natasha", "2012");
        availableBooks.add(book1);
        availableBooks.add(book2);
        availableBooks.add(book3);
        checkedOutBooks.add(book4);

        Library library = new Library(availableBooks, checkedOutBooks, System.out);
        MainMenu mainMenu = new MainMenu(System.out, library, new UserBufferedReader(new BufferedReader(new InputStreamReader(System.in))));

        Application app = new Application(System.out, mainMenu);
        app.start();
    }
}
