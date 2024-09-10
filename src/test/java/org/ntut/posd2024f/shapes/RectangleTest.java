package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

@SuppressWarnings("unused")
public class RectangleTest {
    private static Rectangle rectangle;

    @BeforeClass
    public static void setUp() throws Exception {
        // 初始化全域變數
        rectangle = new Rectangle(5.0, 10.0);
    }
    
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void testConstructor() throws Exception {
        Rectangle rectangle = new Rectangle(5.0, 10.0);
    }

    @Test
    public void testConstructorWithNegativeWidth() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("It's not a rectangle!");
        Rectangle rectangle = new Rectangle(-5.0, 10.0);
    }

    @Test
    public void testConstructorWithNegativeHeight() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("It's not a rectangle!");
        Rectangle rectangle = new Rectangle(5.0, -10.0);
    }

    @Test
    public void testConstructorWithZeroWidth() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("It's not a rectangle!");
        Rectangle rectangle = new Rectangle(0, 10.0);
    }

    @Test
    public void testConstructorWithZeroHeight() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("It's not a rectangle!");
        Rectangle rectangle = new Rectangle(5.0, 0);
    }

    @Test
    public void testArea() {
        assertEquals(50.0, rectangle.area(), 0.01);
    }

    @Test
    public void testPerimeter() {
        assertEquals(30.0, rectangle.perimeter(), 0.01);
    }

    @Test
    public void testToString() {
        assertEquals("Rectangle 5.0 10.0", rectangle.toString());
    }
}