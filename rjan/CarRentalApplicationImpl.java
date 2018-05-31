import java.util.Iterator;
import java.util.Scanner;
import java.time.LocalDateTime;

/**
 * Represents the CarRentalApplication. The class is a delegate for the main
 * application and the menu-system. Any functions triggered by a menu selection
 * leads to a call to one of the methods in this class (via the
 * CarRentalApplication interface).
 *
 * @author asty
 * @version 0.1
 */
public class CarRentalApplicationImpl implements CarRentalApplication
{
    RentalCarRegister carRegister = new RentalCarRegister();
    CarReservationsForCar carReservations = new CarReservationsForCar();
    
    @Override
    public void init()
    {
        this.fillRegistersWithDataForTesting();
    }

    @Override
    public void doAddCarToCarRegister()
    {   
        Scanner reader = new Scanner(System.in);
        System.out.println("Please enter the details about the car to add");
        System.out.println("Car make   :");
        String carMake = reader.nextLine();
        System.out.println("Car model  :");
        String carModel = reader.nextLine();
        System.out.println("Model Year :");
        String modelYearStr = reader.nextLine();
        //convert the string to a int
        
        int modelYear = Integer.parseInt(modelYearStr);
        System.out.println("License plate :");
        String licensePlate = reader.nextLine();
        
        RentalCar car = new RentalCar(carMake,carModel, modelYear, licensePlate);
        
        this.carRegister.addCar(car);
        
        System.out.println("\n The following car was added to the register: \n");
        this.showCarDetails(car);
    }
    private void showCarDetails(RentalCar car)
    {
        System.out.println("Car make : " + car.getMake());
        System.out.println("Car model :" + car.getModel());
        System.out.println("Model Year:" + car.getModelYear());
        System.out.println("License  :"  + car.getLicensePlate());
        System.out.println("Milage   :"  + car.getMilage() + "km");
        System.out.println();
       
    }
    
    @Override
    public void doMakeReservation()
     {
        {
        Scanner reader = new Scanner(System.in);
        System.out.println("Please provide details about the rental:\n");

        System.out.println("Please enter name of customer (last,first): ");
        String customer = reader.nextLine();

        // First display a list of all cars available for rent
        this.doListAllCars();
        System.out.print("Please enter license plate of the car to rent: ");
        String licensePlate = reader.nextLine();
        RentalCar car = this.carRegister.findCar(licensePlate);

        if ( null == car )
        {
        System.out.println("\nSorry, there are no cars with license plate\n "
        + licensePlate);
        }
       else
       {
       System.out.println("Please enter date of rental (format: 2007-12-03T10:15:30): ");
       String dateTimeStr = reader.nextLine();
       LocalDateTime startDate = LocalDateTime.parse(dateTimeStr);
 
      System.out.println("Please enter date of return (format: 2007-12-03T10:15:30): ");
      dateTimeStr = reader.nextLine();
       LocalDateTime endDate = LocalDateTime.parse(dateTimeStr);

      System.out.println("Milage when rented (in km): ");
      int startMilage = reader.nextInt();
      System.out.println("Milage when returned (in km): ");
      int endMilage = reader.nextInt();

      System.out.println("Cost per day (in NOK): ");
      int costPerDay = reader.nextInt();

          CarReservation carRes =
         new CarReservation(car, customer,
       startDate, endDate, costPerDay);
       carRes.setStartMilage(startMilage);
        carRes.setEndMilage(endMilage);
 
        // Add the rental to the register
        this.carReservations.addReservation(carRes);

      }
      }
    }
    @Override
    public void doListRentalsByCar()
    {
        System.out.println("doListRentalsByCar() was called..");
    }

    @Override
    public void doListAllCars()
    {
        if(this.carRegister.isEmpty())
        {
         System.out.println("Sorry, there is no cars in the library");   
        }
        else
        {
            String formatString = "%-10s %-15s %-4s %-7s %6s";
            System.out.println("\n --- List of cars in the register---\n");
            System.out.printf(formatString, "make", "model", "Year","License","Mileage(km)");
            System.out.println("\n-----------------------------------");
            //Iterate over the cars in the register using a iterator
            Iterator<RentalCar> carIt = this.carRegister.getIterator();
            while(carIt.hasNext())
            {
                RentalCar car = carIt.next();
                System.out.printf(formatString + "\n", 
                                  car.getMake(), car.getModel(), 
                                  car.getModelYear(),car.getLicensePlate(),
                                  car.getMilage());
            }
            
        }
    }
    

    @Override
    public void doListAllRentals()
    {
        System.out.println("\n--- Listing all car rentals ---- \n");
        //this.showCarRentals(this.carReservations.listAllReservations());
    }
    
    /**
     * A helper method that fills the register(s) with some
     * data for testing purposes.
     */
    private void fillRegistersWithDataForTesting()
    {
        //TODO: Fill in code that creates some cars and some car-rentals
    }  
 
}
