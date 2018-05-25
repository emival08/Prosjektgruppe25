import java.util.ArrayList;
import java.util.Iterator;
/**
 * Write a description of class AthleteRegister here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AthleteRegister
{
   
    private ArrayList<Athlete> athleteRegistry;
    private ArrayList<RaceResult> athleteResults; 
    /**
     * Constructor for objects of class AthleteRegister
     */
    public AthleteRegister()
    {
        this.athleteRegistry = new ArrayList<Athlete>();
        this.athleteResults = new ArrayList<RaceResult>();
    }   
    public void addNewAthlete(Athlete athlete)
    {
       this.athleteRegistry.add(athlete); 
    }
    public void addNewResult(RaceResult raceresult)
    {
        this.athleteResults.add(raceresult);
    }
    public void listAllAthletes()
    {
      for(int index = 0; index < athleteRegistry.size(); index++)
      {
        Athlete a = athleteRegistry.get(index);
        System.out.println(a.toString());
      }
    }
    public Iterator<Athlete> getIterator()
    {
        return this.athleteRegistry.iterator();
    }
    public Athlete findAthleteByName(String name)
    {
        Athlete foundAthlete = null;
        
        Iterator<Athlete> it = this.athleteRegistry.iterator();
        while((null == foundAthlete) && (it.hasNext()))
        {
            Athlete a = it.next();
            if(a.getName().equals(name))
            {
                foundAthlete = a;
            }
        }
        return foundAthlete;
    }
    public void listAllResults()
    {
        for(RaceResult r:this.athleteResults)
        {
            System.out.println(r.getResultsFromAll());
        }
    }
    
    
}
