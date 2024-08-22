package LibraryClasses;

import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {

    private Library library;

    public LibraryManagementSystem(Library library){
        this.library = library;
    }

    public static void main(String[] args){
        Library library = new Library();
        LibraryManagementSystem system = new LibraryManagementSystem(library);
        system.run();
    }



        private void registerUser(String name,int userID){
            User user = new User(name, userID);
            library.registerUser(user);
            System.out.println("User Registered");
        }
        private void searchBook (String query){
            List<Book> result = library.searchBook(query);
            if (result.isEmpty()) {
                System.out.println("No Results");
            } else {
                for (Book book : result) {
                    System.out.println("Results: " + "Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", ISBN: " + book.getIsbn());
                }
            }
        }
        private void returnBook ( int userID, String isbn){
            library.returnBook(userID, isbn);
            System.out.println("Book returned");
        }
        private void borrowBook ( int userID, String isbn){
            library.borrowBook(userID, isbn);
            System.out.println("Book borrowed");
        }
        private void addBook (String title, String author, String isbn){
            Book book = new Book(title, author, isbn);
            library.addBook(book);
            System.out.println("Book added");
        }
        private void removeBook (String isbn){
            library.removeBook(isbn);
            System.out.println("Book removed");
        }


        private void displayAllUsers() {
            List<User> users = library.getUserList();
            if (users.isEmpty()) {
                System.out.println("No users");
            } else {
                for (User u : users) {
                    System.out.println("Users Name: " + u.getName() + "UserID: " + u.getUserID() + "Users Borrowed Books: " + u.getBorrowedBooks());
                }
            }
        }
        private void displayAllBooks() {
            List<Book> books = library.getBookList();
            if (books.isEmpty()) {
                System.out.println("No Available Books");
            } else {
                for (Book b : books) {
                    System.out.println("Title: " + b.getTitle() + ", Author: " + b.getAuthor() + ", ISBN: " + b.getIsbn());
                }
            }
        }





        private void addBookHandle(Scanner scanner){
            System.out.println("Enter Title Of Book: ");
            String title = scanner.nextLine();
            System.out.println("Enter Author Of Book: ");
            String author = scanner.nextLine();
            System.out.println("Enter ISBN Of BOok: ");
            String isbn = scanner.nextLine();
            addBook(title, author, isbn);
        }

        private void searchBookHandle(Scanner scanner){
            System.out.println("Enter Search Query: ");
            String query = scanner.nextLine();
            searchBook(query);
        }
        private void returnBookHandle(Scanner scanner){
            System.out.println("Enter UserID: ");
            int userID = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter Book ISBN: ");
            String isbn = scanner.nextLine();
            returnBook(userID, isbn);
        }
        private void borrowBookHandle(Scanner scanner){
            System.out.println("Enter UserID: ");
            int userID = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter Book ISBN: ");
            String isbn = scanner.nextLine();
            borrowBook(userID, isbn);
        }
        private void registerUserHandle(Scanner scanner){
            System.out.println("Enter User Name: ");
            String userName = scanner.nextLine();
            System.out.println("Enter User ID: ");
            int userID = Integer.parseInt(scanner.nextLine());
            registerUser(userName, userID);
        }
        private void removeBookHandle(Scanner scanner){
            System.out.println("Enter ISBN of book: ");
            String isbn = scanner.nextLine();
            removeBook(isbn);
        }



    public void run() {
        boolean running = true;
        Scanner scanner = new Scanner(System.in);


        while (running) {
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Register User");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Search Book");
            System.out.println("7. Display All Books");
            System.out.println("8. Display All Users");
            System.out.println("9. Exit");

            String whatUserPicked = scanner.nextLine();

            switch (whatUserPicked) {
                case "1":
                    addBookHandle(scanner);
                    break;

                case "2":
                    removeBookHandle(scanner);

                case "3":
                    registerUserHandle(scanner);
                    break;

                case "4":
                    borrowBookHandle(scanner);
                    break;


                case "5":
                    returnBookHandle(scanner);
                    break;

                case "6":
                    searchBookHandle(scanner);
                    break;

                case "7":
                    displayAllBooks();
                    break;

                case "8":
                    displayAllUsers();


                case "9":
                    running = false;
                    System.out.println("Exiting");
                    break;

                default:
                    System.out.println("Invalid, try again HAHA");
                    break;
            }
        }

        scanner.close();
    }












}
