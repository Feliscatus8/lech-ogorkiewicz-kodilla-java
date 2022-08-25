package com.kodilla.testing.library;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {
    @Mock
    private  LibraryDatabase libraryDatabaseMock;
    private List<Book> generateListOfBooks(int booksQuantity){
        List<Book> resultList = new ArrayList<>();
        for (int n=1; n<= booksQuantity; n++){
            Book theBook = new Book("My Cat " + n, "Catlover" + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }
    @Nested
    class TestListBooksWithCondition {
        @Test
        void testListBooksWithConditionReturnList() {
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOfBooks = new ArrayList<>();                                // [4]
            Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);                   // [5]
            Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);    // [6]
            Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);    // [7]
            Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);                 // [8]
            resultListOfBooks.add(book1);                                                    // [9]
            resultListOfBooks.add(book2);                                                    // [10]
            resultListOfBooks.add(book3);                                                    // [11]
            resultListOfBooks.add(book4);                                                    // [12]
            when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);// [13]

            // When
            List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");        // [14]

            // Then
            assertEquals(4, theListOfBooks.size());
        }

        @Test
        void testListBooksWithConditionMoreThan20() {
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOf0Books = new ArrayList<Book>();
            List<Book> resultListOf15Books = generateListOfBooks(15);
            List<Book> resultListOf40Books = generateListOfBooks(40);
            when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                    .thenReturn(resultListOf15Books);
            when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                    .thenReturn(resultListOf0Books);
            when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))
                    .thenReturn(resultListOf40Books);

            //When
            List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
            List<Book> theLostOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
            List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");

            //Then
            assertEquals(0, theListOfBooks0.size());
            assertEquals(15, theLostOfBooks15.size());
            assertEquals(0, theListOfBooks40.size());
        }

        @Test
        void testListBookWithConditionFragmentShorterThan3() {
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

            //When
            List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

            //Then
            assertEquals(0, theListOfBooks10.size());
            verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
        }
    }
    @Test
    void testBooksInHandsOf(){
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser noBooks = new LibraryUser("No", "Books", "77070777777");
        LibraryUser oneBook = new LibraryUser("One", "Book", "some Id");
        LibraryUser fiveBooks = new LibraryUser("Five", "Books", "other Id");
        when(libraryDatabaseMock.listBooksInHandsOf(noBooks)).thenReturn(new ArrayList<Book>());
        when(libraryDatabaseMock.listBooksInHandsOf(oneBook)).thenReturn(generateListOfBooks(1));
        when(libraryDatabaseMock.listBooksInHandsOf(fiveBooks)).thenReturn(generateListOfBooks(5));

        //When
        List<Book> noBooksList = bookLibrary.listBooksInHandsOf(noBooks);
        List<Book> oneBookList = bookLibrary.listBooksInHandsOf(oneBook);
        List<Book> fiveBooksList = bookLibrary.listBooksInHandsOf(fiveBooks);

        //Then
        assertEquals(0, noBooksList.size());
        assertEquals(1, oneBookList.size());
        assertEquals(5, fiveBooksList.size());
    }
}
