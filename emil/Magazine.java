/**
 * Classifies a book.
 *
 * @author (Pernille, Emil og Ørjan)
 * @version (Version nummer 0.1)
 *
 **/
 
 public class Magazine extends Media
 {
    public Magazine(String title,String publisher,String releaseDate, String edition)
    {
        super(title,publisher,releaseDate, edition);
    }
    
     public String getMagazineInformation()
    {
      return "\nTitle: " + getTitle() + 
      "\nAuthor: " + getAuthor() +
      "\nPublisher: " + getPublisher() +
      "\nRelease Year: " + getReleaseDate();
    }
    
 }