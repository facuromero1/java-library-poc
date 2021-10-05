package service;

import model.Book;
import repo.BookRepo;

import java.util.ArrayList;

public class BookService {
    private BookRepo bookRepo;

    public BookService() {
        this.bookRepo = new BookRepo();
    }

    public void createBook(String bookname, String author, int year,int isbn) {
        Book book = new Book(bookname, author, year,isbn);
        bookRepo.addBook(book);
    }

    public ArrayList<Book> findBooks(String name, String author) {
        Book book = bookRepo.getBook(name, author);
        if (book != null){
            return bookRepo.findBooks(book);
        }
        return null;
    }



    public Book getBook(String name, String author) {
        return (bookRepo.getBook(name,author));
    }

    public Book getBookReservation(String name,String author,int isbn) {
        return bookRepo.getBookReservation(name, author,isbn);

    }
}
