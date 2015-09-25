package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainMenuTest {

    private final String QUIT = "Quit";
    private final String INVALID_OPTION = "0";
    private final String LIST_BOOKS = "1";
    private final String CHECKOUT = "2";
    private final String RETURN = "3";
    private MainMenu mainMenu;
    private PrintStream printStream;
    private Library library;
    private UserBufferedReader reader;
    private HashMap<String, Command> commandMap;


    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        library = mock(Library.class);
        reader = mock(UserBufferedReader.class);
        commandMap = mock(HashMap.class);
        mainMenu = new MainMenu(printStream, library, reader, commandMap);

    }

    @Test
    public void shouldDisplayMenuOptionsWhenSelectingOption(){
        when(reader.readLine()).thenReturn("", QUIT);
        mainMenu.selectOption();
        verify(printStream).println(contains("Please choose an option"));
    }

    @Test
    public void shouldListBooksWhenUserEntersOne(){
       // when(commandMap.containsKey("1")).thenReturn(true);

        when(reader.readLine()).thenReturn(LIST_BOOKS, QUIT);

        mainMenu.selectOption();

        verify(commandMap).get("1").execute();
    }

    @Test
    public void shouldDisplaySelectValidOptionWhenOptionIsNotOne(){
        when(reader.readLine()).thenReturn(INVALID_OPTION, QUIT);

        mainMenu.selectOption();

        verify(printStream).println("Select Valid Option!");
    }


    @Test
    public void shouldQuitWhenUserInputsQ(){
        when(reader.readLine()).thenReturn(INVALID_OPTION, LIST_BOOKS, QUIT);

        mainMenu.selectOption();

        verify(printStream).println("Done!");

    }

    @Test
    public void shouldCheckOutWhenUserInputsTwo(){
        when(reader.readLine()).thenReturn(CHECKOUT, "bookTitle", QUIT);
        mainMenu.selectOption();
        verify(commandMap).get("2").execute();

    }

    @Test
    public void shouldReturnBookWhenUserInputsThree(){
        when(reader.readLine()).thenReturn(RETURN, "title", QUIT);

        mainMenu.selectOption();

        verify(library).returnBook("title");
    }
}