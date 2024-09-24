package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

@SuppressWarnings("unused")
public class RectangleTest {
    private static double length = 5;
    private static double width = 10;
    
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void testConstructor() throws ShapeException {
        Rectangle rectangle = new Rectangle(5.0, 10.0);
    }

    @Test
    public void testConstructorWithNegativeWidth() throws ShapeException {
        expectedEx.expect(ShapeException.class);
        expectedEx.expectMessage("It's not a rectangle!");
        Rectangle rectangle = new Rectangle(-5.0, 10.0);
    }

    @Test
    public void testConstructorWithNegativeHeight() throws ShapeException {
        expectedEx.expect(ShapeException.class);
        expectedEx.expectMessage("It's not a rectangle!");
        Rectangle rectangle = new Rectangle(5.0, -10.0);
    }

    @Test
    public void testConstructorWithZeroWidth() throws ShapeException {
        expectedEx.expect(ShapeException.class);
        expectedEx.expectMessage("It's not a rectangle!");
        Rectangle rectangle = new Rectangle(0, 10.0);
    }

    @Test
    public void testConstructorWithZeroHeight() throws ShapeException {
        expectedEx.expect(ShapeException.class);
        expectedEx.expectMessage("It's not a rectangle!");
        Rectangle rectangle = new Rectangle(5.0, 0);
    }

    @Test
    public void testArea() throws ShapeException {
        Rectangle rectangle = new Rectangle(length, width);
        assertEquals(length * width, rectangle.area(), 0.01);
    }

    @Test
    public void testPerimeter() throws ShapeException {
        Rectangle rectangle = new Rectangle(length, width);
        assertEquals(2 * (length + width), rectangle.perimeter(), 0.01);
    }
}