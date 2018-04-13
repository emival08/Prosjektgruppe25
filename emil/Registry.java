import java.util.ArrayList;
import java.util.Iterator;
/**
 * 
 * Controll-class that maintains the bookregistry.
 * 
 *
 * @author (Pernille, Emil og Ørjan)
 * @version (Version nummer 0.1)
 */

public class Registry
{
    private final ArrayList<Literature> literatureLibrary;
    
    /**
     * Constructor for objects of the class "Registry".
     */
    public Registry()
    {
        this.literatureLibrary = new ArrayList<Literature>();
    }
    /**
     * Adds a new magazine to the registry
     */
    public void addLitterature(Literature literature)
    {
       this.literatureLibrary.add(literature);
    }
    /**
     * Lists all books in the registry by the order of the parameters.
     */
    public void listAllLiterature()
    {
        
        for(Literature literature:this.literatureLibrary)
        {
           literature.display();
           System.out.println();
        }
        
    }
    public void findMagazineByTitle(String title)
    {
        Magazine foundMagazine = null;
        
        Iterator<Magazine> it = this.magazineLibrary.iterator();
        while ((null == foundMagazine) && (it.hasNext()))
        {
            Magazine m = it.next();
            if(m.getTitle().equals(title))
            {
                foundMagazine = m;
            }
         
        }
    }
    
    /**
     * Find and returns the book matching the parameter of the method.
     * If there are no titles matching the parameter, then it returns "null".
     */
    public Book findBookByTitle(String title)
    {
        Book foundBook = null;
        
        Iterator<Book> it = this.bookLibrary.iterator();
        while ((null == foundBook) && (it.hasNext()))
        {
            Book b = it.next();
            if (b.getTitle().equals(title))
            {
                foundBook = b;
            }
        }
        return foundBook;
    }
    
    /**
     * Removes the book with a title matching the title given by the parameter from the book library.
     * The title being removed will be returned by the method.
     * 
     * @param //write the title of the book to remove.
     */
    public Book removeBookByTitle(String title)
    {
        Book bookDeleted = null;
        
        Iterator<Book> it = this.bookLibrary.iterator();
        while ((null == bookDeleted) && (it.hasNext()))
        {
            Book b = it.next();
            if (b.getTitle().equals(title))
            {
                bookDeleted = b;
                it.remove();
            }
        }
        return bookDeleted;
    }
    public boolean isEmpty()
    {
        return this.bookLibrary.isEmpty();
    }
}