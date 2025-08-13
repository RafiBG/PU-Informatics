
import java.util.*;

/**
 * 
 */
public class ReaderCard {

    /**
     * Default constructor
     */
    public ReaderCard() {
    }

    /**
     * 
     */
    private Reader reader;

    /**
     * 
     */
    public int shortTime = 10;

    /**
     * 
     */
    public int longTime = 30;

    /**
     * 
     */
    public DateTime rentDate;

    /**
     * 
     */
    public DateTime returnDate;

    /**
     * @param reader
     */
    public void ReaderCard(Reader reader) {
        // TODO implement here
    }

    /**
     * @param reader 
     * @param book 
     * @param shortTime 
     * @param rentDate 
     * @param listRentBook 
     * @return
     */
    public boolean rentBookShortTime(Reader reader, Book book, int shortTime, DateTime rentDate, <> listRentBook) {
        // TODO implement here
        return false;
    }

    /**
     * @param reader 
     * @param book 
     * @param longTime 
     * @param rentDate 
     * @param listRentBook 
     * @return
     */
    public boolean rentBookLongTime(Reader reader, Book book, int longTime, DateTime rentDate, <> listRentBook) {
        // TODO implement here
        return false;
    }

    /**
     * @param reader 
     * @param book 
     * @param listRentBook 
     * @param returnDate 
     * @return
     */
    public boolean returnBook(Reader reader, Book book, <> listRentBook, DateTime returnDate) {
        // TODO implement here
        return false;
    }

}