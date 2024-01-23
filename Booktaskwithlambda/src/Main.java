import Models.Book;
import Models.Library;
import Helper.Helper;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Pencereden gorunen kolge", "Aqatha Christie", "Eng", 24, 10);
        Book book2 = new Book("Qozbel", "Sherlock Holmes", "Aze", 12, 12);
        Book book3 = new Book("Qozbel", "Elxan Elatli", "Aze", 12, 23);

        Book book4 = new Book("The little prince", "Antoine de Saint-Exupéry", "Eng", 12, 25);
        Book book5 = new Book("The little prince", "Antoine de Saint-Exupéry", "Eng", 12, 30);
        Book book6 = new Book("Introduction to PAE", "Erkin Ibrahimov", "German", 15, 5);
        Library ourlibrary = new Library();
        //Add books to our library
        ourlibrary.addBook(book1);
        ourlibrary.addBook(book2);
        ourlibrary.addBook(book3);
        ourlibrary.addBook(book5);
        ourlibrary.addBook(book4);
        ourlibrary.addBook(book6);
        //show books which in our library;
        ourlibrary.showBooks();

        //Our menu
        while (true) {
            System.out.println("Hello. Welcome to library. Please enter the library name(if u don't want just use blank or make it empty: )");
            Scanner scan = new Scanner(System.in);
            String libName = scan.nextLine();
            ourlibrary.trueName(libName);
            System.out.println("Welcome to our " + ourlibrary.trueName(libName) + " library");
            while (true) {

                System.out.println("\n1. Add book");
                System.out.println("2. Update book");
                System.out.println("3. Delete book");
                System.out.println("4. Find book");
                System.out.println("5. Change library name");
                System.out.println("6. Show books");
                System.out.println("7. EXIT");
                String choice = scan.nextLine();
                int input = Helper.tryParseInt(choice);

                switch (input) {
                    case 1:
                        System.out.print("Enter book name: ");
                        String name = scan.nextLine();
                        System.out.print("Enter author name: ");
                        String author = scan.nextLine();
                        System.out.print("Enter language: ");
                        String language = scan.nextLine();
                        System.out.print("Enter book count: ");
                        String count = scan.nextLine();
                        int count2 = Helper.tryParseInt(count);
                        System.out.print("Enter book price: ");
                        String price = scan.nextLine();
                        int price2 = Helper.tryParseInt(price);

                        Book newBook = new Book(name, author, language, count2, price2);
                        ourlibrary.addBook(newBook);
                        break;

                    case 2:
                        System.out.print("Enter book ID to update: ");
                        int updateId = scan.nextInt();
                        System.out.print("Enter new count: ");
                        int newCount = scan.nextInt();
                        ourlibrary.updateBook(updateId, newCount);
                        break;

                    case 3:
                        System.out.print("Enter book ID to delete: ");
                        int deleteId = scan.nextInt();
                        ourlibrary.deleteBook(deleteId);
                        break;

                    case 4:
                        System.out.print("Enter book ID, name, or author to find: ");
                        String searchTerm = scan.nextLine();
                        Library foundBooks=ourlibrary.findBook(searchTerm);
                        if (foundBooks==null){
                            System.out.println("Book is not found");

                        }
                        else{
                            System.out.println("Book is found");
                            foundBooks.showBooks();
                        }

                        break;

                    case 5:
                        System.out.print("Enter new library name: ");
                        String newName = scan.nextLine();
                        ourlibrary.changeLibraryName(newName);
                        break;

                    case 6:
                        ourlibrary.showBooks();
                        break;

                    case 7:
                        System.out.println("Exiting the program. Goodbye!");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                        break;
                }
            }
        }
    }
}
