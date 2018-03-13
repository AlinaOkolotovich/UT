import Triangle.triangle.Triangle;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

/**
 * Created by okolotovich on 3/5/18.
 */
public class GetSquareTest {
    Utils ut = new Utils();
    @DataProvider(name = "Correct Triangle")
    public static Object [][] correctTriangleSides(){
        Utils ut = new Utils();
        return new Object[][]{
                {5d, 3d, 7d, "correct triangle"},
        };
    }
    @DataProvider (name = "Incorrect Triangle")
    public static Object [][] oneSidesIsZero() {
        Utils ut = new Utils();
        return new Object[][]{
                {0d, ut.generateRandomDouble(0, 100), ut.generateRandomDouble(0, 100), "a = 0"},
                {ut.generateRandomDouble(0, 100), 0d, ut.generateRandomDouble(0, 100), "b = 0"},
                {ut.generateRandomDouble(0, 100), ut.generateRandomDouble(0, 100), 0d, "c = 0"},
                {0d, 0d, ut.generateRandomDouble(0, 100), "a = 0, b = 0"},
                {ut.generateRandomDouble(0, 100), 0d, 0d, "b = 0, c = 0"},
                {0d, ut.generateRandomDouble(0, 100), 0d, "a = 0, c = 0"},
                {0d, 0d, 0d, "a = 0, b = 0, c = 0"},
                {ut.generateRandomDouble(-100, 0), ut.generateRandomDouble(0, 100), ut.generateRandomDouble(0, 100), "a < 0"},
                {ut.generateRandomDouble(100, 0), ut.generateRandomDouble(-100, 0), ut.generateRandomDouble(0, 100), "b < 0"},
                {ut.generateRandomDouble(100, 0), ut.generateRandomDouble(0, 100), ut.generateRandomDouble(-100, 0), "c < 0"},
                {ut.generateRandomDouble(-100, 0), ut.generateRandomDouble(-100, 0), ut.generateRandomDouble(0, 100), "a < 0, b < 0"},
                {ut.generateRandomDouble(-100, 0), ut.generateRandomDouble(0, 100), ut.generateRandomDouble(-100, 0), "a < 0, c < 0"},
                {ut.generateRandomDouble(0, 100), ut.generateRandomDouble(-100, 0), ut.generateRandomDouble(-100, 0), "b < 0, c < 0"},
                {ut.generateRandomDouble(-100, 0), ut.generateRandomDouble(-100, 0), ut.generateRandomDouble(-100, 0), "a < 0, b < 0, c < 0"},
                {3.27d, 2.73d, 6d, "a + b = c"},
                {28.001d, 100d, 71.999d, "a + c = b"},
                {2.17d, 2.079d, 0.091d, "b + c = a"},
                {3d, 7d, 11d, "a + b < c"},
                {3d, 11d, 7d, "a + c < b"},
                {11d, 7d, 3d, "b + c < a"}
        };
    }

    @Test(dataProvider = "Correct Triangle")
    public void correctSquareCalculation(Double a, Double b, Double c, String message) {
        Triangle tr = new Triangle(a, b, c);
        assertEquals(6.49, tr.getSquare(), 0.01);
        System.out.println(message);
    }

    @Test(dataProvider = "Incorrect Triangle", expectedExceptions = Exception.class)
    public void squareExceptionIfSidesNotFormTriangle(double a, double b, double c, String message){
        //checks that application throws an exception if one of the side is zero
        Triangle tr = new Triangle(a, b, c);
        tr.getSquare();
    }
}
