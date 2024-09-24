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
    public void testConstructor() throws ShapeException {
        // e.g. Circle c = new Circle(...)
        Circle circle = new Circle(5.0);
    }

    @Test
    public void testConstructorWithNegativeRadius() throws ShapeException {
        expectedEx.expect(ShapeException.class);
        expectedEx.expectMessage("It's not a circle!");
        Circle circle = new Circle(-5.0);
    }

    @Test
    public void testConstructorWithZeroRadius() throws ShapeException {
        expectedEx.expect(ShapeException.class);
        expectedEx.expectMessage("It's not a circle!");
        Circle circle = new Circle(0);
    }

    @Test
    public void testArea() throws ShapeException {
        Circle circle = new Circle(radius);
        assertEquals(Math.PI * radius * radius, circle.area(), 0.01);
    }

    @Test
    public void testPerimeter() throws ShapeException {
        Circle circle = new Circle(radius);
        assertEquals(Math.PI * 2 * radius, circle.perimeter(), 0.01);
    }
}