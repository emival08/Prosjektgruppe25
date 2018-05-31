import java.time.LocalDateTime;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CarReservationTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CarReservationTest
{
    public void testGetTotalCost()
    {
        System.out.println("getTotalCost");
        LocalDateTime fromDate = LocalDateTime.of(2017,5,14,13,0);
        LocalDateTime toDate = LocalDateTime.of(2017,5,16,13,0);
        int costPerDay = 750;
        
        RentalCar car = new RentalCar("Toyota","rav4", 2016,"uf73509");
        
        CarReservation instance = new CarReservation(car,"Arne Styve",fromDate,toDate,costPerDay);
        long expResult = 750*3;
        long result = instance.getTotalCost();
        assertEquals(expResult,result);
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
