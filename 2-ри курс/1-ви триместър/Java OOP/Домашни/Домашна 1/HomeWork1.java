import java.util.Scanner;

public class HomeWork1 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Library library = new Library();
        library.collectAndStartLibrary();
        menuChoice();
    }

    static void menuChoice() {
        System.out.println("Меню с опции: ");
        System.out.println("1. Добавяне на книга");
        System.out.println("2. Премахване на книга");
        System.out.println("3. Търсене на книга");
        System.out.println("4. Обновяване на книга");
        System.out.println("5. Пълен списък с книги");
        System.out.println("6. Изход");

        int numberOfChoice = scanner.nextInt();

        switch (numberOfChoice) {
            case 1 -> addBook();
            case 2 -> removeBook();
            case 3 -> searchBook();
            case 4 -> updateBook();
            case 5 -> showListOfBooks();
            case 6 -> exit();
            default -> System.err.println("Няма такава опция в менюто!");
        }
    }

    static void addBook() {
        Book book = new Book();
        book.collectAndStartBook();

    }
    static void removeBook() {
        Library library = new Library();
        library.removeBook();
    }
    static void searchBook() {

    }
    static void updateBook() {

    }
    static void showListOfBooks() {
        Library library = new Library();
        library.printAvailableBooksInTable();
    }

    static void exit() {
        System.err.println("Довиждане! До нови срещи!");
        System.exit(0);
    }
}
