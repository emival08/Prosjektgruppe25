import java.util.LinkedList;
import java.util.Iterator;
/**
 * Write a description of class CarReservationsForCar here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CarReservationsForCar
{
    // instance variables - replace the example below with your own
    private LinkedList<CarReservation> rentedCars;
    /**
     * Constructor for objects of class CarReservationsForCar
     */
    public CarReservationsForCar()
    {
        this.rentedCars = new LinkedList <CarReservation>();
    }
    public void addReservation(CarReservation rentedCar)
    {
        this.rentedCars.add(rentedCar);
    }
    public void listAllReservations()
    {
        for(CarReservation c:this.rentedCars)
        {
            System.out.println(c.getReservations());
        }
    }
      
}
