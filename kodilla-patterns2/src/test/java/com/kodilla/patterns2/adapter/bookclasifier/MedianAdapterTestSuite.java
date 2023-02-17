package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest() {
        //Given
        Book book1 = new Book("Behemot", "Cat", 1984, "11111112");
        Book book2 = new Book("Klakier", "Cat and Cat", 1948, "11111114");
        Book book3 = new Book("Bonifacy", "Cat, Cat and Cat", 2005, "11111118");
        Book book4 = new Book("Puszek", "Cat and Kitten", 2012, "11111116");
        Book book5 = new Book("Mruczek", "Cat, Cat and Kitten", 2019, "11111132");

        Set<Book> bookSet = new HashSet<>();
        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        bookSet.add(book4);
        bookSet.add(book5);

        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        int median = medianAdapter.publicationYearMedian(bookSet);

        //Then
        assertEquals(2005, median);
    }
}
