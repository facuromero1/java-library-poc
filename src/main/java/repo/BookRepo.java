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

    public ArrayList<Book> findBooks(Book book) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book i : books) {
            if (book.getName().equals(i.getName()) && book.getAuthor().equals(i.getAuthor())) {
                result.add(i);
            }
        }
        return result;
    }

    public Book getBook(String name, String author) {
        for (Book book : books) {

            if (book.getName().equals(name) && book.getAuthor().equals(author)) {
                return book;
            }
        }
        return null;
    }

    public Book getBookReservation(String name, String author, int isbn) {
        for (Book i : books) {
            if (i.getName().equals(name) && i.getAuthor().equals(author) & i.getIsbn() == isbn) {
                return i;
            }
        }
        return null;

    }

}
