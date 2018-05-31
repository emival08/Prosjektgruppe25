
/**
 * A car to be rented out to a customer. Holds all necessary information of the car.
 *
 * @author (Ørjan S.T)
 * @version (1337)
 */
public class RentalCar
{
    private String make;
    private String model;
    private int modelYear;
    private int milage;
    private String licensePlate;
    
   
    /**
     * Constructor for objects of class RentalCar
     * Create an instance of RentalCar.
     * 
     * @param make, the make of the car
     * @param model, the model of the car
     * @param modelYear, the modelyear of the car
     * @param licensePlate, the licenseplate number of the car.
     */
    
    public RentalCar(String make,String model, int modelYear, String licensePlate)
    {
        this.make = make;
        this.model = model;
        this.modelYear = modelYear;
        this.licensePlate = licensePlate;
        this.milage = 0;
        
    }
    /**
     * Return the make of the car
     * 
     * @returns the make of the car.
     */
    public String getMake()
    {
        return make;
    }
    /**
     * returns the model of the car. 
     *
     *@return the model of the chosen car. 
     */
    public String getModel()
    {
        return model;
    }
    /**
     * returns the modelYear of the car. 
     * 
     * @return the modelyear of the car. 
     */
    public int getModelYear()
    {
        return modelYear;
    }
    /**
     * returns the licenseplate number of the car.
     * 
     * @return the licenseplate number of the car.
     */
    public String getLicensePlate()
    {
        return licensePlate;
    }
    public int getMilage()
    {
        return milage;
    }
    /**
     * sets the milage of the car
     * 
     * @param the milage of the car.
     */
    public void setMilage(int milage)
    {
        this.milage = milage;
    }
}
