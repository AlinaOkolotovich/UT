import Triangle.triangle.Triangle;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

/**
 * Created by okolotovich on 3/2/18.
 */
public class CheckTriangleTest {
    Utils ut = new Utils();

    @DataProvider(name = "Incorrect Triangle with zero sides")
    public static Object [][] zeroTriangleSides(){
        Utils ut = new Utils();
        return new Object[][]{
                {0d, ut.generateRandomDouble(0,100), ut.generateRandomDouble(0,100), "a = 0", "a<=0"},
                {ut.generateRandomDouble(0,100), 0d, ut.generateRandomDouble(0,100), "b = 0", "b<=0"},
                {ut.generateRandomDouble(0,100), ut.generateRandomDouble(0,100), 0d,  "c = 0", "c<=0"},
                {0d, 0d, ut.generateRandomDouble(0,100), "a = 0, b = 0", "a<=0"},
                {0d, ut.generateRandomDouble(0,100), 0d, "a = 0, c = 0", "a<=0"},
                {ut.generateRandomDouble(0,100), 0d, 0d, "b = 0, c = 0", "b<=0"},
                {0d, 0d, 0d, "a = b = c = 0", "a<=0"},
        };
    }
    @DataProvider(name = "Incorrect Triangle with negative sides")
    public static Object [][] negativeTriangleSides(){
        Utils ut = new Utils();
        return new Object[][]{
                {ut.generateRandomDouble(-100,0), ut.generateRandomDouble(0,100), ut.generateRandomDouble(0,100), "a < 0", "a<=0"},
                {ut.generateRandomDouble(0,100), ut.generateRandomDouble(-100,0), ut.generateRandomDouble(0,100), "b < 0", "b<=0"},
                {ut.generateRandomDouble(0,100), ut.generateRandomDouble(0,100), ut.generateRandomDouble(-100,0),  "c < 0", "c<=0"},
                {ut.generateRandomDouble(-100,0), ut.generateRandomDouble(-100,0), ut.generateRandomDouble(0,100), "a < 0, b < 0", "a<=0"},
                {ut.generateRandomDouble(-100,0), ut.generateRandomDouble(0,100), ut.generateRandomDouble(-100,0), "a < 0, c < 0", "a<=0"},
                {ut.generateRandomDouble(0,100), ut.generateRandomDouble(-100,0), ut.generateRandomDouble(-100,0), "b < 0, c < 0", "b<=0"},
                {ut.generateRandomDouble(-100,0), ut.generateRandomDouble(-100,0), ut.generateRandomDouble(-100,0), "a < 0, b < 0,  c < 0", "a<=0"},
        };
    }
    @DataProvider(name = "Incorrect Triangle with negative and zero sides")
    public static Object [][] negativeAndZeroTriangleSides(){
        Utils ut = new Utils();
        return new Object[][]{
                {0d, ut.generateRandomDouble(-100,0), ut.generateRandomDouble(0,100), "a = 0, b < 0", "a<=0"},
                {ut.generateRandomDouble(-100,0), 0d, ut.generateRandomDouble(0,100), "a < 0, b = 0", "a<=0"},
                {ut.generateRandomDouble(-100,0), ut.generateRandomDouble(0,100), 0d, "a < 0, c = 0", "a<=0"},
                {0d, ut.generateRandomDouble(0, 100), ut.generateRandomDouble(-100,0), "a = 0, c < 0", "a<=0"},
                {ut.generateRandomDouble(0,100), 0d, ut.generateRandomDouble(-100,0),  "b = 0, c < 0", "b<=0"},
                {ut.generateRandomDouble(0,100), ut.generateRandomDouble(-100,0), 0d, "b < 0, c = 0", "b<=0"},
                {0d, 0d, ut.generateRandomDouble(-100,0), "a = 0, b = 0, c < 0", "a<=0"},
                {0d, ut.generateRandomDouble(-100,0), 0d, "a = 0, b < 0, c = 0", "a<=0"},
                {ut.generateRandomDouble(-100,0), 0d, 0d, "a < 0, b = 0,  c = 0", "a<=0"},
        };
    }
    @DataProvider(name = "Incorrect Triangle sum of two sides should be more then third")
    public static Object [][] sumOfTwoSidesLessThenThirdTriangle(){
        Utils ut = new Utils();
        return new Object[][]{
                {ut.generateThreeSides("a+b=c"), "a + b = c", "a+b<=c"},
                {ut.generateThreeSides("a+c=b"), "a + c = b", "a+c<=b"},
                {ut.generateThreeSides("b+c=a"), "b + c = a", "b+c<=a"},
                {ut.generateThreeSides("a+b<c"), "a + b < c", "a+b<=c"},
                {ut.generateThreeSides("a+c<b"), "a + c < b", "a+c<=b"},
                {ut.generateThreeSides("b+c<a"), "b + c < a", "b+c<=a"},
        };
    }
    @DataProvider(name = "Correct Triangle sum of two sides more then third side")
    public static Object [][] sumOfTwoSidesMoreThenThirdTriangle() {
        Utils ut = new Utils();
        return new Object[][]{
                {ut.generateThreeSides("a+b>c"), "a + b > c"},
                {ut.generateThreeSides("b+c>a"), "b + c > a"},
                {ut.generateThreeSides("a+c>b"), "a + c > b"},
        };
    }
    @Test(dataProvider = "Incorrect Triangle with zero sides")
    public void sideCanNotBeZero(Double a, Double b, Double c, String condition, String message) {
        Triangle tr = new Triangle(a, b, c);
        assertEquals(false, tr.checkTriangle());
        assertEquals(message, tr.getMessage());
    }

    @Test(dataProvider = "Incorrect Triangle with negative sides")
    public void sideCanNotBeNegative(Double a, Double b, Double c, String condition, String message) {
        Triangle tr = new Triangle(a, b, c);
        assertEquals(false, tr.checkTriangle());
        assertEquals(message, tr.getMessage());
    }

    @Test(dataProvider = "Incorrect Triangle with negative and zero sides")
    public void sidesCanNotBeNegativeAndZero(Double a, Double b, Double c, String condition, String message) {
        Triangle tr = new Triangle(a, b, c);
        assertEquals(false, tr.checkTriangle());
    }

    @Test(dataProvider = "Incorrect Triangle sum of two sides should be more then third")
    public void sumOfTwoSidesShouldBeMoreThenThird(Triangle tr, String condition, String message) {
        assertEquals(false, tr.checkTriangle());
        assertEquals(message, tr.getMessage());
    }

    @Test (dataProvider = "Correct Triangle sum of two sides more then third side")
    public void correctTriangle(Triangle tr, String condition) {
        assertEquals(true, tr.checkTriangle());
    }
}
