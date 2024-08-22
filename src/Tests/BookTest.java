package Tests;
import LibraryClasses.Book;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class BookTest {


    @Test
    public void testBookConstructor(){
        //LibraryClasses.Book (String title, String author, String isbn)
        Book book = new Book("Colorblind", "Siera Maley", "9781508403043");
        assertTrue(book.getTitle().equals("Colorblind"));
        assertTrue(book.getAuthor().equals("Siera Maley"));
        assertTrue(book.getIsbn().equals("9781508403043"));
    }


    @Test
    public void borrowBookTest(){
        Book book = new Book("Colorblind", "Siera Maley", "9781508403043");
        book.borrowBook();
        assertTrue(book.isBorrowed());
    }



    @Test
    public void returnBookTest(){
        Book book = new Book("Colorblind", "Siera Maley", "9781508403043");
        book.returnBook();
        assertFalse(book.isBorrowed());
    }


    @Test
    public void gettersAndSetters(){
        Book book = new Book("Colorblind", "Siera Maley", "9798212224604");
        book.setTitle("7 Husbands Of Evelyn");
        book.setAuthor("Taylor Jenkins Reid");
        book.setIsbn("9798212224604");
        book.setBorrowed(true);


        assertTrue(book.getTitle().equals("7 Husbands Of Evelyn"));
        assertTrue(book.getAuthor().equals("Taylor Jenkins Reid"));
        assertTrue(book.getIsbn().equals("9798212224604"));
        assertTrue(book.isBorrowed());
    }
}
