import Triangle.src.triangle.Triangle;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

/**
 * Created by okolotovich on 3/2/18.
 */
public class CheckTriangleTest {
    Utils ut = new Utils();
    @Test
    public void sideCanNotBeZero() {
        // a = 0
        double b = ut.generateRandomDouble(0, 100);
        double c = ut.generateRandomDouble(0, 100);
        double a = 0;
        Triangle tr = new Triangle(a, b, c);
        assertEquals(false, tr.checkTriangle());
        assertEquals("a<=0", tr.getMessage());

        // b = 0
        double a1 = ut.generateRandomDouble(0, 100);
        double c1 = ut.generateRandomDouble(0, 100);
        double b1 = 0;
        Triangle tr1 = new Triangle(a1, b1, c1);
        assertEquals(false, tr1.checkTriangle());
        assertEquals("b<=0", tr1.getMessage());

        // c = 0
        double a2 = ut.generateRandomDouble(0, 100);
        double b2 = ut.generateRandomDouble(0, 100);
        double c2 = 0;
        Triangle tr2 = new Triangle(a2, b2, c2);
        assertEquals(false, tr2.checkTriangle());
        assertEquals("c<=0", tr2.getMessage());
    }
    @Test
    public void twoSidesCanNotBeZero(){
        // a = b = 0
        double a = 0;
        double b = 0;
        double c = ut.generateRandomDouble(0, 100);
        Triangle tr = new Triangle(a, b, c);
        assertEquals(false, tr.checkTriangle());
        assertEquals("a<=0","b<=0", tr.getMessage());

        // b = c = 0
        double b1 = 0;
        double c1 = 0;
        double a1 = ut.generateRandomDouble(0, 100);
        Triangle tr1 = new Triangle(a1, b1, c1);
        assertEquals(false, tr1.checkTriangle());
        assertEquals("c<=0","b<=0", tr1.getMessage());

        // a = c = 0
        double a2 = 0;
        double c2 = 0;
        double b2 = ut.generateRandomDouble(0, 100);
        Triangle tr2 = new Triangle(a2, b2, c2);
        assertEquals(false, tr2.checkTriangle());
        assertEquals("c<=0","a<=0", tr2.getMessage());
    }
    @Test
    public void threeSidesCanNotBeZero(){
        double a = 0;
        double b = 0;
        double c = 0;
        Triangle tr = new Triangle(a, b, c);
        assertEquals(false, tr.checkTriangle());
    }
    @Test
    public void sideCanNotBeNegative(){
        // a < 0
        double a = ut.generateRandomDouble(-100,0);
        double b = ut.generateRandomDouble(0,100);
        double c = ut.generateRandomDouble(0, 100);
        Triangle tr = new Triangle(a, b, c);
        assertEquals(false, tr.checkTriangle());
        assertEquals("a<=0", tr.getMessage());

        // b < 0
        double a1 = ut.generateRandomDouble(0,100);
        double b1 = ut.generateRandomDouble(-100,0);
        double c1 = ut.generateRandomDouble(0, 100);
        Triangle tr1 = new Triangle(a1, b1, c1);
        assertEquals(false, tr1.checkTriangle());
        assertEquals("b<=0", tr1.getMessage());

        // c < 0
        double a2 = ut.generateRandomDouble(0,100);
        double b2 = ut.generateRandomDouble(0,100);
        double c2 = ut.generateRandomDouble(-100, 0);
        Triangle tr2 = new Triangle(a2, b2, c2);
        assertEquals(false, tr1.checkTriangle());
        assertEquals("c<=0", tr1.getMessage());
    }
    @Test
    public void twoSidesCanNotBeNegative(){
        //a < 0, b < 0
        createAndValidateTriangle(
                ut.generateRandomDouble(-100,0),
                ut.generateRandomDouble(-100, 0),
                ut.generateRandomDouble(0,100),
                false
        );

        //a < 0, c < 0
        createAndValidateTriangle(
                ut.generateRandomDouble(-100, 0),
                ut.generateRandomDouble(0, 100),
                ut.generateRandomDouble(-100,0),
                false
        );

        //b < 0, c < 0
       createAndValidateTriangle(
               ut.generateRandomDouble(0,100),
               ut.generateRandomDouble(-100, 0),
               ut.generateRandomDouble(-100,0),
               false
       );
    }
    @Test
    public void threeSidesCanNotBeNegative(){
        //a < 0, b < 0, c < 0
        createAndValidateTriangle(
                ut.generateRandomDouble(-100, 0),
                ut.generateRandomDouble(-100, 0),
                ut.generateRandomDouble(-100, 0),
                false
        );
    }
    @Test
    public void sidesCanNotBeNegativeAndZero(){
        // a = 0, b < 0
        createAndValidateTriangle(
                0,
                ut.generateRandomDouble(-100, 0),
                ut.generateRandomDouble(0, 100),
                false
        );

        // a = 0, c < 0
        createAndValidateTriangle(
                0,
                ut.generateRandomDouble(0, 100),
                ut.generateRandomDouble(-100, 0),
                false
        );

        // b = 0, a < 0
        createAndValidateTriangle(
                ut.generateRandomDouble(-100, 0),
                0,
                ut.generateRandomDouble(0,100),
                false
        );
        // b = 0, c < 0
        createAndValidateTriangle(
                ut.generateRandomDouble(0,100),
                0,
                ut.generateRandomDouble(-100,0),
                false
        );

        // c = 0, a < 0
        createAndValidateTriangle(
                ut.generateRandomDouble(-100,0),
                ut.generateRandomDouble(0,100),
                0,
                false
        );

        // c = 0, b < 0
        createAndValidateTriangle(
                ut.generateRandomDouble(0,100),
                ut.generateRandomDouble(-100, 0),
                0,
                false
        );

        // a = 0, b < 0, c < 0
        createAndValidateTriangle(
                0,
                ut.generateRandomDouble(-100, 0),
                ut.generateRandomDouble(-100, 0),
                false
        );

        // b = 0, a < 0, c < 0
        createAndValidateTriangle(
                ut.generateRandomDouble(-100, 0),
               0,
                ut.generateRandomDouble(-100, 0),
                false
        );

        // c = 0, a < 0, b < 0
        createAndValidateTriangle(
                ut.generateRandomDouble(-100, 0),
                ut.generateRandomDouble(-100, 0),
                0,
                false
        );

        // a < 0, b = 0, c = 0
        createAndValidateTriangle(
                ut.generateRandomDouble(-100, 0),
                0,
                0,
                false
        );

        // b < 0, a = 0, c = 0
        createAndValidateTriangle(
                0,
                ut.generateRandomDouble(-100, 0),
                0,
                false
        );

        // c < 0, a = 0, b = 0
        createAndValidateTriangle(
                0,
                0,
                ut.generateRandomDouble(-100, 0),
                false
        );
    }
    @Test
    public void sumOfTwoSidesShouldBeMoreThenThird(){
        //(a + b) = c
        double a = ut.generateRandomDouble(1,100);
        double b = ut.generateRandomDouble(1,100);
        double c = a + b;
        createAndValidateTriangle(a, b, c, false);
        //(a + b) < c
        c = (a + b) + 1;
        createAndValidateTriangle(a, b, c, false);

        //(a + c) = b
        double a1 = ut.generateRandomDouble(1,100);
        double c1 = ut.generateRandomDouble(1,100);
        double b1 = a1 + c1;
        createAndValidateTriangle(a1, b1, c1, false);
        //(a + c) < b
        b1 = (a1 + c1) + 1;
        createAndValidateTriangle(a1, b1, c1, false);

        //(c + b) = a
        double c2 = ut.generateRandomDouble(1,100);
        double b2 = ut.generateRandomDouble(1,100);
        double a2 = c2 + b2;
        createAndValidateTriangle(a2, b2, c2, false);
        //(c + b) < a
        a2 = (c2 + b2) + 1;
        createAndValidateTriangle(a2, b2, c2, false);

    }
    @Test
    public void correctTriangle(){
        double a = ut.generateRandomDouble(1,100);
        double b = ut.generateRandomDouble(1,100);
        double c = (a + b) - 1;
        createAndValidateTriangle(a, b, c, true);

    }

    // boolean "isTriangle" is expected value to assert
    private void createAndValidateTriangle(double a, double b, double c, boolean isTriangle){
        Triangle tr = new Triangle(a, b, c);
        assertEquals(isTriangle, tr.checkTriangle());
    }

}
