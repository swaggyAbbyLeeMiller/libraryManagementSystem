package LibraryClasses;
import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private int userID;
    private List<Book> borrowedBooks;

    public User(String name, int userID){
        this.name = name;
        this.userID = userID;
        this.borrowedBooks = new ArrayList<>();
    }


    public void borrowBook(Book book){
        if (!book.isBorrowed()){
            borrowedBooks.add(book);
            book.borrowBook();
        }
    }

    public void returnBook(Book book){
        if (book.isBorrowed()){
            borrowedBooks.remove(book);
            book.returnBook();
        }

    }







    //getters and setters
    public List<Book> getBorrowedBooks(){
        return borrowedBooks;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
