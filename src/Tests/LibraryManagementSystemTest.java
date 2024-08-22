package Tests;
import LibraryClasses.Book;
import LibraryClasses.User;
import LibraryClasses.Library;
import LibraryClasses.LibraryManagementSystem;
import org.junit.Before;

import java.util.List;

public class LibraryManagementSystemTest {

    private LibraryManagementSystem system;
    private Library library;


    @Before
    public void setUp(){
        system = new LibraryManagementSystem(library);
        library = new Library();

    }



}
