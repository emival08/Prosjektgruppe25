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
    private ArrayList<Book> bookLibrary;
    private ArrayList<Magazine> magazineLibrary;
    
    /**
     * Constructor for objects of the class "Registry".
     */
    public Registry()
    {
        this.bookLibrary = new ArrayList<Book>();
        this.magazineLibrary = new ArrayList<Magazine>();
    }
    /**
     * Adds a new magazine to the registry
     */
    public void addNewMagazine(Magazine magazine)
    {
        this.magazineLibrary.add(magazine);
    }
    /**
     * List all the magazines in the library
     */
    public void listAllMagazine()
    {
    for(Magazine m:this.magazineLibrary)
    {
     System.out.println(m.getMagazineInformation()); 
    }
    }
    /**
     * Adds a new book to the registry.
     */
    public void addNewBook(Book book)
    {
        this.bookLibrary.add(book);
    }
    /**
     * Lists all books in the registry by the order of the parameters.
     */
    public void listAllBooks()
    {
        
        for(Book b:this.bookLibrary)
        {
            System.out.println(b.getBookInformation());
        
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