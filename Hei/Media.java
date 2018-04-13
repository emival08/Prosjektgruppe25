/**
 * Classifies a book.
 *
 * @author (Pernille, Emil og Ørjan)
 * @version (Version nummer 0.1)
 *
 **/
 
 public class Media 
 {
   private String title;
   private String author;
   private String publisher;
   private String releaseDate;
   private String edition;
     
   public Media(String title,String author, String publisher, String edition)
   {
    this.title = title;
    this.author = author;
    this.publisher = publisher;
    this.edition = edition;
    
   }
   
   public String getTitle()
   {
    return title; 
   }
   
   public String getAuthor()
   {
    return author;
   }
   
   public String getPublisher()
   {
      return publisher;
   }
    
   public String getReleaseDate() 
   {
    return releaseDate;
   }
 }
 