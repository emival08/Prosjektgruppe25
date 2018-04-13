import java.util.Scanner;
import java.util.ArrayList;
/**
 * 
 * Interact with the user and makes the user write inputs.
 * 
 *
 * @author (Pernille, Emil og Ørjan)
 * @version (Version nummer 0.1)
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
     * Prints welcome meny
     */
    public void printWelcome()
    {
        System.out.println();
        System.out.println("Velkommen til bibloteket!");
        System.out.println("Here you can do several tasks");
        System.out.println("1. Add new book");
        System.out.println("2. Add new magazine");
        System.out.println("3. Remove book");
        System.out.println("4. List all books");
        System.out.println("5. Find book by title");
        System.out.println("6. Find magazine by title");
        System.out.println("7. Quit");
        
    }
    
    /**
     * Initiates the program
     */
    public void startupSequence()
    {
        while(!finished)
        {
            printWelcome();
            processCommand();
        }
    }
    
    /**
     * Takes input from the user and do that task refefered to the number the user picks. 
     * If the users inputs any other thing than numbers from 1 to 5 the switchcase runs the
     * default. 
     * 
     * 
     */
    private void processCommand()
    {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        switch (value)
        {
            case "1":
            {
                String loop = "n";
                while(!loop.equals("y"))
                {
                    System.out.println("\nAdding book!");
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
                    System.out.println("Please enter the edition");
                    String edition = scanner.nextLine();
                    
                    registry.addNewBook(new Book(title, author, publisher, genre, releaseYear, edition));
                    System.out.println("\nIs this correct?" + "y/n?" + "\nTitle: " + title + "\nAuthor: " + author + "\nPublisher: " + publisher + "\nGenre: " + genre + "\nRelease Year: " + releaseYear);
                    
                    loop = scanner.nextLine();
                    
                    if (!loop.equals("y") && !loop.equals("Y"))
                    {
                        System.out.println("\nLets try again then..!");
                    }
                }
            
                System.out.println("Added a book successfully");
                break;
            }
            case "2":
            {
                
            }
          
            case "3":
            {
                System.out.println("Removing book!");
                System.out.println("Please enter the book title: ");
                String title = scanner.nextLine();
                registry.removeBookByTitle(title);
                System.out.println("Removed book: " + title);
                break;
            }
            case "4":
            {
            if (registry.isEmpty())
            {
               System.out.println("Sorry, there is no books in the library..");
            }
            else
            {
             System.out.println("Listing all books!");
             registry.listAllBooks();
            }
            break;
            }
            
            case "5":
            {
                System.out.println("Search book by title: ");
                String title = scanner.nextLine();
                Book foundBook = registry.findBookByTitle(title);

                if(foundBook == null)
                {
                    System.out.println("There is no book by that name.");
                }
                else
                {
                    System.out.println("Found book: " + title);
                }
                break;
            }
            case "6": 
            {
                System.out.println("Search magazine by title: ");
                String title = scanner.nextLine();
                
            
            }
            case "7":
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
