import Triangle.triangle.Triangle;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by okolotovich on 3/5/18.
 */
public class GetSquareTest {
    @Test
    public void correctSquareCalculation() {
        double a = 5;
        double b = 3;
        double c = 7;
        Triangle tr = new Triangle(a, b, c);
        assertEquals(6.49, tr.getSquare(), 0.01);
    }
}
