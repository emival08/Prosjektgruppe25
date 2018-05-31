
/**
 * The Main-class of the application. This class only holds the main()-method
 * to start the application.
 *
 * @author asty
 * @version 1.0
 */
public class Main
{

    /**
     * The starting point for the application. <code>main</code> creates an
     * object instance of the {@link CarRentalApplicationUI} and calls the
     * <code>start</code> method of the class.
     *
     * @param args Command line arguments. This application takes non.
     */
    public static void main(String[] args)
    {
        CarRentalApplicationUI carRentalAppUI = new CarRentalApplicationUI();
        carRentalAppUI.start();
    }

    /**
     * Make the constructor private to avoid accidental creation of
     * an object instance of this class.
     */
    private Main()
    {
        // Left empty intentionally
    }
}
