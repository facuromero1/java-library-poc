package model;

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

    public User getUser() {return user;}

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "book=" + book +
                ", user=" + user +
                '}';
    }

    public boolean equals(Book book, User user) {
        return (this.book.equals(book) && this.user.equals(user));
    }
}
