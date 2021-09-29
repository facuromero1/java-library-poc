package repo;

import model.Book;

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

    public Book getBook(String name,int isbn) {
        for (Book book : books) {
            if (book.equals(name) && book.getIsbn()== isbn) {
                return book;
            }
        }
        return null;
    }
}
