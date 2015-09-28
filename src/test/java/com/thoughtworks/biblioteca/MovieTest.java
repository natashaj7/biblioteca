package com.thoughtworks.biblioteca;

import org.junit.Test;
import org.mockito.asm.ClassReader;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by njimenez on 9/28/15.
 */
public class MovieTest {

    @Test
    public void shouldDisplayDetailsToUserWhenOutputting() {
        Movie movie = new Movie("movie1", "1993", "Natasha", "6");

        assertEquals(movie.movieOutput(), "movie | 1993 | Natasha | 6");
    }
}