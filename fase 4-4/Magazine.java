import java.util.List;
 
/**
 * Classifies a book.
 *
 * @author (Pernille, Emil og Ørjan)
 * @version (Version nummer 0.1)
 *
 **/
 
 
 public class Magazine extends Literature
 {
    private String releaseDate;
     
    public Magazine(String title, String author, String publisher,String releaseDate, String edition)
    {
        super(title,author,publisher,edition);
        this.releaseDate = releaseDate;
    }
    
       public String getReleaseDate() 
   {
    return releaseDate;
   }
    
     public String getMagazineInformation()
    {
      return "\nTitle: " + getTitle() + 
      "\nAuthor: " + getAuthor() +
      "\nPublisher: " + getPublisher() +
      "\nRelease Year: " + getReleaseDate() +
      "\nEdition:" + getEdition();
    }
    
 }