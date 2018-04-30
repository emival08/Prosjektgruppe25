package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Classifies a book.
 *
 * @author (Pernille, Emil og Ørjan)
 * @version (Version nummer 0.1)
 *
 **/
 
public class Book extends Literature {
   
    private String genre;
    private String releaseYear;
    /**
     * Constructor for objects of class Book.
     */
    public Book(String title, String author, String publisher, String genre, String releaseYear,String edition)
    {
        super(title,author,publisher,edition);
        this.releaseYear = releaseYear;
        this.genre = genre;
      
    }
    
    /**
     * Returns a formatted string containing all the details about the book.
     */
    public String getBookInformation()
    {
      return "\nTitle: " + getTitle() +
      "\nAuthor: " + getAuthor() +
      "\nPublisher: " + getPublisher() +
      "\nGenre: " + this.genre + 
      "\nRelease Year: " + getReleaseYear();
    }

    public String getLiteratureInformation()
    {
        return"\nTitle: " + getTitle() +
        "\nAuthor: " + getAuthor() +
        "\nPublisher: " + getPublisher() +
        "\nGenre: " + getGenre() +
        "\nRelease Year: " + getReleaseYear() +
        "\nEdition:" + getEdition();
    }
    
    private String getReleaseYear()
    {
        return this.releaseYear;
    }

    private String getGenre()
    {
        return this.genre;
    }


}
