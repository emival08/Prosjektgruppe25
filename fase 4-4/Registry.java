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
    private ArrayList<Literature> literatureLibrary;
    
    
    /**
     * Constructor for objects of the class "Registry".
     */
    public Registry()
    {
        this.literatureLibrary = new ArrayList<Literature>();
        
    }
    /**
     * Adds a new literature to the registry
     */
    public void addNewLiterature(Literature literature)
    {
        this.literatureLibrary.add(literature);
    }
    public Iterator<Literature> getIterator()
    {
        return this.literatureLibrary.iterator();
    }
    
    /**
     * List all the magazines in the library
     */
    public void listAllLiterature()
    {
        for(Literature l: this.literatureLibrary)
        {
            
          System.out.println(Literature.getLiteratureInformation());
        }
    }
    
   
   
   
    
    /**
     * Lists all books in the registry by the order of the parameters.
     */
   // public void listAllLiterature()
    //{
        
      //  for(Book b:this.literatureLibrary)
      //  {
      //   System.out.println(l.getBookInformation());
      //  }
        
    //}
   // public Magazine findMagazineByTitle(String title)
    //{
    //    Magazine foundMagazine = null;
        
    //    Iterator<Magazine> it = this.magazineLibrary.iterator();
    //    while ((null == foundMagazine) && (it.hasNext()))
    //    {
    //        Magazine m = it.next();
    //        if(m.getTitle().equals(title))
    //        {
    //            foundMagazine = m;
    //        }
         
    //    }
    //    return foundMagazine;
    //}
    
    /**
     * Find and returns the book matching the parameter of the method.
     * If there are no titles matching the parameter, then it returns "null".
     */
    public Literature findLiteratureByTitle(String title)
    {
        Literature foundLiterature = null;
        
        Iterator<Literature> it = this.literatureLibrary.iterator();
        while ((null == foundLiterature) && (it.hasNext()))
        {
            Literature l = it.next();
            if (l.getTitle().equals(title))
            {
                foundLiterature = l;
            }
        }
        return foundLiterature;
    }
    
    /**
     * Removes the book with a title matching the title given by the parameter from the book library.
     * The title being removed will be returned by the method.
     * 
     * @param //write the title of the book to remove.
     */
    public Literature removeLiteratureByTitle(String title)
    {
        Literature literatureDeleted = null;
        
        Iterator<Literature> it = this.literatureLibrary.iterator();
        while ((null == literatureDeleted) && (it.hasNext()))
        {
            Literature l = it.next();
            if (l.getTitle().equals(title))
            {
                literatureDeleted = l;
                it.remove();
            }
        }
        return literatureDeleted;
    }
    public boolean literatureLibraryIsEmpty()
    {
        return this.literatureLibrary.isEmpty();
    }
  }
