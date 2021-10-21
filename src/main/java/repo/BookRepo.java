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

    public ArrayList<Book> findBooks(String nameBook,String author) {
        ArrayList<Book> result = new ArrayList<>();

        for (Book i : books) {
            if (i.getName().equals(nameBook) && i.getAuthor().equals(author)) {
                result.add(i);
            }
        }
        return result;
    }

    public Book getBook(int isbn) {
        for (Book book : books) {

            if (book.getIsbn() == (isbn)) {
                return book;
            }
        }
        return null;
    }



}
