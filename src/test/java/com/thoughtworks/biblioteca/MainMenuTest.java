package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by lsantano on 9/23/15.
 */
public class MainMenuTest {

    private MainMenu mainMenu;
    private PrintStream printStream;
    private Library library;
    private UserBufferedReader reader;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        library = mock(Library.class);
        reader = mock(UserBufferedReader.class);
        mainMenu = new MainMenu(printStream, library, reader);
    }

    @Test
    public void shouldDisplayMenuOptionsWhenSelectingOption(){
        when(reader.readLine()).thenReturn("", "Quit");
        mainMenu.selectOption();
        verify(printStream).println("Please choose an option from below or type \"Quit\"" +
                "\n1 - List Books" +
                "\n2 - Checkout");
    }

    @Test
    public void shouldListBooksWhenUserEntersOne(){
        when(reader.readLine()).thenReturn("1", "Quit");

        mainMenu.selectOption();

        verify(library).showBooks();
    }

    @Test
    public void shouldDisplaySelectValidOptionWhenOptionIsNotOne(){
        when(reader.readLine()).thenReturn("0", "Quit");

        mainMenu.selectOption();

        verify(printStream).println("Select Valid Option!");
    }


    @Test
    public void shouldQuitWhenUserInputsQ(){
        when(reader.readLine()).thenReturn("0", "1", "Quit");

        mainMenu.selectOption();

        verify(printStream).println("Done!");

    }

    @Test
    public void shouldCheckOutWhenUserInputsTwo(){
        when(reader.readLine()).thenReturn("2", "Quit");
        mainMenu.selectOption();
        verify(library).checkOut();

    }
}