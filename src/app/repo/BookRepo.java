package app.repo;

import app.model.Book;
import app.model.User;

import java.util.ArrayList;

public class BookRepo {
    private ArrayList<Book> books;

    public BookRepo() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (book != null) {
            books.add(book);
        }
    }

    public Book getBook(String name, String author, int year) {
        for (Book book : books) {
            if (book.equals(name, author, year)) {
                return book;
            }
        }
        return null;
    }
}
