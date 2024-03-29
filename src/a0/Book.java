package a0;

public class Book {

    /**
     * Part I
     */

    String title;

    String author;

    long ISBN;

    double price;

    static int bookCounter = 0;

    Book(String title, String author, long ISBN, double price){
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.price = price;
        bookCounter++;

    }

    public Book() {
        // Default placeholder book
        this.title = "Elias Grace";
        this.author = "Margaret Atwood";
        this.ISBN = 4565;
        this.price = 23;
        bookCounter++;

    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public long getISBN() {
        return ISBN;
    }

    public double getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public static int findNumberOfCreatedBooks(){
        return bookCounter;
    }

    public boolean equals(Book book){
        if(book.price == price){
            return book.ISBN == ISBN;
        }
        return false;
    }

    public String toString(){
        return "\nAuthor: " + author + "\nTitle: "+ title + "\nISBN: " + ISBN +"\nPrice: $" + price;
    }



}
