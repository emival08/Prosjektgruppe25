
/**
 * Write a description of class Result here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RaceResult
{
    private final Athlete athlete;
    private final double resultTime;
    
    /**
     * Constructor for objects of class Result
     */
    public RaceResult(Athlete athlete,double resultTime)
    {
        this.athlete = athlete;
        this.resultTime = resultTime;
      
    }
    public double getResultTime()
    {
        return resultTime;
    }
    public Athlete getAthlete()
    {
        return athlete;
    }
    public int compareTo(RaceResult raceResult)
    {
      int result = 0;
      
      if(this.resultTime > raceResult.getResultTime())
      {
        result = 1;
      }
      else if(this.resultTime == raceResult.getResultTime())
      {
         result = 0; 
      }
      else 
      {
          result = -1;
      }
      return result;
    }
    public String getResultsFromAll()
    {
        return "\nResults" + getAthlete()
        + "\n" + getResultTime();
    }
    
    
 
}
