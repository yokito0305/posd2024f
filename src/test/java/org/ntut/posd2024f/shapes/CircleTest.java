package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

@SuppressWarnings("unused")
public class CircleTest {
    private static double radius = 5;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void testConstructor() throws Exception {
        // e.g. Circle c = new Circle(...)
        Circle circle = new Circle(5.0);
    }

    @Test
    public void testConstructorWithNegativeRadius() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("It's not a circle!");
        Circle circle = new Circle(-5.0);
    }

    @Test
    public void testConstructorWithZeroRadius() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("It's not a circle!");
        Circle circle = new Circle(0);
    }

    @Test
    public void testArea() throws Exception {
        Circle circle = new Circle(radius);
        assertEquals(Math.PI * radius * radius, circle.area(), 0.01);
    }

    @Test
    public void testPerimeter() throws Exception {
        Circle circle = new Circle(radius);
        assertEquals(Math.PI * 2 * radius, circle.perimeter(), 0.01);
    }

    @Test
    public void testToString() throws Exception {
        Circle circle = new Circle(radius);
        assertEquals("Circle " + Double.toString(radius), circle.toString());
    }
}