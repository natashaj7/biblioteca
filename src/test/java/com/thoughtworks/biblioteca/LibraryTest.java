package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by lsantano on 9/22/15.
 */
public class LibraryTest {

    private Library library;
    private Book book1;
    private ArrayList<Book> books;
    private PrintStream printStream;

    @Before
    public void setUp(){
        book1 = mock(Book.class);
        books = new ArrayList<>();
        books.add(book1);

        printStream = mock(PrintStream.class);
        library = new Library(books, printStream);

    }
    @Test
    public void shouldCallToStringFromBookClass(){
        library.showBooks();

        verify(book1).bookOutput();
    }

    @Test
    public void shouldReturnTrueWhenTheLibraryContainsTheBook() {
        assertThat(library.contains(book1), is(true));
    }

    @Test
    public void shouldRemoveBookFromListWhenCheckedOut(){
        when(book1.hasTitle("book title")).thenReturn(true);

        library.checkOut("book title");

        assertThat(library.contains(book1), is(false));
    }

    @Test
    public void shouldGiveSuccessfulCheckoutMessageIfBookIsCheckedOut(){
        when(book1.hasTitle("book title")).thenReturn(true);

        library.checkOut("book title");

        verify(printStream).println("Thank You! Enjoy the book.");
    }

    @Test
    public void shouldGiveErrorCheckoutMessageIfBookIsNotAvailable(){
        when(book1.hasTitle("book title")).thenReturn(false);

        library.checkOut("book title");

        verify(printStream).println("That book is not available.");
    }
}