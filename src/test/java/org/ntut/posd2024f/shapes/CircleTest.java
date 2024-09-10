package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

@SuppressWarnings("unused")
public class CircleTest {
    private static Circle circle;
    
    @BeforeClass
    public static void setUp() throws Exception {
        // 初始化全域變數
        circle = new Circle(5.0);
    }

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
    public void testArea() {
        assertEquals(78.54, circle.area(), 0.01);
    }

    @Test
    public void testPerimeter() {
        assertEquals(31.42, circle.perimeter(), 0.01);
    }

    @Test
    public void testToString() {
        assertEquals("Circle 5.0", circle.toString());
    }
}