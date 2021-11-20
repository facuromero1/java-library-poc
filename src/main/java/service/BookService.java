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

    public ArrayList<Book> findBooks(String nameBook,String author) {
        return bookRepo.findBooks(nameBook,author);
        }


    public Book getBook(int isbn) {
        return bookRepo.getBook(isbn);
    }


}
