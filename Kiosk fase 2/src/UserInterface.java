import java.util.Scanner;
/**
 * Write a description of class UserInterface here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UserInterface
{
    // instance variables - replace the example below with your own
    Registry registry = new Registry();
    boolean finished = false;
    /**
     * Constructor for objects of class UserInterface
     */
    public UserInterface()
    {
        
    }

    /**
     * An example of a method - replace this comment with your own
     */
    public void printWelcome()
    {
        System.out.println();
        System.out.println("Velkommen til bokkiosken!");
        System.out.println("1. Add new book");
        System.out.println("2. Remove book");
        System.out.println("3. List all books");
        System.out.println("4. Find book by title");
        System.out.println("5. Quit");
    }
    
    public void startupSequence()
    {
        while(!finished)
        {
            printWelcome();
            processCommand();
        }
    }
    
    private void processCommand()
    {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        switch (value)
        {
            case "1":
            {
                String loop = "n";
                while(loop.equals("n"))
                {
                    System.out.println("Adding book!");
                    System.out.println("Please enter the book title: ");
                    String title = scanner.nextLine();
                    System.out.println("Please enter the author: ");
                    String author = scanner.nextLine();
                    System.out.println("Please enter the publisher: ");
                    String publisher = scanner.nextLine();
                    System.out.println("Please enter the genre: ");
                    String genre = scanner.nextLine();
                    System.out.println("Please enter the release year: ");
                    String releaseYear = scanner.nextLine();
                    
                    registry.addNewBook(new Book(title, author, publisher, genre, releaseYear));
                    System.out.println("Is this correct?" + "y/n?" + "\nTitle: " + title + "\nAuthor: " + author + "\nPublisher: " + publisher + "\nGenre: " + genre + "\nRelease Year: " + releaseYear);
                    
                    loop = scanner.nextLine();
                }
                System.out.println("Added a book successfully");
                break;
            }
            case "2":
            {
                System.out.println("Removing book!");
                System.out.println("Please enter the book title: ");
                String title = scanner.nextLine();
                registry.removeBookByTitle(title);
                System.out.println("Removed book: " + title);
                break;
            }
            case "3":
            {
                System.out.println("Listing all books!");
                registry.listAllBooks();
                break;
            }
            case "4":
            {
                System.out.println("Search book by title: ");
                String title = scanner.nextLine();
                registry.findBookByTitle(title);
                break;
            }
            case "5":
            {
                System.out.println("Bye bye!");
                this.finished = true;
            }
            default:
            {
                System.out.println("Unkown command! Try using numbers between 1 and 5!");
                break;
            }
        }
    }
}
