import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {
    private ArrayList<Book> books = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int nextId = 1;

    public void run() {
        System.out.println("Welcome to Library App!");
        while (true) {
            System.out.println("1. Print all books");
            System.out.println("2. Add new book");
            System.out.println("3. Search books by title");
            System.out.println("4. Borrow a book");
            System.out.println("5. Return a book");
            System.out.println("6. Delete a book by id");
            System.out.println("7. Quit");
            System.out.print("Choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 7) {
                System.out.println("Quitting");
                break;
            }
            switch (choice) {
                case 1 -> printAll();
                case 2 -> addBook();
                case 3 -> searchBooks();
                case 4 -> borrowBook();
                case 5 -> returnBook();
                case 6 -> deleteBook();
            }
        }
    }

    private void printAll() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        }
        else {
            for (Book b : books) {
                System.out.println(b.toString());
            }
        }
    }

    private void addBook() {
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Year: ");
        int year = Integer.parseInt(scanner.nextLine());
        books.add(new Book(title, author, year));
        System.out.println("Added");
    }

    private void searchBooks() {
        System.out.print("Insert part of title: ");
        String part = scanner.nextLine();
        for (Book b : books) {
            if (b.getTitle().contains(part)) {
                System.out.println(b);
            }
            else{
                System.out.println("No book");
            }
        }
    }

    private void borrowBook() {
        System.out.print("Enter ID: ");
        int idToFind = Integer.parseInt(scanner.nextLine());
        for (Book b : books) {
            if (b.getId() == idToFind) {
                if (b.available) {
                    b.markAsBorrowed();
                    System.out.println("Borrowed successfully");
                } else {
                    System.out.println("Already borrowed");
                }
                return;
            }
        }
        System.out.println("not found");
    }

    private void returnBook() {
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Book b : books) {
            if (b.getId() == id && !b.available) {
                b.available = true;
                System.out.println("Returned");
                return;
            }
            else{
                System.out.println("Already here");
            }
        }
    }

    private void deleteBook() {
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean remove = books.removeIf(b -> b.getId() == id);
        if (remove) {
            System.out.println("Deleted");
        }
        else {
            System.out.println("Not found");
        }
    }
}