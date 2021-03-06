package com.thoughtworks.tddintro.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class LibraryTest {

    List<String> books;
    PrintStream printStream;
    Library library;
    DateTime time;
    DateTimeFormatter dateTimeFormatter;
    /*

        List books tests. Implement the first three tests for the Verify exercise

     */


    @Before
    public void setup(){
        books =new ArrayList<>();
        printStream = mock(PrintStream.class);
        time = new DateTime();
        dateTimeFormatter = mock(DateTimeFormatter.class);

    }

    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {

        String title = "Book Title";
        books.add(title);
        Library library = new Library(books, printStream, null);

        library.listBooks();

        // add a verify statement here that shows that the book title was printed by to the printStream
        verify(printStream).println("Book Title");

    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {
        Library library = new Library(books, printStream, null);
        library.listBooks();
        verifyZeroInteractions(printStream);
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() {
        Library library = new Library(books, printStream, null);
        String title1 = "Book Title1";
        String title2 = "Book Title2";
        books.add(title1);
        books.add(title2);
        library.listBooks();
        verify(printStream).println("Book Title1");
        verify(printStream).println("Book Title2");

    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */

    
    // This one is done for you
    @Test
    public void shouldWelcomeUser() {

        Library library = new Library(books, printStream, dateTimeFormatter);

        // We don't need to mock DateTime because it is a value object
        // We can't mock it because it is a final class
        DateTime time = new DateTime();
        
        library.welcome(time);
        
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsAnEmptyString() {

        when(dateTimeFormatter.print(time)).thenReturn("");

        Library library = new Library(books, printStream, dateTimeFormatter);

        library.welcome(time);

        // add a verify here
        verify(printStream).println("Welcome to the library! The current time is ");
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsNotEmpty() {
        when(dateTimeFormatter.print(time)).thenReturn("6:51 PM");

        Library library = new Library(books, printStream, dateTimeFormatter);
        library.welcome(time);

        verify(printStream).println("Welcome to the library! The current time is 6:51 PM");

    }
}