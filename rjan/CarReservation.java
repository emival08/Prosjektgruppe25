import java.time.Duration;
import java.time.LocalDateTime;

/**
 * The CarReservation class represents a single reservation of a car to be
 * rented by a customer.
 * 
 * @author arne
 * @version 0.1
 */
public class CarReservation
{
    private LocalDateTime reservedFrom;
    private LocalDateTime reservedTo;
    private RentalCar rentedCar;
    private String customer;
    private int startMilage;
    private int endMilage;
    private int costPerDay;
    
    //TODO: Add more fields as required
    
    /**
     * Creates an instance of the CarReservation class.
     * This is just a TEMPORARLY constructor.
     * TODO: You should change this according to the requirements.
     * 
     * @param fromDateAndTime the date and time when the reservation starts
     * @param toDateAndTime the date and time of the end of the reservation
     */
    public CarReservation(RentalCar rentedCar,String customer,LocalDateTime fromDateAndTime, 
            LocalDateTime toDateAndTime, int costPerDay)
    {
        this.rentedCar = rentedCar;
        this.customer = customer;
        this.reservedFrom = fromDateAndTime;
        this.reservedTo = toDateAndTime;
        this.costPerDay = costPerDay;
        
    }
    
    public LocalDateTime getReservedFrom()
    {
        return reservedFrom;
    }
    public LocalDateTime getReservedTo()
    {
        return reservedTo;
    }
    public void setReservedTo(LocalDateTime reservedTo)
    {
        this.reservedTo = reservedTo;
    }
    public String getCustomer()
    {
        return customer;
    }
    public RentalCar getRentedCar()
    {
        return rentedCar;
    }
    public int getStartMilage()
    {
        return startMilage;
    }
    public void setEndMilage(int endMilage)
    {
        this.endMilage = endMilage;
    }
    public void setStartMilage(int startMilage)
    {
        this.startMilage = startMilage;
    }
    public int getCostPerDay()
    { 
       return costPerDay; 
    }
    public void setCostPerDay(int costPerDay)
    {
        this.costPerDay = costPerDay;
    }
    public long getTotalCost()
    {
        return this.getNumberOfRentalDays() * this.costPerDay;
    }
    
    /**
     * Returns the number of days between the start of the rental
     * period to the end of the rental period. 
     * The number of days are returned as an integer 
     * (whole days, not as decimal).
     * 
     * @return  the number of days between the start of the rental
     *          period to the end of the rental period.
     */
    public long getNumberOfRentalDays()
    {
        return this.getRentalDuration().toDays();
    }
    
    /**
     * Returns the total number of hours from the date and time the rental
     * periods start, till it ends.
     * 
     * @return  the total number of hours from the date and time the rental
     *          periods start, till it ends.
     */
    public long getNumberOfRentalHours()
    {
        return this.getRentalDuration().toHours();
    }
    
    /**
     * Returns the duration of the rental period as an 
     * object of <code>Duration</code>.
     * @return the duration of the rental period
     */
    private Duration getRentalDuration()
    {
        return Duration.between(this.reservedFrom, this.reservedTo);
    }
    
    /**
     * Returns a String holding the details of the rental period. The string
     * holds information about the date and time of the start and the end
     * of the rental period, and how many days or hours in total.
     * 
     * @return the details of the rental period as a String.
     */
    public String getRentalPeriodDetailsAsString()
    {
        String detailsString = "Rental start from "
                + this.reservedFrom.toString() 
                + " to " + this.reservedTo.toString()
                + ", a total of " + this.getNumberOfRentalDays() + " days "
                + "or " + this.getNumberOfRentalHours() + " hours.";
        return detailsString;
    }
    
    /**
     * This static class function shows how the class CarReservation 
     * might be used in an application. Use the code here as an example,
     * but do not use this method from your own code in your final solution.
     */
    public static void exampleOfUse()
    {
        // To create a date-and-time object, use the "of()"-method of the
        // LocalDateTime-class.
        // The "of()" method takes the following parameters:
        //  day (1-31)
        //  month (1-12)
        //  year (like 2017 for example)
        //  hours (0-23)
        //  minutes (0-59)
        // Create a startrental from 10th May 2017 at 13:42
        //LocalDateTime startRentalDateTime = LocalDateTime.of(10, 5, 2017, 13, 42);
        // To 12th May at 13:15
        //LocalDateTime endRentalDateTime = LocalDateTime.of(12, 5, 2017, 13, 15);
        
        //Create a Car Reservation, with hourly cost of 120
       // CarReservation carRes = new CarReservation();
        
        //Get the number of days the car has been rented for
        //System.out.println("Number of rental days: " + carRes.getNumberOfRentalDays());
        
        // Get the number of hours the rental car 
        
        //System.out.println("Number of rental hours in total: " + carRes.getNumberOfRentalHours());
        
    }
    public String getReservations()
    {
        return "\nRented car: " + getRentedCar() +
        "\nCustomer:  " + getCustomer() + 
        "\nReserved from: " + getReservedFrom() + 
        "\nReserved to :" + getReservedTo() +
        "\nThe cost per day: " + getTotalCost();
    }
            
}
