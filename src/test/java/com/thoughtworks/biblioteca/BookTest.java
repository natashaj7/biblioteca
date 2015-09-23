package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by lsantano on 9/23/15.
 */
public class BookTest {

    @Test
    public void shouldPrintNameAuthorYearOfBook(){
        Book book1 = new Book("Book1", "Lucy", 1995);

        assertThat(book1.bookOutput(), is("Book1 | Lucy | 1995"));

    }

}