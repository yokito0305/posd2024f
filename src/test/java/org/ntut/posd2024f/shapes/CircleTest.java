package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CircleTest {
    private static double radius = 5;

    @BeforeAll
    public static void setUp() {
        radius = 5;
    }

    @Test
    public void testConstructor() {
        Circle circle = new Circle(5.0);
    }

    @Test
    public void testConstructorWithNegativeRadius() {
        ShapeException exception = assertThrows(ShapeException.class, () -> {
            new Circle(-5.0);
        });
        assertEquals("It's not a circle!", exception.getMessage());
    }

    @Test
    public void testConstructorWithZeroRadius() {
        ShapeException exception = assertThrows(ShapeException.class, () -> {
            new Circle(0);
        });
        assertEquals("It's not a circle!", exception.getMessage());
    }

    @Test
    public void testArea() {
        Circle circle = new Circle(radius);
        assertEquals(Math.PI * radius * radius, circle.area(), 0.01);
    }

    @Test
    public void testPerimeter() {
        Circle circle = new Circle(radius);
        assertEquals(Math.PI * 2 * radius, circle.perimeter(), 0.01);
    }
}