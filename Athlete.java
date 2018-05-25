
/**
 * Holds all necessary information about a athlete.
 *
 * @author (ØT)
 * @version (1337)
 */
public class Athlete
{
    private String name;
    private int age;
    private int startNumber;
    private double personalBest;
    

    /**
     * Create an instance of athlete.
     * 
     * @param name, the name of the athlete
     * @param age, the age of the athlete
     * @param startNumber, the startnumber to the athlete
     * @param personalBest, the personal best lap record to the athlete
     */
    public Athlete(String name,int age)
    {
        // initialise instance variables
        this.name = name;
        this.age = age;
    }
    /**
     * Returns the name of the athlete
     * @return the name of the athlete
     */
    public String getName()
    {
        return name;
    }
    /**
     * Returns the age of the athlete
     * @return the age of the athlete
     */
    public int getAge()
    {
        return age;
    }
    /**
     * Returns the startnumber to the athlete
     * @return the startnumber to the athlete
     */
    public int getStartNumber()
    {
        return startNumber;
    }
    /**
     * Returns the personalbest to the athlete 
     * @return the personalbest to the athlete
     */
    public double personalBest()
    {
        return personalBest;
    }
    /**
     * Sets the starnumber of the athlete. Must be a posivite integer starting from 1. 
     * 
     * @param Startnumber of the athlete
     */
    public void setStartNumber(int startNumber)
    {
        this.startNumber = startNumber;
    }
    /**
     * Set new personalbest to the athlete
     * @param the new personalbest to the athlete
     */
    public void setNewPersonalBest(double personalBest)
    {
        this.personalBest = personalBest;
    }
    public String toString()
    {
        String ath = "name: " + this.name + " Age: " + this.age;
        return ath;
    }
   
   
}
