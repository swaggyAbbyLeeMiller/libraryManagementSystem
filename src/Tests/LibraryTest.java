package Tests;
import LibraryClasses.Library;
import LibraryClasses.Book;
import LibraryClasses.User;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class LibraryTest {

    private Library library;
    private User user;
    private Book book;

    @Before
    public void setup(){
        library = new Library();
        user = new User("Alexa", 1255);
        book = new Book("Colorblind", "Siera Maley", "9781508403043");

        library.addBook(book);
        library.registerUser(user);
    }


    @Test
    public void testAddBook(){
        Book book1 = new Book("7 Husbands", "Taylor Jenkins", "9798212224604");
        library.addBook(book1);
        assertTrue(library.searchBook("7 Husbands").contains(book1));
    }

    @Test
    public void removeBook(){
        library.removeBook("9781508403043");
        assertTrue(library.searchBook("9781508403043").isEmpty());
    }

    @Test
    public void testSearchBook(){
        assertTrue(library.searchBook("Colorblind").contains(book));
        assertTrue(library.searchBook("Siera Maley").contains(book));
        assertTrue(library.searchBook("9781508403043").contains(book));
    }

    @Test
    public void testRegisteredUser(){
        User newUser = new User("Pibbles", 2844);
        library.registerUser(newUser);
        assertEquals(newUser, library.findUser(2844));
    }

    @Test
    public void findTestUser(){
        assertEquals(user, library.findUser(1255));
    }


    @Test
    public void testBorrowBook(){
        library.borrowBook(1255,"9781508403043" );
        assertTrue(user.getBorrowedBooks().contains(book));
        assertTrue(book.isBorrowed());
    }

    @Test
    public void testReturnedBook(){
        library.borrowBook(1255, "9781508403043");
        library.returnBook(1255,"9781508403043" );
        assertFalse(user.getBorrowedBooks().contains(book));
        assertFalse(book.isBorrowed());
    }


}
