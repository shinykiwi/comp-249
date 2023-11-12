package a2;

import java.io.Serializable;

public class Book implements Serializable {

    protected String title;
    protected String author;
    protected double price;
    protected String isbn;
    protected String genre;
    protected int year;

    public Book(){
        title = "default";
        author = "bro";
        price = 0.0;
        isbn = "";
        year = 2000;
    }

    public Book(String title, String author, double price, String isbn, String genre, int year){

        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
        this.genre = genre;
        this.year = year;

    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public void setYear(int year){
        this.year = year;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }


    public String toString(){
        return title + author + price + isbn + genre + year;
    }

    public boolean equals(Book book){
        return book.title.equals(title) && book.author.equals(author) && book.genre.equals(genre) && book.isbn.equals(isbn) && book.price == price && book.year == year;
    }


}
