import Triangle.triangle.Triangle;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

/**
 * Created by okolotovich on 3/5/18.
 */
public class DetectTriangleTest {
    Utils ut = new Utils();
    @DataProvider(name = "Ordinary triangles")
    public static Object [][] triangleSides(){
        Utils ut = new Utils();
        return new Object[][]{
                {ut.generateThreeSides("a+b>c"), "a+b>c", 4, true},
                {ut.generateThreeSides("a+c>b"), "a+b>c", 4, true},
                {ut.generateThreeSides("c+b>a"), "c+b>a", 4, true},
                {ut.generateThreeSides("a!=b!=c!, a=0"), "a!=b!=c!, a=0", 4, false},
                {ut.generateThreeSides("a!=b!=c!, b=0"), "a!=b!=c!, b=0", 4, false},
                {ut.generateThreeSides("a!=b!=c!, c=0"), "a!=b!=c!, c=0", 4, false},
                {ut.generateThreeSides("a!=b!=c!, a<0"), "a!=b!=c!, a<0", 4, false},
                {ut.generateThreeSides("a!=b!=c!, b<0"), "a!=b!=c!, b<0", 4, false},
                {ut.generateThreeSides("a!=b!=c!, c<0"), "a!=b!=c!, c<0", 4, false},
        };
    }
    @DataProvider(name = "Isosceles triangles")
    public static Object [][] isoscelesriangleSides(){
        Utils ut = new Utils();
        return new Object[][]{
                {ut.generateThreeSides("a=b"), "a=b", 2, true},
                {ut.generateThreeSides("a=c"), "a=c", 2, true},
                {ut.generateThreeSides("b=c"), "b=c", 2, true},
                {ut.generateThreeSides("a=b=0"), "a=b=0", 2, false},
                {ut.generateThreeSides("a=c=0"), "a=c=0", 2, false},
                {ut.generateThreeSides("b=c=0"), "b=c=0", 2, false},
                {ut.generateThreeSides("a=b, c=0"), "a=b, c=0", 2, false},
                {ut.generateThreeSides("a=c, b=0"), "a=c, b=0", 2, false},
                {ut.generateThreeSides("c=b, a=0"), "c=b, a=0", 2, false},
                {ut.generateThreeSides("a=b<0"), "a=b<0", 2, false},
                {ut.generateThreeSides("a=<0"), "a=c<0", 2, false},
                {ut.generateThreeSides("c=b<0"), "c=b<0", 2, false},
        };
    }

    @Test(dataProvider = "Ordinary triangles" )
    public void ordinaryTriangleCheck(Triangle tr, String condition, int triangleType, boolean isExpected) {
        if (isExpected == true) {
            assertEquals(triangleType, tr.detectTriangle());
        } else {
            Assert.assertNotEquals(triangleType, tr.detectTriangle());
        }
    }

    @Test(dataProvider = "Isosceles triangles")
    public void correctIsoscelesTriangle(Triangle tr, String condition, int triangleType, boolean isExpected) {
        if (isExpected == true) {
            assertEquals(triangleType, tr.detectTriangle());
        } else {
            Assert.assertNotEquals(triangleType, tr.detectTriangle());
        }
    }

    @Test
    public void notIsoscelesTriangleIfSideIsNegative() {
        createIsoscelesTriangleAndDetect(
                ut.generateRandomDouble(0, 100),
                ut.generateRandomDouble(-100, 0),
                2,
                10,
                false
        );
    }

    @Test
    public void notIsoscelesTriangleIfTwoSidesAreNegative() {
        createIsoscelesTriangleAndDetect(
                ut.generateRandomDouble(-100, 0),
                ut.generateRandomDouble(0, 100),
                2,
                10,
                false
        );
    }

    @Test
    public void correctEquilateralTriangle() {
        createEquilateralTriangleAndDetect(
                ut.generateRandomDouble(0, 100),
                3,
                true
        );
    }

    @Test
    public void notEquilateralTriangleIfSidesAreNegative() {
        createEquilateralTriangleAndDetect(
                ut.generateRandomDouble(-100, 0),
                1,
                false
        );
    }

    @Test
    public void notEquilateralTriangleIfSidesAreZeros() {
        createEquilateralTriangleAndDetect(0, 1, false);
    }

    @Test
    public void correctRectangularTriangle() {
        createRectangularTriangleAndDetect(3, 4, 8, true);
    }

    @Test
    public void notRectangularIfOneSideIsZero() {
        createRectangularTriangleAndDetect(ut.generateRandomDouble(0, 100), 0, 8, false);
        createRectangularTriangleAndDetect(ut.generateRandomDouble(0, 100), 0, 10, false);
        createRectangularTriangleAndDetect(ut.generateRandomDouble(0, 100), 0, 15, false);
        createRectangularTriangleAndDetect(ut.generateRandomDouble(0, 100), 0, 11, false);
    }

    @Test
    public void notRectangularTriangleIfAllSidesAreZero() {
        createRectangularTriangleAndDetect(0, 0, 8, false);
        createRectangularTriangleAndDetect(0, 0, 10, false);
        createRectangularTriangleAndDetect(0, 0, 15, false);
        createRectangularTriangleAndDetect(0, 0, 11, false);
    }

    @Test
    public void notRectangularIfOneSideIsNegative() {
        createRectangularTriangleAndDetect(
                ut.generateRandomDouble(0, 100),
                ut.generateRandomDouble(-100, 0),
                8,
                false);
        createRectangularTriangleAndDetect(
                ut.generateRandomDouble(0, 100),
                ut.generateRandomDouble(-100, 0),
                10,
                false);
        createRectangularTriangleAndDetect(
                ut.generateRandomDouble(0, 100),
                ut.generateRandomDouble(-100, 0),
                15,
                false);
        createRectangularTriangleAndDetect(
                ut.generateRandomDouble(0, 100),
                ut.generateRandomDouble(-100, 0),
                11,
                false);
    }

    @Test
    public void notRectangularIfTwoSidesAreNegative() {
        createRectangularTriangleAndDetect(
                ut.generateRandomDouble(-100, 0),
                ut.generateRandomDouble(-100, 0),
                8,
                false);
        createRectangularTriangleAndDetect(
                ut.generateRandomDouble(-100, 0),
                ut.generateRandomDouble(-100, 0),
                10,
                false);
        createRectangularTriangleAndDetect(
                ut.generateRandomDouble(-100, 0),
                ut.generateRandomDouble(-100, 0),
                15,
                false);
        createRectangularTriangleAndDetect(
                ut.generateRandomDouble(-100, 0),
                ut.generateRandomDouble(-100, 0),
                11,
                false);

    }


    private void createTriangleAndDetect(double a, double b, double c, int triangleType, boolean isExpected) {
        //creates a triangle with the given sides (a, b and c) and checks of which type the triangle is
        Triangle tr = new Triangle(a, b, c);
        if (isExpected == true) {
            assertEquals(triangleType, tr.detectTriangle());
        } else {
            Assert.assertNotEquals(triangleType, tr.detectTriangle());
        }
    }

    private void createIsoscelesTriangleAndDetect(double a, double b, int expectedTriangleType, boolean isExpected) {
        double c = a;
        Triangle tr = new Triangle(a, b, c);
        Triangle tr1 = new Triangle(a, c, b);
        Triangle tr2 = new Triangle(b, c, a);
        if (isExpected == true) {
            assertEquals(expectedTriangleType, tr.detectTriangle(), "for a = c");
            assertEquals(expectedTriangleType, tr1.detectTriangle(), "for a = b");
            assertEquals(expectedTriangleType, tr2.detectTriangle(), "for b = c");
        } else {
            Assert.assertNotEquals(expectedTriangleType, tr.detectTriangle(), "for a = c");
            Assert.assertNotEquals(expectedTriangleType, tr1.detectTriangle(), "for a = b");
            Assert.assertNotEquals(expectedTriangleType, tr2.detectTriangle(), "for b = c");
        }
    }

    private void createIsoscelesTriangleAndDetect(double a, double b, int expectedTriangleType1, int expectedTriangleType2, boolean isExpected) {
        double c = a;
        Triangle tr = new Triangle(a, b, c);
        Triangle tr1 = new Triangle(c, a, b);
        Triangle tr2 = new Triangle(b, c, a);
        if (isExpected == true) {
            assertEquals(expectedTriangleType1, tr.detectTriangle(), "for a = c");
            assertEquals(expectedTriangleType1, tr1.detectTriangle(), "for c = b");
            assertEquals(expectedTriangleType1, tr2.detectTriangle(), "for b = a");
            assertEquals(expectedTriangleType2, tr.detectTriangle(), "for a = c");
            assertEquals(expectedTriangleType2, tr1.detectTriangle(), "for c = b");
            assertEquals(expectedTriangleType2, tr2.detectTriangle(), "for b = a");
        } else {
            Assert.assertNotEquals(expectedTriangleType1, tr.detectTriangle(), "for a = c");
            Assert.assertNotEquals(expectedTriangleType1, tr1.detectTriangle(), "for c = b");
            Assert.assertNotEquals(expectedTriangleType1, tr2.detectTriangle(), "for b = a");
            Assert.assertNotEquals(expectedTriangleType2, tr.detectTriangle(), "for a = c");
            Assert.assertNotEquals(expectedTriangleType2, tr1.detectTriangle(), "for c = b");
            Assert.assertNotEquals(expectedTriangleType2, tr2.detectTriangle(), "for b = a");
        }

    }

    private void createEquilateralTriangleAndDetect(double a, int expectedTriangleType, boolean isExpected) {
        Triangle tr = new Triangle(a, a, a);
        if (isExpected == true) {
            assertEquals(expectedTriangleType, tr.detectTriangle());
        } else {
            Assert.assertNotEquals(expectedTriangleType, tr.detectTriangle());
        }
    }

    private void createRectangularTriangleAndDetect(double a, double b, int expectedTriangleType, boolean isExpected) {
        double c = Math.sqrt((a * a) + (b * b));
        Triangle tr = new Triangle(a, b, c);
        Triangle tr1 = new Triangle(b, c, a);
        Triangle tr2 = new Triangle(c, a, b);
        if (isExpected == true) {
            assertEquals(expectedTriangleType, tr.detectTriangle());
            assertEquals(expectedTriangleType, tr1.detectTriangle());
            assertEquals(expectedTriangleType, tr2.detectTriangle());
        } else {
            Assert.assertNotEquals(expectedTriangleType, tr.detectTriangle());
            Assert.assertNotEquals(expectedTriangleType, tr1.detectTriangle());
            Assert.assertNotEquals(expectedTriangleType, tr2.detectTriangle());
        }
    }

    private void createRectangularTriangleAndDetect(double a, double b, int expectedTriangleType1, int expectedTriangleType2, boolean isExpected) {
        double c = Math.sqrt((a * a) + (b * b));
        Triangle tr = new Triangle(a, b, c);
        Triangle tr1 = new Triangle(b, c, a);
        Triangle tr2 = new Triangle(c, a, b);
        if (isExpected == true) {
            assertEquals(expectedTriangleType1, tr.detectTriangle());
            assertEquals(expectedTriangleType1, tr1.detectTriangle());
            assertEquals(expectedTriangleType1, tr2.detectTriangle());
            assertEquals(expectedTriangleType2, tr.detectTriangle());
            assertEquals(expectedTriangleType2, tr1.detectTriangle());
            assertEquals(expectedTriangleType2, tr2.detectTriangle());
        } else {
            Assert.assertNotEquals(expectedTriangleType1, tr.detectTriangle());
            Assert.assertNotEquals(expectedTriangleType1, tr1.detectTriangle());
            Assert.assertNotEquals(expectedTriangleType1, tr2.detectTriangle());
            Assert.assertNotEquals(expectedTriangleType2, tr.detectTriangle());
            Assert.assertNotEquals(expectedTriangleType2, tr1.detectTriangle());
            Assert.assertNotEquals(expectedTriangleType2, tr2.detectTriangle());
        }
    }
}
