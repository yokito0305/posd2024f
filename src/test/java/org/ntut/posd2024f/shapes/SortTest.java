package org.ntut.posd2024f.shapes;

import java.util.ArrayList;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class SortTest {
    private static Circle circle;
    private static Rectangle rectangle;
    private static Triangle triangle;
    private static ArrayList<Shape> shapes;

    @BeforeClass
    public static void setUp() throws Exception {
        circle = new Circle(5.0); // area = 78.54, perimeter = 31.42
        rectangle = new Rectangle(5.0, 10.0); // area = 50.0, perimeter = 30.0
        triangle = new Triangle(2.0, 3.0, 4.0); // area = 2.9047, perimeter = 9.0
        shapes = new ArrayList<Shape>();
        shapes.add(circle);
        shapes.add(rectangle);
        shapes.add(triangle);
    }

    /////////////////////////// Test Sort ///////////////////////////
    @Test
    public void testByAreaAscendingCompare() throws Exception {
        Circle circle = new Circle(5.0); // area = 78.54
        Circle circle2 = new Circle(10.0); // area = 314.16

        assertTrue(Sort.BY_AREA_ASCENDING.compare(circle, circle2) < 0);
        assertTrue(Sort.BY_AREA_ASCENDING.compare(circle2, circle) > 0);
        assertEquals(0, Sort.BY_AREA_ASCENDING.compare(circle, circle));
    }

    @Test
    public void testByAreaDescendingCompare() throws Exception {
        Circle circle = new Circle(5.0); // area = 78.54
        Circle circle2 = new Circle(10.0); // area = 314.16

        assertTrue(Sort.BY_AREA_DESCENDING.compare(circle, circle2) > 0);
        assertTrue(Sort.BY_AREA_DESCENDING.compare(circle2, circle) < 0);
        assertEquals(0, Sort.BY_AREA_DESCENDING.compare(circle, circle));
    }

    @Test
    public void testByPerimeterAscendingCompare() throws Exception {
        Circle circle = new Circle(5.0); // perimeter = 31.42
        Circle circle2 = new Circle(10.0); // perimeter = 62.83

        assertTrue(Sort.BY_PERIMETER_ASCENDING.compare(circle, circle2) < 0);
        assertTrue(Sort.BY_PERIMETER_ASCENDING.compare(circle2, circle) > 0);
        assertEquals(0, Sort.BY_PERIMETER_ASCENDING.compare(circle, circle));
    }

    @Test
    public void testByPerimeterDescendingCompare() throws Exception {
        Circle circle = new Circle(5.0); // perimeter = 31.42
        Circle circle2 = new Circle(10.0); // perimeter = 62.83

        assertTrue(Sort.BY_PERIMETER_DESCENDING.compare(circle, circle2) > 0);
        assertTrue(Sort.BY_PERIMETER_DESCENDING.compare(circle2, circle) < 0);
        assertEquals(0, Sort.BY_PERIMETER_DESCENDING.compare(circle, circle));
    }

    /////////////////////////// Test HandleSort ///////////////////////////
    @Test
    public void testHandleSortByInvalidArgs() throws Exception {
        shapes = new InputOutput().handleSort(shapes, "invalid", "invalid");
        assertEquals(circle, shapes.get(0));
        assertEquals(rectangle, shapes.get(1));
        assertEquals(triangle, shapes.get(2));
    }

    @Test
    public void testHandleSortByAreaAscending() throws Exception {
        shapes = new InputOutput().handleSort(shapes, "area", "inc");
        assertEquals(triangle, shapes.get(0));
        assertEquals(rectangle, shapes.get(1));
        assertEquals(circle, shapes.get(2));
    }

    @Test
    public void testHandleSortByAreaDescending() throws Exception {
        shapes = new InputOutput().handleSort(shapes, "area", "dec");
        assertEquals(circle, shapes.get(0));
        assertEquals(rectangle, shapes.get(1));
        assertEquals(triangle, shapes.get(2));
    }

    @Test
    public void testHandleSortByPerimeterAscending() throws Exception {
        shapes = new InputOutput().handleSort(shapes, "perimeter", "inc");
        assertEquals(triangle, shapes.get(0));
        assertEquals(rectangle, shapes.get(1));
        assertEquals(circle, shapes.get(2));
    }

    @Test
    public void testHandleSortByPerimeterDescending() throws Exception {
        shapes = new InputOutput().handleSort(shapes, "perimeter", "dec");
        assertEquals(circle, shapes.get(0));
        assertEquals(rectangle, shapes.get(1));
        assertEquals(triangle, shapes.get(2));
    }
}