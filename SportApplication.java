
/**
 * A Sports administration system. 
 * This interface defines the functionality required
 * from the sports system. It is expected that a class implementing
 * this interface, implements all the methods defined in this interface.
 * 
 * <p>This interface and the class that implements it, is to be considered as
 * part of the <b>user interface</b>. Hence it is natural and accepted to have 
 * code that interacts with the user in the class implementing this interface.
 *
 * @author asty
 * @version 1.0
 */
public interface SportApplication
{

    /**
     * Initialize the Sports-application.
     */
    void init();
    
    /**
     * Register an Athlete who will be participating in the race.
     */
    void registerAthlete();
    
    /**
     * Register the result of an Athlete having completed the race.
     */
    void registerResult();
    
    /**
     * List all competitors/athletes registered for the race.
     */
    void listCompetitors();
 
    /**
     * Show the result of the race, sorted by the place achieved in the race.
     */
    void showResult();
}
