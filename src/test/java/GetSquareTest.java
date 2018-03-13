import Triangle.triangle.Triangle;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

/**
 * Created by okolotovich on 3/5/18.
 */
public class GetSquareTest {
    Utils ut = new Utils();
    @Test
    public void correctSquareCalculation() {
        double a = 5;
        double b = 3;
        double c = 7;
        Triangle tr = new Triangle(a, b, c);
        assertEquals(6.49, tr.getSquare(), 0.01);
    }

    @Test(expectedExceptions = Exception.class)
    public void SquareExceptionIfSideIsZero(){
        //checks that application throws an exception if one of the side is zero
        double a = 0;
        double b = ut.generateRandomDouble(0,100);
        double c = ut.generateRandomDouble(0,100);
        double a1 = ut.generateRandomDouble(0,100);
        double b1 = 0;
        double c1 = ut.generateRandomDouble(0,100);
        double a2 = ut.generateRandomDouble(0,100);
        double b2 = ut.generateRandomDouble(0,100);
        double c2 = 0;
        Triangle tr = new Triangle(a, b, c);
        tr.getSquare();
        Triangle tr1 = new Triangle(a1, b1, c1);
        tr1.getSquare();
        Triangle tr2 = new Triangle(a2, b2, c2);
        tr2.getSquare();
    }
    @Test(expectedExceptions = Exception.class)
    public void SquareExceptionIfTwoSidesAreZero(){
        //checks that application throws an exception if 2 sides are zero
        double a = 0;
        double b = 0;
        double c = ut.generateRandomDouble(0,100);
        double a1 = ut.generateRandomDouble(0,100);
        double b1 = 0;
        double c1 = 0;
        double a2 = 0;
        double b2 = ut.generateRandomDouble(0,100);
        double c2 = 0;
        Triangle tr = new Triangle(a, b, c);
        tr.getSquare();
        Triangle tr1 = new Triangle(a1, b1, c1);
        tr1.getSquare();
        Triangle tr2 = new Triangle(a2, b2, c2);
        tr2.getSquare();
    }
    @Test(expectedExceptions = Exception.class)
    public void SquareExceptionAllSidesAreZero(){
        //checks that application throws an exception if 3 sides are zero
        double a = 0;
        double b = 0;
        double c = 0;
        Triangle tr = new Triangle(a, b, c);
        tr.getSquare();
    }
    @Test(expectedExceptions = Exception.class)
    public void SquareExceptionIfSideIsNegative(){
        //checks that application throws an exception if one of the side is negative
        double a = ut.generateRandomDouble(-100, 0);
        double b = ut.generateRandomDouble(0,100);
        double c = ut.generateRandomDouble(0,100);
        double a1 = ut.generateRandomDouble(0,100);
        double b1 = ut.generateRandomDouble(-100, 0);
        double c1 = ut.generateRandomDouble(0,100);
        double a2 = ut.generateRandomDouble(0,100);
        double b2 = ut.generateRandomDouble(0,100);
        double c2 = ut.generateRandomDouble(-100,0);
        Triangle tr = new Triangle(a, b, c);
        tr.getSquare();
        Triangle tr1 = new Triangle(a1, b1, c1);
        tr1.getSquare();
        Triangle tr2 = new Triangle(a2, b2, c2);
        tr2.getSquare();
    }
    @Test(expectedExceptions = Exception.class)
    public void SquareExceptionIfTwoSidesAreNegative(){
        //checks that application throws an exception if two sides are negative
        double a = ut.generateRandomDouble(-100,0);
        double b = ut.generateRandomDouble(-100,0);
        double c = 7;
        double a1 = 5;
        double b1 = ut.generateRandomDouble(-100,0);
        double c1 = ut.generateRandomDouble(-100,0);
        double a2 = ut.generateRandomDouble(-100,0);
        double b2 = 3;
        double c2 = ut.generateRandomDouble(-100,0);
        Triangle tr = new Triangle(a, b, c);
        tr.getSquare();
        Triangle tr1 = new Triangle(a1, b1, c1);
        tr1.getSquare();
        Triangle tr2 = new Triangle(a2, b2, c2);
        tr2.getSquare();
    }
    @Test(expectedExceptions = Exception.class)
    public void SquareExceptionIfAllSidesAreNegative(){
        //checks that application throws an exception if 3 sides are negative
        double a = ut.generateRandomDouble(-100,0);
        double b = ut.generateRandomDouble(-100,0);
        double c = ut.generateRandomDouble(-100,0);
        Triangle tr = new Triangle(a, b, c);
        tr.getSquare();
    }
    @Test(expectedExceptions = Exception.class)
    public void SquareExceptionIfSidesNotFormTriangle(){
        //checks that application throws an exception if a + b = c
        double a = ut.generateRandomDouble(0,100);
        double b = ut.generateRandomDouble(0,100);
        double c = a + b;
        Triangle tr = new Triangle(a, b, c);
        tr.getSquare();
        //checks that application throws an exception if a + c = b
        double a1 = ut.generateRandomDouble(0,100);
        double c1 = ut.generateRandomDouble(0,100);
        double b1 = a1 + c1;
        Triangle tr1 = new Triangle(a1, b1, c1);
        tr.getSquare();
        //checks that application throws an exception if c + b = a
        double c2 = ut.generateRandomDouble(0,100);
        double b2 = ut.generateRandomDouble(0,100);
        double a2 = c2 + b2;
        Triangle tr2 = new Triangle(a2, b2, c2);
        tr.getSquare();
    }
}
