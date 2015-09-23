package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
/**
 * Created by lsantano on 9/22/15.
 */
public class LibraryTest {

    @Test
    public void shouldReturnOneBookDetailsWhenLibraryContainsSingleBook(){
        PrintStream printStream = mock(PrintStream.class);
        Book book1 = mock(Book.class);
        ArrayList<Book> mockBooks = new ArrayList<>();
        mockBooks.add(book1);
        Library library = new Library(mockBooks);
        library.showBooks(printStream);

        verify(printStream).println(book1);
    }

//    @Test
//    public void whenAppStartsShouldListTwoBooksWhenLibraryContainsTwoBooks(){
//        app.start();
//        verify(printStream).println("Welcome!");
//        verify(printStream).println("Book1");
//        verify(printStream).println("Programmers Guide to Programming");
//    }
}