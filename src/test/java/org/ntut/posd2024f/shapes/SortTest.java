package org.ntut.posd2024f.shapes;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortTest {
    @Test
    public void testByAreaAscending() throws Exception {
        Circle circle = new Circle(3.0); // area = 28.27
        Triangle triangle = new Triangle(3.0, 4.0, 5.0); // area = 6.0
        Rectangle rectangle = new Rectangle(3.0, 4.0); // area = 12.0

        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(triangle);
        shapes.add(rectangle);

        Collections.sort(shapes, Sort.BY_AREA_ASCENDING);

        assertEquals(triangle, shapes.get(0));
        assertEquals(rectangle, shapes.get(1));
        assertEquals(circle, shapes.get(2));
    }

    @Test
    public void testByAreaDescending() throws Exception {
        Circle circle = new Circle(3.0); // area = 28.27
        Triangle triangle = new Triangle(3.0, 4.0, 5.0); // area = 6.0
        Rectangle rectangle = new Rectangle(3.0, 4.0); // area = 12.0

        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(triangle);
        shapes.add(rectangle);

        Collections.sort(shapes, Sort.BY_AREA_DESCENDING);

        assertEquals(circle, shapes.get(0));
        assertEquals(rectangle, shapes.get(1));
        assertEquals(triangle, shapes.get(2));
    }

    @Test
    public void testByPerimeterAscending() throws Exception {
        Circle circle = new Circle(3.0); // perimeter = 18.85
        Triangle triangle = new Triangle(3.0, 4.0, 5.0); // perimeter = 12.0
        Rectangle rectangle = new Rectangle(3.0, 4.0); // perimeter = 14.0

        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(triangle);
        shapes.add(rectangle);

        Collections.sort(shapes, Sort.BY_PERIMETER_ASCENDING);

        assertEquals(triangle, shapes.get(0));
        assertEquals(rectangle, shapes.get(1));
        assertEquals(circle, shapes.get(2));
    }

    @Test
    public void testByPerimeterDescending() throws Exception {
        Circle circle = new Circle(3.0); // perimeter = 18.85
        Triangle triangle = new Triangle(3.0, 4.0, 5.0); // perimeter = 12.0
        Rectangle rectangle = new Rectangle(3.0, 4.0); // perimeter = 14.0

        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(triangle);
        shapes.add(rectangle);

        Collections.sort(shapes, Sort.BY_PERIMETER_DESCENDING);

        assertEquals(circle, shapes.get(0));
        assertEquals(rectangle, shapes.get(1));
        assertEquals(triangle, shapes.get(2));
    }

    // Test InputOutput.java handleSort method
    @Test
    public void testHandleSortByAreaAscending() throws Exception {
        Circle circle = new Circle(3.0); // area = 28.27
        Triangle triangle = new Triangle(3.0, 4.0, 5.0); // area = 6.0
        Rectangle rectangle = new Rectangle(3.0, 4.0); // area = 12.0

        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(triangle);
        shapes.add(rectangle);

        InputOutput io = new InputOutput();
        shapes = io.handleSort(shapes, "area", "inc");

        assertEquals(triangle, shapes.get(0));
        assertEquals(rectangle, shapes.get(1));
        assertEquals(circle, shapes.get(2));
    }

    @Test
    public void testHandleSortByAreaDescending() throws Exception {
        Circle circle = new Circle(3.0); // area = 28.27
        Triangle triangle = new Triangle(3.0, 4.0, 5.0); // area = 6.0
        Rectangle rectangle = new Rectangle(3.0, 4.0); // area = 12.0

        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(triangle);
        shapes.add(rectangle);

        InputOutput io = new InputOutput();
        shapes = io.handleSort(shapes, "area", "dec");

        assertEquals(circle, shapes.get(0));
        assertEquals(rectangle, shapes.get(1));
        assertEquals(triangle, shapes.get(2));
    }

    @Test
    public void testHandleSortByPerimeterAscending() throws Exception {
        Circle circle = new Circle(3.0); // perimeter = 18.85
        Triangle triangle = new Triangle(3.0, 4.0, 5.0); // perimeter = 12.0
        Rectangle rectangle = new Rectangle(3.0, 4.0); // perimeter = 14.0

        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(triangle);
        shapes.add(rectangle);

        InputOutput io = new InputOutput();
        shapes = io.handleSort(shapes, "perimeter", "inc");

        assertEquals(triangle, shapes.get(0));
        assertEquals(rectangle, shapes.get(1));
        assertEquals(circle, shapes.get(2));
    }

    @Test
    public void testHandleSortByPerimeterDescending() throws Exception {
        Circle circle = new Circle(3.0); // perimeter = 18.85
        Triangle triangle = new Triangle(3.0, 4.0, 5.0); // perimeter = 12.0
        Rectangle rectangle = new Rectangle(3.0, 4.0); // perimeter = 14.0

        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(triangle);
        shapes.add(rectangle);

        InputOutput io = new InputOutput();
        shapes = io.handleSort(shapes, "perimeter", "dec");

        assertEquals(circle, shapes.get(0));
        assertEquals(rectangle, shapes.get(1));
        assertEquals(triangle, shapes.get(2));
    }
}