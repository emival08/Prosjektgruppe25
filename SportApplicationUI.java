
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Makes up the user interface (text based) of the application. Responsible for
 * the part of user interaction related to the menu, like displaying the menu,
 * and getting the choice from the user. When the user have selected which menu
 * item he/she would like to have executed, the execution is
 * <strong>delegated</strong> to the object of class
 * <code>SportApplication</code>.
 *
 * @author asty
 * @version 1.0
 */
class SportApplicationUI
{
    private static final String VERSION = "v0.1";
    
    private SportApplication application = null;

    String[] menuItems =
    {
        "1. Register Athlete to competition",
        "2. Register result for an Athlete",
        "3. List all Athletes",
        "4. List result of competition",
    };

    private final static int REGISTER_ATHLETE = 1;
    private final static int REGISTER_RESULT = 2;
    private final static int LIST_ALL_ATHLETES = 3;
    private final static int LIST_RESULTS = 4;
    private final static int EXIT = 5;

    /**
     * Creates an instance of the User interface. An
     * instance of the SportApplication is created, and initialized.
     */
    public SportApplicationUI()
    {
        this.application = new SportApplicationImpl();
    }

    /**
     * Starts the application by showing the menu and retrieving input from the
     * user.
     */
    void start()
    {
        this.application.init();

        boolean quit = false;

        while (!quit)
        {
            try
            {
                int menuSelection = this.showMenu();
                switch (menuSelection)
                {
                    case REGISTER_ATHLETE:
                        this.application.registerAthlete();
                        break;

                    case REGISTER_RESULT:
                        this.application.registerResult();
                        break;

                    case LIST_ALL_ATHLETES:
                        this.application.listCompetitors();
                        break;

                    case LIST_RESULTS:
                        this.application.showResult();
                        break;

                    case EXIT:
                        System.out.println("\nThank you for using Sport Application " + VERSION + ". Bye!\n");
                        quit = true;
                        break;

                    default:
                }
            }
            catch (InputMismatchException ime)
            {
                System.out.println("\nERROR: Please provide a number between 1 and " + this.menuItems.length + "..\n");
            }
        }

    }

    /**
     * Displays the menu to the user, and waits for the users input. The user is
     * expected to input an integer between 1 and the max number of menu items.
     * If the user inputs anything else, an InputMismatchException is thrown.
     * The method returns the valid input from the user.
     *
     * @return the menu number (between 1 and max menu item number) provided by
     * the user.
     * @throws InputMismatchException
     */
    private int showMenu() throws InputMismatchException
    {
        System.out.println("\n**** Sports Application " + VERSION + " ****\n");
        for (String menuItem : menuItems)
        {
            System.out.println(menuItem);
        }
        int maxMenuItemNumber = menuItems.length + 1;
        System.out.println(maxMenuItemNumber + ". Exit\n");
        System.out.println("Please choose menu item (1-" + maxMenuItemNumber + "): ");

        Scanner reader = new Scanner(System.in);
        int menuSelection = reader.nextInt();
        if ((menuSelection < 1) || (menuSelection > maxMenuItemNumber))
        {
            throw new InputMismatchException();
        }
        return menuSelection;
    }

}
