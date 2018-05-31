import java.util.HashMap;
import java.util.Iterator;
/**
 * Write a description of class RentalCarRegister here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RentalCarRegister
{
 private HashMap<String,RentalCar> cars;
 
 

    /**
     * Constructor for objects of class RentalCarRegister
     */
 public RentalCarRegister()
 {
    this.cars = new HashMap<>();
    //fillRegisterWithCars();
    
 }
 public void addCar(RentalCar car)
 {
    this.cars.put(car.getLicensePlate(),car);
 }
 public boolean removeCar(String licensePlate)
 {
    boolean success = false;
    if( null != this.cars.remove(licensePlate))
        {
            success = true;
        }
    return success;
 }
 public RentalCar findCar(String licensePlate)
 {
    RentalCar foundCar = null;
    foundCar = this.cars.get(licensePlate);
    return foundCar;
        
 }
 /**
  * Returns the number of cars in the register.
  *
  * @return the number of cars in the register.
  */
 public int getNumberOfCars()
 {
    return this.cars.size();
 }

 /**
  * Returns an iterator over the cars in the register.
  *
  * @return an iterator over the cars in the register.
  */
 public Iterator<RentalCar> getIterator()
 {
    return this.cars.values().iterator();
 }

 /**
  * Helper-method used during development. The method fills the register
  * with some cars.
  */
 private void fillRegisterWithCars()
 {
  this.cars.put("UF32543", new RentalCar("Toyota", "Rav4 Hybrid", 2016, "UF32543"));
  this.cars.put("TF16342", new RentalCar("Toyota", "Avensis", 2006, "TF16342"));
  this.cars.put("SU71456", new RentalCar("Volvo", "XC90", 2016, "SU71456"));
  this.cars.put("XS47624", new RentalCar("BMW", "X3", 2015, "XS47624"));
  this.cars.put("AV21543", new RentalCar("VM", "Golf", 2013, "AV21543"));
  } 
 public boolean isEmpty()
 {
     return cars.isEmpty();
 }
 


}
    


