package LibraryClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {

    private List<Book> bookList;
    private List<User> userList;


    public Library(){
        this.bookList = new ArrayList<>();
        this.userList = new ArrayList<>();
    }


    public void addBook(Book book){
        if (book != null){
            boolean doesBookExist = false;
            for (Book b : bookList){
                if(b.getIsbn().equals(book.getIsbn())){
                    doesBookExist = true;
                    break;
                }
            }

            if (!doesBookExist){
                bookList.add(book);
            }
        }
    }

    public void removeBook(String isbn){
        if (isbn != null && !isbn.isEmpty()){
           for (int i = 0; i < bookList.size(); i++){
               Book book = bookList.get(i);
               if (book.getIsbn().equals(isbn)){
                   bookList.remove(i);
                   break;
               }
           }
        }
    }

    public List<Book> searchBook(String query){
        List<Book> resultList = new ArrayList<>();

        if (query != null || !query.isEmpty()){
            for (Book book : bookList){
                if (book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    book.getIsbn().toLowerCase().contains(query.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(query.toLowerCase())){
                    resultList.add(book);
                }
            }
        }

        return resultList;
    }

    public void registerUser(User user){
        if (user != null){
            boolean userIDExists = false;
            for (User u : userList){
                if (u.getUserID() == user.getUserID()){
                    userIDExists = true;
                    break;
                }
            }
            if (!userIDExists){
                userList.add(user);
            }
        }
    }

    public User findUser(int userID){
        for (User user : userList){
            if (user.getUserID() == userID){
                return user;
            }
        }
        return null;
    }

    public void borrowBook(int userID, String isbn){
       User user = findUser(userID);
       if (user != null){
           Book bookUserBorrowing = null;
           for (Book book : bookList){
               if (book.getIsbn().equals(isbn)){
                   bookUserBorrowing = book;
                   break;
               }
           }

           if (bookUserBorrowing != null && !bookUserBorrowing.isBorrowed()){
               user.borrowBook(bookUserBorrowing); //user is now borrowing book
               bookUserBorrowing.borrowBook(); //marking book as borrowed
           }
       }
    }

    public void returnBook(int userID, String isbn){
        User user = findUser(userID);

        if (user != null){
            Book bookToReturn = null;
            for(Book book : user.getBorrowedBooks()){
                if (book.getIsbn().equals(isbn)){
                    bookToReturn = book;
                    break;
                }
            }
            if (bookToReturn != null){
                user.returnBook(bookToReturn);
                bookToReturn.returnBook();
            }
        }
    }


    public List<User> getUserList(){
        return new ArrayList<>(userList);
    }
    public List<Book> getBookList(){
        return new ArrayList<>(bookList);
    }




}
