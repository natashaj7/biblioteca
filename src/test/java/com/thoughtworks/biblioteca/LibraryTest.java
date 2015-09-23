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
    public void shouldCallToStringFromBookClass(){
        PrintStream printStream = mock(PrintStream.class);
        Book book1 = mock(Book.class);
        ArrayList<Book> mockBooks = new ArrayList<>();
        mockBooks.add(book1);
        Library library = new Library(mockBooks, printStream);
        library.showBooks();

        verify(book1).bookOutput();
    }
}