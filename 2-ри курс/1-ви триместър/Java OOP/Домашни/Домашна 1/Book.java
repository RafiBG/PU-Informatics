import java.util.Date;
import java.util.Scanner;
public class Book {
    private String title;
    private String genre;
    private String author;
    private String publishHouse;
    private int yearOfIssues;
    private String ISBN;
    private int numberOfPages;
    private String language;
    private boolean isAvailable;
    private Date dateTaken;
    private Date dateToReturn;
    private int collectionPeriod;
    private int timesTaken;
    Scanner scanner = new Scanner(System.in);

    //Constructor
    public Book() {

        this.title = title;
        this.genre = genre;
        this.author = author;
        this.publishHouse = publishHouse;
        this.yearOfIssues = yearOfIssues;
        this.ISBN = ISBN;
        this.numberOfPages = numberOfPages;
        this.language = language;
        this.collectionPeriod = collectionPeriod;
        this.isAvailable = true;
        this.dateTaken = null;
        this.dateToReturn = null;
        this.timesTaken = 0;
    }


    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublishHouse() {
        return publishHouse;
    }

    public void setPublishHouse(String publishHouse) {
        this.publishHouse = publishHouse;
    }

    public int getYearOfIssues() {
        return yearOfIssues;
    }

    public void setYearOfIssues(int yearOfIssues) {
        this.yearOfIssues = yearOfIssues;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Date getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(Date dateTaken) {
        this.dateTaken = dateTaken;
    }

    public Date getDateToReturn() {
        return dateToReturn;
    }

    public void setDateToReturn(Date dateToReturn) {
        this.dateToReturn = dateToReturn;
    }

    public int getCollectionPeriod() {
        return collectionPeriod;
    }

    public void setCollectionPeriod(int collectionPeriod) {
        this.collectionPeriod = collectionPeriod;
    }

    public int getTimesTaken() {
        return timesTaken;
    }

    public void setTimesTaken(int timesTaken) {
        this.timesTaken = timesTaken;
    }

    public void collectAndStartBook() {
        System.out.println("Здравейте, моля въведете информация за книга!");
        this.collectBookTitle();
        this.collectBookAuthor();
        this.collectBookPublishHouse();
        this.collectBookYearOfIssues();
        this.collectBookISBN();
        this.collectBookNumberOfPages();
        this.collectBookLanguage();
        this.collectBookIsAvailable();
        this.timesTakenBook();
    }

    private void collectBookTitle() {
        System.out.print("Въведете заглавие:");
        this.title = scanner.next();
        while (title.length() > 100 || title.isEmpty()) {
            System.out.println("Наименованието не трябва да е повече от 100 символа. Опитай отново.");
            this.title = scanner.next();
        }
    }
    private void collectBookAuthor() {
        System.out.print("Въведете автор/и:");
        this.author = scanner.next();
        while (author.length() > 50) {
            System.out.println("Името на автора не трябва да е повече от 50 символа. Опитай отново.");
            this.author = scanner.next();
        }
    }

    private void collectBookPublishHouse() {
        System.out.print("Въведете издателство:");
        this.publishHouse = scanner.next();
        while (publishHouse.length() > 50 || publishHouse.isEmpty()) {
            System.out.println("Името на издателството не трябва да е повече от 50 символа. Опитай отново.");
            this.publishHouse = scanner.next();
        }
    }

    private void collectBookYearOfIssues() {
        System.out.print("Въведете година на издаване:");
        this.yearOfIssues = scanner.nextInt();
        while (yearOfIssues < 0 || yearOfIssues > 2023) {
            System.out.println("Годината на издаване не може да е след 2023 година. Опитай отново.");
            this.yearOfIssues = scanner.nextInt();
        }
    }

    private void collectBookISBN() {
        System.out.print("Въведете код на книгата:");
        this.ISBN = scanner.next();
        while (ISBN.length() > 10 || ISBN.isEmpty()) {
            System.out.println("Кода на книгата не трябва да е повече от 10 символа. Опитай отново.");
            this.ISBN = scanner.next();
        }
    }

    private void collectBookNumberOfPages() {
        System.out.print("Въведете брои на страници:");
        this.numberOfPages = scanner.nextInt();
        while (numberOfPages <= 0) {
            System.out.println("Броя на страниците не трябва да е отрицателно число и повече от нула. Опитай отново.");
            this.numberOfPages = scanner.nextInt();
        }
    }

    public void collectBookLanguage() {
        System.out.print("На какъв език е написана книгата:");
        this.language = scanner.next();
    }
    private void collectBookIsAvailable() {
        System.out.print("Налична ли е книгата (Да или Не): ");
        String yesOrNo = null;
        yesOrNo = scanner.next();
        if(yesOrNo == "Да") {
            isAvailable = true;
        }
        else {
            isAvailable = false;
        }
    }
    private void timesTakenBook() {
        System.out.print("Колко пъти е взимана книгата:");
        this.timesTaken =  scanner.nextInt();
        System.out.println("Книгата е добавена.");
        HomeWork1 homeWork1 = new HomeWork1();
        homeWork1.menuChoice();
        while(timesTaken < 0) {
            System.out.println("Числото не може да е отрицателно.");
            this.timesTaken = scanner.nextInt();
        }
    }
}
