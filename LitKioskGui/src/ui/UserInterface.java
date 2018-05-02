package ui;
import literature.Book;
import literature.Literature;
import literature.Magazine;
import literature.Registry;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * Interact with the user and makes the user write inputs.
 *
 *
 * @author (Pernille, Emil og Ørjan)
 * @version (Version nummer 0.1)
 */

public class UserInterface {
    // instance variables - replace the example below with your own
    Registry registry = new Registry();
    boolean finished = false;
    /**
     * Constructor for objects of class UserInterface
     */
    public UserInterface()
    {
        this.registry = new Registry();
    }

    /**
     * Prints welcome meny
     */
    public static void printWelcome()
    {
        System.out.println();
        System.out.println("Velkommen til biblioteket!");
        System.out.println("Here you can do several tasks");
        System.out.println("1. Add a new item");
        System.out.println("2. Remove book");
        System.out.println("3. List all books");
        System.out.println("4. List all magazines");
        System.out.println("5. Search literature by title");
        System.out.println("6. Quit");

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
     * Lists all of the books in the registry
     */
    public void listAllBooks()
    {
        Iterator<Literature> l = this.registry.getIterator();
        while(l.hasNext())
        {
            Literature literature = l.next();
            if(literature instanceof Book)
            {
                System.out.println(literature.getLiteratureInformation());
            }
        }
    }

    /**
     * Lists all of the magazines in the registry
     */
    public void listAllMagazines()
    {
        Iterator<Literature> l = this.registry.getIterator();
        while(l.hasNext())
        {
            Literature literature = l.next();
            if(literature instanceof Magazine)
            {
                System.out.println(literature.getLiteratureInformation());
            }
        }
    }


    /**
     * Takes input from the user and do that task refefered to the number the user picks.
     * If the users inputs any other thing than numbers from 1 to 6, the switchcase runs the
     * default.
     *
     *
     */
    boolean yn;
    String loop;
    Scanner scanner = new Scanner(System.in);
    private void processCommand()
    {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        switch (value)
        {
            /**
             * Adds literature to the registry
             */
            case "1":
            {
                System.out.println("Choose an item to add");
                System.out.println("1. Add new book");
                System.out.println("2. Add new magazine");
                System.out.println("3. Back");

                String value2 = scanner.nextLine();
                switch (value2)
                {
                    case "1":
                    {
                        boolean yn = false;
                        String loop;
                        while(yn == false)
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


                            registry.addNewLiterature(new Book(title, author, publisher, genre, releaseYear, edition));
                            System.out.println("\nIs this correct?" +"y/n?" +
                                    "\nTitle: " + title +
                                    "\nAuthor: " + author +
                                    "\nPublisher: " + publisher +
                                    "\nGenre: " + genre +
                                    "\nRelease Year: " + releaseYear +
                                    "\nEdition: " + edition);

                            ynPrompt();
                        }
                        break;
                    }

                    case "2":
                    {
                        boolean yn = false;
                        String loop;
                        while(yn == false)
                        {
                            System.out.println("\nAdding magazine!");
                            System.out.println("Please enter the title: ");
                            String title = scanner.nextLine();
                            System.out.println("Please enter the author: ");
                            String author = scanner.nextLine();
                            System.out.println("Please enter the publisher: ");
                            String publisher = scanner.nextLine();
                            System.out.println("Please enter the genre: ");
                            String genre = scanner.nextLine();
                            System.out.println("Please enter the release date: ");
                            String releaseDate = scanner.nextLine();
                            System.out.println("Please enter the edition");
                            String edition = scanner.nextLine();


                            registry.addNewLiterature(new Magazine(title, author, publisher, releaseDate, edition));
                            System.out.println("\nIs this correct?" +"y/n?" +
                                    "\nTitle: " + title +
                                    "\nAuthor: " + author +
                                    "\nPublisher: " + publisher +
                                    "\nGenre: " + genre +
                                    "\nRelease date: " + releaseDate +
                                    "\nEdition: " + edition);

                            ynPrompt();

                        }
                    }
                }
                System.out.println("Added an item successfully");
                break;
            }

            /**
             * Removes literature from the registry
             */
            case "2":
            {
                System.out.println("Removing literature!");
                System.out.println("Please enter the title of the literature you would like to remove: ");
                String title = scanner.nextLine();
                registry.removeLiteratureByTitle(title);
                System.out.println("Removed literature: " + title);
                break;
            }

            /**
             * Lists every book in the registry.
             */
            case "3":
            {
                if (registry.literatureLibraryIsEmpty())
                {
                    System.out.println("Sorry, there is no books in the library..");
                }
                else
                {
                    System.out.println("Listing all books!");
                    listAllBooks();
                }
                break;
            }

            /**
             * Lists every magazine in the registry
             */
            case "4":
            {
                if (registry.literatureLibraryIsEmpty())
                {
                    System.out.println("Sorry, there is no magazines in the library..");
                }
                else
                {
                    System.out.println("Listing all magazines!");
                    listAllMagazines();
                }
                break;
            }

            /**
             * Searches literature by title
             */
            case "5":
            {
                System.out.println("Search literature by title: ");
                String title = scanner.nextLine();
                Literature foundLiterature = registry.findLiteratureByTitle(title);

                if(foundLiterature == null)
                {
                    System.out.println("There is no literature by that name.");
                }
                else
                {
                    System.out.println("Found literature: " + title);
                }
                break;
            }

            /**
             * Quits the program
             */
            case "6":
            {
                System.out.println("Bye bye!");
                this.finished = true;
                break;
            }

            /**
             * Prints out a message for wrong inputs
             */
            default:
            {
                System.out.println("Unkown command! Try using numbers between 1 and 6!");
                break;
            }
        }

    }

    private void ynPrompt() {
        while(yn ==false)
        {
            loop = scanner.nextLine().trim().toLowerCase();

            if(loop.equals("y"))
            {
                yn = true;
            }
            else if (loop.equals("n"))
            {
                System.out.println("\nLets try again then..!");
                break;
            }
            else
            {
                System.out.println("Please Answer y/n!");
            }
        }
    }



}
