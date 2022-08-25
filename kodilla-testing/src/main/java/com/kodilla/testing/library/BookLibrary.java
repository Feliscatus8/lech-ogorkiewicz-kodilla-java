package com.kodilla.testing.library;

import java.util.ArrayList;
import java.util.List;

public class BookLibrary {
    private LibraryDatabase libraryDatabase;

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }
    public List<Book> listBooksWithCondition(String titleFragment){
        List<Book> emptyList = new ArrayList<>();
        if(titleFragment.length()<3) return emptyList;
        List<Book> resultList = this.libraryDatabase.listBooksWithCondition(titleFragment);
        if (resultList.size()>20) return emptyList;
        return resultList;
    }
    public List<Book> listBooksInHandsOf(LibraryUser libraryUser){
        return this.libraryDatabase.listBooksInHandsOf(libraryUser);
    }
}
