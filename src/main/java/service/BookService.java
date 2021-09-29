package service;

import model.Book;
import repo.BookRepo;

public class BookService {
    private BookRepo bookRepo;

    public BookService() {
        this.bookRepo = new BookRepo();
    }

    public void createBook(String bookname, String author, int year,int isbn) {
        Book book = new Book(bookname, author, year,isbn);
        bookRepo.addBook(book);
    }

    public boolean findBook(String name,int isbn) {
        Book book = bookRepo.getBook(name,isbn);
        return book != null;
    }

    public Book getBook(String name,int isbn) {

        return (bookRepo.getBook(name,isbn));
    }
}
