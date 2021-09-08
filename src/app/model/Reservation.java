package app.model;

import app.model.Book;
import app.model.User;

public class Reservation {

    private Book book;
    private User user;

    public Reservation(Book book, User user) {
        this.book = book;
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String toString() {
        return "Reservation of: " + this.book + " for user: " + this.user;
    }

    public boolean equals(Book book, User user) {
        return (this.book.equals(book) && this.user.equals(user));
    }
}
