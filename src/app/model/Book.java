package app.model;

public class Book {

    private String name;
    private String author;
    private int year;


    public Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        return this.name;

    }

    public boolean equals(String name, String author, int year) {
        return (this.name.equals(name) && this.author.equals(author) && this.year == year);
    }
}

