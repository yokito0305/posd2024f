package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class SortTest {
    @Test
    public void testSortByAreaAscending() {
        Shape circle = new Circle(3); // circle : area = 28.274, perimeter = 18.8495
        Shape rectangle = new Rectangle(3, 4); // rectangle : area = 12, perimeter = 14
        assertTrue(Sort.BY_AREA_ASCENDING.compare(circle, rectangle) > 0);

        ArrayList<Shape> shapes = new ArrayList<Shape>();
        shapes.add(circle);
        shapes.add(rectangle);
        shapes.sort(Sort.BY_AREA_ASCENDING);
        assertEquals(rectangle, shapes.get(0));
        assertEquals(circle, shapes.get(1));
    }

    @Test
    public void testSortByAreaDescending() {
        Shape circle = new Circle(3); // circle : area = 28.274, perimeter = 18.8495
        Shape rectangle = new Rectangle(3, 4); // rectangle : area = 12, perimeter = 14
        assertTrue(Sort.BY_AREA_DESCENDING.compare(circle, rectangle) < 0);

        ArrayList<Shape> shapes = new ArrayList<Shape>();
        shapes.add(circle);
        shapes.add(rectangle);
        shapes.sort(Sort.BY_AREA_DESCENDING);
        assertEquals(circle, shapes.get(0));
        assertEquals(rectangle, shapes.get(1));
    }

    @Test
    public void testSortByPerimeterAscending() {
        Shape circle = new Circle(3); // circle : area = 28.274, perimeter = 18.8495
        Shape rectangle = new Rectangle(3, 4); // rectangle : area = 12, perimeter = 14
        assertTrue(Sort.BY_PERIMETER_ASCENDING.compare(circle, rectangle) > 0);

        ArrayList<Shape> shapes = new ArrayList<Shape>();
        shapes.add(circle);
        shapes.add(rectangle);
        shapes.sort(Sort.BY_PERIMETER_ASCENDING);
        assertEquals(rectangle, shapes.get(0));
        assertEquals(circle, shapes.get(1));
    }

    @Test
    public void testSortByPerimeterDescending() {
        Shape circle = new Circle(3); // circle : area = 28.274, perimeter = 18.8495
        Shape rectangle = new Rectangle(3, 4); // rectangle : area = 12, perimeter = 14
        assertTrue(Sort.BY_PERIMETER_DESCENDING.compare(circle, rectangle) < 0);

        ArrayList<Shape> shapes = new ArrayList<Shape>();
        shapes.add(circle);
        shapes.add(rectangle);
        shapes.sort(Sort.BY_PERIMETER_DESCENDING);
        assertEquals(circle, shapes.get(0));
        assertEquals(rectangle, shapes.get(1));
    }
}