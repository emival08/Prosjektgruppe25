
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
    private int releaseYear;
    /**
     * Constructor for objects of class BookInventory
     */
    public Book()
    {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }
    
    public String getBookInformation()
    {
        return this.title + ", " + this.author + ", " + this.publisher + ", " + this.genre + ", " + this.releaseYear;
    }
}
