package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

@SuppressWarnings("unused")
public class TriangleTest {
    private static double side1 = 2;
    private static double side2 = 3;
    private static double side3 = 4;
    private static double area;
    private static double perimeter;

    @BeforeClass
    public static void setUp() throws Exception {
        perimeter = side1 + side2 + side3;
        double s = perimeter / 2;
        area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void testConstructor() throws Exception {
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
    }

    @Test
    public void testConstructorWithNegativeSide1() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("It's not a triangle!");
        Triangle triangle = new Triangle(-3.0, 4.0, 5.0);
    }

    @Test
    public void testConstructorWithNegativeSide2() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("It's not a triangle!");
        Triangle triangle = new Triangle(3.0, -4.0, 5.0);
    }

    @Test
    public void testConstructorWithNegativeSide3() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("It's not a triangle!");
        Triangle triangle = new Triangle(3.0, 4.0, -5.0);
    }

    @Test
    public void testConstructorWithZeroSide1() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("It's not a triangle!");
        Triangle triangle = new Triangle(0, 4.0, 5.0);
    }

    // a + b <= c
    @Test
    public void testConstructorWithInvalidSide() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("It's not a triangle!");
        Triangle triangle = new Triangle(1.0, 2.0, 4.0);
    }

    @Test
    public void testConstructorWithZeroSide2() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("It's not a triangle!");
        Triangle triangle = new Triangle(3.0, 0, 5.0);
    }

    @Test
    public void testConstructorWithZeroSide3() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("It's not a triangle!");
        Triangle triangle = new Triangle(3.0, 4.0, 0);
    }

    @Test
    public void testArea()  throws Exception {
        Triangle triangle = new Triangle(side1, side2, side3);
        assertEquals(area, triangle.area(), 0.01);
    }

    @Test
    public void testPerimeter() throws Exception {
        Triangle triangle = new Triangle(side1, side2, side3);
        assertEquals(perimeter, triangle.perimeter(), 0.01);
    }

    @Test
    public void testToString() throws Exception {
        Triangle triangle = new Triangle(side1, side2, side3);
        assertEquals("Triangle " + Double.toString(side1) + " " + Double.toString(side2) + " " + Double.toString(side3), 
                        triangle.toString());
    }
}