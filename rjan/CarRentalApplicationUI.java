
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Makes up the user interface (text based) of the application. Responsible for
 * the part of user interaction related to the menu, like displaying the menu,
 * and getting the choice from the user. When the user have selected which menu
 * item he/she would like to have executed, the execution is
 * <strong>delegated</strong> to the object of class
 * <code>CarRentalApplication</code>.
 *
 * @author asty
 * @version 1.0
 */
class CarRentalApplicationUI
{
    private static final String VERSION = "v3.0.5";
    
    private CarRentalApplication application = null;

    String[] menuItems =
    {
        "1. Add Car to car-register",
        "2. Make a reservation (rent a car)",
        "3. List all rentals of a specific car",
        "4. List all cars",
        "5. List all rentals",
    };

    private final static int ADD_CAR_TO_REGISTER = 1;
    private final static int MAKE_RESERVATION = 2;
    private final static int LIST_RENTALS_BY_CAR = 3;
    private final static int LIST_ALL_CARS = 4;
    private final static int LIST_ALL_RENTALS = 5;
    private final static int EXIT = 6;

    /**
     * Creates an instance of the CarRentalApplicationUI User interface. An
     * instance of the CarRentalApplication is created, and initialized.
     */
    public CarRentalApplicationUI()
    {
        this.application = new CarRentalApplicationImpl();
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
                    case ADD_CAR_TO_REGISTER:
                        this.application.doAddCarToCarRegister();
                        break;

                    case MAKE_RESERVATION:
                        this.application.doMakeReservation();
                        break;

                    case LIST_RENTALS_BY_CAR:
                        this.application.doListRentalsByCar();
                        break;

                    case LIST_ALL_CARS:
                        this.application.doListAllCars();
                        break;

                    case LIST_ALL_RENTALS:
                        this.application.doListAllRentals();
                        break;

                    case EXIT:
                        System.out.println("\nThank you for using CarRentalApplication " + VERSION + ". Bye!\n");
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
        System.out.println("\n**** Car Rental Application " + VERSION + " ****\n");
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
