package LibraryClasses;

public class Book {

    private String title;
    private String author;
    private String isbn;
    private boolean isBorrowed;


    //constructor
    public Book (String title, String author, String isbn){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isBorrowed = false;  //means book is available initially
    }






    //marks book as borrowed
    public void borrowBook(){
        this.isBorrowed = true; //is borrowed currently
    }



    //marks book as available
    public void returnBook(){
        this.isBorrowed = false; //is unavailable currently
    }




    //getters & setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }


}
