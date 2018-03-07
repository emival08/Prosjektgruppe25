
/**
 * Write a description of class BookInventory here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Book
{
    private String title;
    private String author;
    private String publisher;
    private String genre;
    private String releaseYear;
    /**
     * Constructor for objects of class BookInventory
     */
    public Book(String title, String author, String publisher, String genre, String releaseYear)
    {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }
    
    /**
     * Returns a formatted string containing all the details about the book.
     */
    public String getBookInformation()
    {
        return "\nTitle: " + this.title + "\nAuthor: " + this.author + "\nPublisher: " + this.publisher + "\nGenre: " + this.genre + "\nRelease Year: " + this.releaseYear;
    }
    
    /**
     * @Return returns the title of the book.
     */
    public String getTitle()
    {
        return this.title;
    }
}
