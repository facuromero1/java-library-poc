package app.service;

import app.model.Book;
import app.repo.BookRepo;

public class BookService {
    private BookRepo bookRepo;

    public BookService() {
        this.bookRepo = new BookRepo();
    }

    public void createBook(String bookname, String author, int year) {
        Book book = new Book(bookname, author, year);
        bookRepo.addBook(book);
    }

    public boolean findBook(String name, String author, int year) {
        Book book = bookRepo.getBook(name, author, year);
        return book != null;
    }

    public Book getBook(String name, String author, int year) {
        return (bookRepo.getBook(name, author, year));
    }
}
