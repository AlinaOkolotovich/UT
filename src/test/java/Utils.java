import Triangle.triangle.Triangle;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.assertEquals;

/**
 * Created by okolotovich on 3/5/18.
 */
public class Utils {
    @Test
    public double generateRandomDouble(double rangeMin, double rangeMax) {
        Random r = new Random();
        double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
        return randomValue;
    }
    public Triangle generateThreeSides(String condition){
        Triangle tr = null;
        if (condition.equals("a+b<c")|condition.equals("b+a<c")){
            double a = generateRandomDouble(0,100);
            double b = generateRandomDouble(0,100);
            double c = a + b + 1;
            tr = new Triangle(a, b, c);
        } else if (condition.equals("a+c<b")|condition.equals("c+a<b")){
            double a = generateRandomDouble(0,100);
            double c = generateRandomDouble(0,100);
            double b = a + c + 1;
            tr = new Triangle(a, b, c);
        } else if (condition.equals("b+c<a")|condition.equals("c+b<a")){
            double b = generateRandomDouble(0,100);
            double c = generateRandomDouble(0,100);
            double a = b + c + 1;
            tr = new Triangle(a, b, c);
        } else if (condition.equals("a+b=c")|condition.equals("b+a=c")){
            double a = generateRandomDouble(0,100);
            double b = generateRandomDouble(0,100);
            double c = a + b;
            tr = new Triangle(a, b, c);
        } else if (condition.equals("a+c=b")|condition.equals("c+a=b")){
            double a = generateRandomDouble(0,100);
            double c = generateRandomDouble(0,100);
            double b = a + c;
            tr = new Triangle(a, b, c);
        } else if (condition.equals("b+c=a")|condition.equals("c+b=a")){
            double b = generateRandomDouble(0,100);
            double c = generateRandomDouble(0,100);
            double a = b + c;
            tr = new Triangle(a, b, c);
        } else if (condition.equals("a+b>c")|condition.equals("b+a>c")){
            double a = generateRandomDouble(1,100);
            double b = generateRandomDouble(1,100);
            double c = a + b - 1;
            tr = new Triangle(a, b, c);
        } else if (condition.equals("a+c>b")|condition.equals("c+a>b")){
            double a = generateRandomDouble(1,100);
            double c = generateRandomDouble(1,100);
            double b = a + c - 1;
            tr = new Triangle(a, b, c);
        } else if (condition.equals("b+c>a")|condition.equals("c+b>a")){
            double b = generateRandomDouble(1,100);
            double c = generateRandomDouble(1,100);
            double a = c + b - 1;
            tr = new Triangle(a, b, c);
        } else if (condition.equals("a=b")|condition.equals("b=a")) {
            double a = generateRandomDouble(0, 100);
            double b = a;
            double c = generateRandomDouble(0, 100);
            tr = new Triangle(a, b, c);
        } else if (condition.equals("a=c")|condition.equals("c=a")) {
            double a = generateRandomDouble(0, 100);
            double c = a;
            double b = generateRandomDouble(0, 100);
            tr = new Triangle(a, b, c);
        } else if (condition.equals("c=b")|condition.equals("b=c")) {
            double b = generateRandomDouble(0, 100);
            double c = b;
            double a = generateRandomDouble(0, 100);
            tr = new Triangle(a, b, c);
        } else if (condition.equals("a=b=0")|condition.equals("b=a=0")) {
            double a = 0;
            double b = a;
            double c = generateRandomDouble(0, 100);
            tr = new Triangle(a, b, c);
        } else if (condition.equals("a=c=0")|condition.equals("c=a=0")) {
            double a = 0;
            double c = a;
            double b = generateRandomDouble(0, 100);
            tr = new Triangle(a, b, c);
        } else if (condition.equals("b=c=0")|condition.equals("c=b=0")) {
            double b = 0;
            double c = b;
            double a = generateRandomDouble(0, 100);
            tr = new Triangle(a, b, c);
        } else if (condition.equals("a=b<0")|condition.equals("b=a<0")) {
            double a = generateRandomDouble(-100,0);
            double b = a;
            double c = generateRandomDouble(0, 100);
            tr = new Triangle(a, b, c);
        } else if (condition.equals("a=c<0")|condition.equals("c=a<0")) {
            double a = generateRandomDouble(-100,0);;
            double c = a;
            double b = generateRandomDouble(0, 100);
        } else if (condition.equals("b=c<0")|condition.equals("b=a<0")) {
            double b = generateRandomDouble(-100,0);;
            double c = b;
            double a = generateRandomDouble(0, 100);
        } else if (condition.equals("a=b, c=0")|condition.equals("b=a, c=0")) {
            double a = generateRandomDouble(0, 100);
            double b = a;
            double c = 0;
            tr = new Triangle(a, b, c);
        } else if (condition.equals("a=c, b=0")|condition.equals("c=a, b=0")) {
            double a = generateRandomDouble(0, 100);
            double c = a;
            double b = 0;
            tr = new Triangle(a, b, c);
        } else if (condition.equals("c=b, a=0")|condition.equals("b=c, a=0")) {
            double b = generateRandomDouble(0, 100);
            double c = b;
            double a = 0;
            tr = new Triangle(a, b, c);
        } else if (condition.equals("a!=b!=c!=0")) {
            double a = generateRandomDouble(0, 100);
            double b = generateRandomDouble(0, 100);
            double c = generateRandomDouble(0, 100);
            tr = new Triangle(a, b, c);
        } else if (condition.equals("a!=b!=c!, a=0")) {
            double a = 0;
            double b = generateRandomDouble(0, 100);
            double c = generateRandomDouble(0, 100);
            tr = new Triangle(a, b, c);
        } else if (condition.equals("a!=b!=c!, b=0")) {
            double b = 0;
            double a = generateRandomDouble(0, 100);
            double c = generateRandomDouble(0, 100);
            tr = new Triangle(a, b, c);
        } else if (condition.equals("a!=b!=c!, c=0")) {
            double c = 0;
            double b = generateRandomDouble(0, 100);
            double a = generateRandomDouble(0, 100);
            tr = new Triangle(a, b, c);
        } else if (condition.equals("a!=b!=c!, a<0")) {
            double c = generateRandomDouble(0,100);
            double b = generateRandomDouble(0, 100);
            double a = generateRandomDouble(-100, 0);
            tr = new Triangle(a, b, c);
        } else if (condition.equals("a!=b!=c!, b<0")) {
            double c = generateRandomDouble(0,100);
            double a = generateRandomDouble(0, 100);
            double b = generateRandomDouble(-100, 0);
            tr = new Triangle(a, b, c);
        } else if (condition.equals("a!=b!=c!, c<0")) {
            double a = generateRandomDouble(0,100);
            double b = generateRandomDouble(0, 100);
            double c = generateRandomDouble(-100, 0);
            tr = new Triangle(a, b, c);
        } else {
            System.out.println("Wrong condition format.");
        }
        return tr;

    }
}
