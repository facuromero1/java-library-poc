package model;

public class Book {
    private String name;
    private String author;
    private int year;
    private int isbn;


    public Book(String name, String author, int year,int isbn) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.isbn = isbn;

    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear (int year) {this.year = year;}

    public void setIsbn (int isbn) {this.isbn = isbn;}

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public int getIsbn() { return  isbn; }



    public String toString() {
        return this.name;
    }

    public boolean equals(String name) {
        return (this.name.equals(name));
    }
}
