package Tests;
import LibraryClasses.User;
import LibraryClasses.Book;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void testUserConstructor(){
        User user = new User("Alexa", 1255);
        assertTrue(user.getName().equals("Alexa"));
        assertEquals(1255, user.getUserID());
        assertTrue(user.getBorrowedBooks().isEmpty());
    }

    @Test
    public void testBorrowBook(){
        User user = new User("Alexa", 1255);
        Book book = new Book("Colorblind", "Siera Maley", "9781508403043");
        user.borrowBook(book);

        assertTrue(user.getBorrowedBooks().contains(book));
        assertTrue(book.isBorrowed());
    }


    @Test
    public void testReturnBook(){
        User user = new User("Alexa", 1255);
        Book book = new Book("Colorblind", "Siera Maley", "9781508403043");
        user.borrowBook(book);
        user.returnBook(book);

        assertFalse(user.getBorrowedBooks().contains(book));
        assertFalse(book.isBorrowed());
    }

    @Test
    public void getBorrowedBooks(){
        User user = new User("Alexa", 1255);
        Book book = new Book("Colorblind", "Siera Maley", "9781508403043");
        Book book2 = new Book("7 Husbands", "Taylor Jenkins Reid", "9798212224604");

        user.borrowBook(book);
        user.borrowBook(book2);

        assertTrue(user.getBorrowedBooks().contains(book));
        assertTrue(user.getBorrowedBooks().contains(book2));
    }


}
