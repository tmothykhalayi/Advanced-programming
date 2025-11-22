import java.io.*;
import java.util.*;

// ===== Book Class =====
class Book implements Serializable {
    private String title;
    private String author;
    private String isbn;
    private boolean isBorrowed;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isBorrowed = false;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isBorrowed() { return isBorrowed; }

    public void borrow() { isBorrowed = true; }
    public void returned() { isBorrowed = false; }

    public void print() {
        System.out.printf("Title: %s | Author: %s | ISBN: %s | Status: %s%n", 
                          title, author, isbn, (isBorrowed ? "Borrowed" : "Available"));
    }
}

// ===== Library Manager =====
class LibraryManager {
    private ArrayList<Book> books = new ArrayList<>();
    private final String fileName = "library.dat";

    public LibraryManager() {
        loadFromFile();
    }

    // Add a book
    public void addBook(Book b) { books.add(b); }

    // Remove a book by ISBN
    public void removeBook(String isbn) {
        books.removeIf(b -> b.getIsbn().equals(isbn));
    }

    // Borrow a book
    public void borrowBook(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                if (!b.isBorrowed()) {
                    b.borrow();
                    System.out.println("Book borrowed successfully!");
                } else {
                    System.out.println("Book is already borrowed!");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }

    // Return a book
    public void returnBook(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                if (b.isBorrowed()) {
                    b.returned();
                    System.out.println("Book returned successfully!");
                } else {
                    System.out.println("Book was not borrowed!");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }

    // Search by title
    public void searchByTitle(String title) {
        boolean found = false;
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(title.toLowerCase())) {
                b.print();
                found = true;
            }
        }
        if (!found) System.out.println("No books found with title: " + title);
    }

    // Search by author
    public void searchByAuthor(String author) {
        boolean found = false;
        for (Book b : books) {
            if (b.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                b.print();
                found = true;
            }
        }
        if (!found) System.out.println("No books found by author: " + author);
    }

    // View catalog
    public void viewCatalog() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        for (Book b : books) b.print();
    }

    // Save to file
    public void saveToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(books);
            System.out.println("Library saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving library: " + e.getMessage());
        }
    }

    // Load from file
    public void loadFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            books = (ArrayList<Book>) in.readObject();
        } catch (Exception e) {
            System.out.println("No existing library found. Starting new library.");
        }
    }
}

// ===== Main Program =====
public class Library {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryManager library = new LibraryManager();

        while (true) {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search by Title");
            System.out.println("6. Search by Author");
            System.out.println("7. View Catalog");
            System.out.println("8. Save & Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Title: "); String title = sc.nextLine();
                    System.out.print("Author: "); String author = sc.nextLine();
                    System.out.print("ISBN: "); String isbn = sc.nextLine();
                    library.addBook(new Book(title, author, isbn));
                }
                case 2 -> {
                    System.out.print("Enter ISBN to remove: "); String isbn = sc.nextLine();
                    library.removeBook(isbn);
                }
                case 3 -> {
                    System.out.print("Enter ISBN to borrow: "); String isbn = sc.nextLine();
                    library.borrowBook(isbn);
                }
                case 4 -> {
                    System.out.print("Enter ISBN to return: "); String isbn = sc.nextLine();
                    library.returnBook(isbn);
                }
                case 5 -> {
                    System.out.print("Enter title to search: "); String title = sc.nextLine();
                    library.searchByTitle(title);
                }
                case 6 -> {
                    System.out.print("Enter author to search: "); String author = sc.nextLine();
                    library.searchByAuthor(author);
                }
                case 7 -> library.viewCatalog();
                case 8 -> {
                    library.saveToFile();
                    System.out.println("Exiting Library System...");
                    return;
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
           sc.close(); 
            
        }
    }
}
