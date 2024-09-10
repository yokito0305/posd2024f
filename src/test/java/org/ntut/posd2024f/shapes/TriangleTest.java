package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

@SuppressWarnings("unused")
public class TriangleTest {
    private static Triangle triangle;

    @BeforeClass
    public static void setUp() throws Exception {
        // 初始化全域變數
        triangle = new Triangle(3.0, 4.0, 5.0);
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
    public void testArea() {
        assertEquals(6.0, triangle.area(), 0.01);
    }

    @Test
    public void testPerimeter() {
        assertEquals(12.0, triangle.perimeter(), 0.01);
    }

    @Test
    public void testToString() {
        assertEquals("Triangle 3.0 4.0 5.0", triangle.toString());
    }
}