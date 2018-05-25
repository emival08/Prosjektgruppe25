import java.util.Scanner; 
import java.util.Iterator;
import java.lang.Integer;
/**
 * Represents the SportApplication. The class is a delegate for the main
 * application and the menu-system. Any functions triggered by a menu selection
 * leads to a call to one of the methods in this class (via the
 * SportApplication interface).
 *
 * @author asty
 * @version 0.1
 */
public class SportApplicationImpl implements SportApplication
{
    AthleteRegister athleteRegister = new AthleteRegister();
   
    Scanner scanner = new Scanner(System.in);
    @Override
    public void init()
    {
        this.fillRegistersWithDataForTesting();
    }
    
    @Override
    public void registerAthlete()
    {
        
        System.out.println("Adding athlete! ");
        System.out.println("Please enter the athlete name: ");
        String name = scanner.nextLine();
        System.out.println("Please enter the athletes age: ");
        String ageStr = scanner.nextLine();
        int age = Integer.valueOf(ageStr);
      
        Athlete athlete = new Athlete(name,age);
        this.athleteRegister.addNewAthlete(athlete);   
        
        System.out.println("\nThe following athlete was added to the register: \n");
        this.showAthleteDetails(athlete);
    }

    @Override
    public void registerResult()
    {
        System.out.println("Register result on athlete!");
        System.out.println("\nPlease write the name of the athlete you want to register result on:");
        String name = scanner.nextLine();
        
        Athlete foundAthlete = athleteRegister.findAthleteByName(name);
        if(foundAthlete == null)
        {
            System.out.println("Sorry, there is no athlete by that name here.");
        }
        else
        {
            System.out.println("Found athlete, please  write the result now. ");
            double result = scanner.nextDouble();
            RaceResult raceResult = new RaceResult(foundAthlete,result);
            this.athleteRegister.addNewResult(raceResult);
            System.out.println("Added result success");
        }
       
    }
    
    @Override
    public void listCompetitors()
    {
        Iterator<Athlete> itr = this.athleteRegister.getIterator();
        while(itr.hasNext())
        {
            Athlete athlete = itr.next();
            System.out.println(athlete.getName());
            
        }
    }
    @Override
    public void showResult()
    {
        System.out.println("showing all results"); 
        athleteRegister.listAllResults();   
    }
    
    /**
     * A helper method that fills the register(s) with some
     * data for testing purposes.
     */
    private void fillRegistersWithDataForTesting()
    {
        //TODO: Fill in code that creates some athletes and some results
    }       
    private void showAthleteDetails(Athlete athlete)
    {
       System.out.println("Athlete name : " + athlete.getName());
       System.out.println("Athlete age  : " + athlete.getAge());
    }
}
