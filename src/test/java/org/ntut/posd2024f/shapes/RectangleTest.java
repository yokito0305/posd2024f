package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

@SuppressWarnings("unused")
public class RectangleTest {
    private static double length = 5;
    private static double width = 10;
    
    @Test
    public void testConstructor() {
        Rectangle rectangle = new Rectangle(5.0, 10.0);
    }

    @Test
    public void testConstructorWithNegativeWidth() {
        ShapeException exception = assertThrows(ShapeException.class, () -> {
            new Rectangle(-5.0, 10.0);
        });
        assertEquals("It's not a rectangle!", exception.getMessage());
    }

    @Test
    public void testConstructorWithNegativeHeight() {
        ShapeException exception = assertThrows(ShapeException.class, () -> {
            new Rectangle(5.0, -10.0);
        });
        assertEquals("It's not a rectangle!", exception.getMessage());
    }

    @Test
    public void testConstructorWithZeroWidth() {
        ShapeException exception = assertThrows(ShapeException.class, () -> {
            new Rectangle(0, 10.0);
        });
        assertEquals("It's not a rectangle!", exception.getMessage());
    }

    @Test
    public void testConstructorWithZeroHeight() {
        ShapeException exception = assertThrows(ShapeException.class, () -> {
            new Rectangle(5.0, 0);
        });
        assertEquals("It's not a rectangle!", exception.getMessage());
    }

    @Test
    public void testArea() {
        Rectangle rectangle = new Rectangle(length, width);
        assertEquals(length * width, rectangle.area(), 0.01);
    }

    @Test
    public void testPerimeter() {
        Rectangle rectangle = new Rectangle(length, width);
        assertEquals(2 * (length + width), rectangle.perimeter(), 0.01);
    }
}