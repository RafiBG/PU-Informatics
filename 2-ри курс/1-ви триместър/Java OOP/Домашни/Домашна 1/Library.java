import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Library {
    private String name;
    private String address;
    private int numberOfEmployees;
    private List<Book> availableBooks;

    static Scanner scanner = new Scanner(System.in);

    // Constructor
    public Library() {
        this.name = name;
        this.address = address;
        this.numberOfEmployees = numberOfEmployees;
        this.availableBooks = availableBooks;
    }

    public void add(Book book) {
        availableBooks.add(book);
    }

    public void remove(Book book) {
        availableBooks.remove(book);
    }

    public Book searchByIsbn(String isbn) {
        return null;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public List<Book> getAvailableBooks() {
        return availableBooks;
    }

    public void setAvailableBooks(List<Book> availableBooks) {
        this.availableBooks = availableBooks;
    }

    public void collectAndStartLibrary() {
        System.out.println("Здравейте, моля въведете информация за библиотека!");
        this.collectLibraryName();
        this.collectLibraryAddress();
        this.collectLibraryNumberOfEmployees();
    }

    public void removeBook() {
        System.out.println("1. Премахване по наименование.");
        System.out.println("2. Премахване по ISBN код на книга.");

        int numberOfChoice = scanner.nextInt();
        scanner.nextLine();

        switch (numberOfChoice) {
            case 1:
                System.out.print("Напиши наименованието на книгата за премахване: ");
                String titleRemove = scanner.nextLine();
                removeBookTitle(titleRemove);
                break;
            case 2:
                System.out.print("Напиши ISBN кода на книгата за премахване: ");
                String isbnRemove = scanner.nextLine();
                removeBookISBN(isbnRemove);
                break;
            default:
                System.out.println("Няма такава опция. Връщане към менюто.");
                returnToMenu();
        }
    }

    private void collectLibraryName() {
        System.out.print("Въведете наименование:");
        this.name = scanner.next();
        while (name.length() > 100) {
            System.out.println("Наименованието не трябва да е повече от 100 символа. Опитай отново.");
            this.name = scanner.next();
        }
    }

    private void collectLibraryAddress() {
        System.out.print("Въведете адрес:");
        this.address = scanner.next();
        while (address.length() > 500) {
            System.out.println("Адреса не трябва да е повече от 500 символа. Опитай отново.");
            this.address = scanner.next();
        }
    }

    private void collectLibraryNumberOfEmployees() {
        System.out.print("Въведете брой служители:");
        this.numberOfEmployees = scanner.nextInt();
        while (numberOfEmployees <= 0 || numberOfEmployees >= 50) {
            System.out.println("Броя на служителите трябва да е по-голям от 0 и по-малък от 50. Опитай отново.");
            this.numberOfEmployees = scanner.nextInt();
        }
    }

    public void printAvailableBooksInTable() {
        System.out.println("Available Books:");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("        Title                 Author                  ISBN         ");
        System.out.println("-------------------------------------------------------------------");

        for (Book book : availableBooks) {
            if (book.isAvailable()) {
                System.out.printf("  %-20s   %-20s   %-20s  \n", book.getTitle(), book.getAuthor(), book.getISBN());
                System.out.println("-------------------------------------------------------------------");
            }
        }
    }

    public void removeBookTitle(String title) {
        List<Book> remove = new ArrayList<>();
        for (Book book : availableBooks) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                remove.add(book);
            }
        }
        if (!remove.isEmpty()) {
            availableBooks.removeAll(remove);
            System.out.println("Книга с наименование " + title + " е премахната.");
            returnToMenu();
        } else {
            System.out.println("Няма намерена книга с наименование " + title);
            returnToMenu();
        }
    }

    public void removeBookISBN(String isbn) {
        Book bookToRemove = null;
        for (Book book : availableBooks) {
            if (book.getISBN().equals(isbn)) {
                bookToRemove = book;
                break;
            }
        }

        if (bookToRemove != null) {
            availableBooks.remove(bookToRemove);
            System.out.println("Книга с ISBN " + isbn + " е премахната.");
            returnToMenu();
        } else {
            System.out.println("Няма намерена книга ISBN " + isbn + " с такъв код.");
            returnToMenu();
        }
    }

    private void returnToMenu() {
        HomeWork1 homeWork1 = new HomeWork1();
        homeWork1.menuChoice();
    }
}
