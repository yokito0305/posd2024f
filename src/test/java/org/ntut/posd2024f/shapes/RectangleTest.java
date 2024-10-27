package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RectangleTest {
    @Test
    public void testRectangleCreate() {
        new Rectangle(3, 4); // area = 12, perimeter = 14
    }

    @Test
    public void testRectangleCreateWithZeroLength() {
        ShapeException exception = assertThrows(ShapeException.class, () -> new Rectangle(0, 4));
        assertEquals("It's not a rectangle!", exception.getMessage());
    }

    @Test
    public void testRectangleCreateWithZeroWidth() {
        ShapeException exception = assertThrows(ShapeException.class, () -> new Rectangle(3, 0));
        assertEquals("It's not a rectangle!", exception.getMessage());
    }

    @Test
    public void testRectangleArea() {
        Rectangle rectangle = new Rectangle(3, 4); // area = 12
        assertEquals(12, rectangle.area());
    }

    @Test
    public void testRectanglePerimeter() {
        Rectangle rectangle = new Rectangle(3, 4); // perimeter = 14
        assertEquals(14, rectangle.perimeter());
    }

    @Test
    public void testGetLength() {
        Rectangle rectangle = new Rectangle(3, 4);
        assertEquals(3, rectangle.getLength());
    }

    @Test
    public void testGetWidth() {
        Rectangle rectangle = new Rectangle(3, 4);
        assertEquals(4, rectangle.getWidth());
    }
}