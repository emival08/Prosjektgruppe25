import java.util.ArrayList;

public class Registry
{
    private ArrayList<Book> bookLibrary;
    
    public Registry()
    {
        this.bookLibrary = new ArrayList<Book>();
    }
    
    public void addNewBook(Book book)
    {
        this.bookLibrary.add(book);
    }
    
    public void listAllBooks()
    {
        for(Book b:this.bookLibrary)
        {
            System.out.println(b.getBookInformation());
        }
    }
}