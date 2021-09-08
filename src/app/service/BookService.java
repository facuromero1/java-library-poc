package app.service;

import app.model.Book;
import app.repo.BookRepo;
import app.repo.UserRepo;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class BookService {
    private BookRepo bookRepo;

    public BookService() {
        this.bookRepo = new BookRepo();
    }

    public void createBook(String bookname, String author, int year) {
        Book book = new Book(bookname, author, year);
        bookRepo.addBook(book);
    }

    public boolean bookExists(String name, String author, int year) {
        Book book = bookRepo.getBook(name, author, year);
        return book != null;
    }

    public Book foundBook(String name,String author,int year){
        Book book = bookRepo.getBook(name,author,year);
        return book;
    }
}
