package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

@SuppressWarnings("unused")
public class ShapeTest {
    private static Circle circle;
    private static Triangle triangle;
    private static Rectangle rectangle;
    private static ArrayList<Shape> shapes;

    @BeforeClass
    public static void setUp() throws Exception {
        // 初始化全域變數
        circle = new Circle(5.0); // area = 78.54 perimeter = 31.42
        triangle = new Triangle(3.0, 4.0, 5.0); // area = 6.0 perimeter = 12.0
        rectangle = new Rectangle(3.0, 4.0); // area = 12.0 perimeter = 14.0

        shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(triangle);
        shapes.add(rectangle);
    }

    @Test
    public void testByArea() throws Exception {
        assertEquals(circle.area(), shapes.get(0).area(), 0.01);
        assertEquals(triangle.area(), shapes.get(1).area(), 0.01);
        assertEquals(rectangle.area(), shapes.get(2).area(), 0.01);
    }

    @Test
    public void testByPerimeter() throws Exception {
        assertEquals(circle.perimeter(), shapes.get(0).perimeter(), 0.01);
        assertEquals(triangle.perimeter(), shapes.get(1).perimeter(), 0.01);
        assertEquals(rectangle.perimeter(), shapes.get(2).perimeter(), 0.01);
    }

    @Test
    public void testByToString() throws Exception {
        assertEquals(circle.toString(), shapes.get(0).toString());
        assertEquals(triangle.toString(), shapes.get(1).toString());
        assertEquals(rectangle.toString(), shapes.get(2).toString());
    }
}