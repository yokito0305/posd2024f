package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class ShapeTest {
    @Test
    public void testShapeArea() {
        Circle circle = new Circle(3); // circle : area = 28.274, perimeter = 18.8495
        Rectangle rectangle = new Rectangle(4, 5); // rectangle : area = 20, perimeter = 18

        List<TwoDimensionalVector> vectors1 = new ArrayList<>();
        TwoDimensionalVector coord1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector coord2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector coord3 = new TwoDimensionalVector(1, 5);
        vectors1.add(coord1);
        vectors1.add(coord2);
        vectors1.add(coord3);
        Triangle triangle = new Triangle(vectors1); // triangle : area = 6, perimeter = 12

        List<TwoDimensionalVector> vectors2 = new ArrayList<>();
        TwoDimensionalVector coord4 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector coord5 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector coord6 = new TwoDimensionalVector(7, 4);
        TwoDimensionalVector coord7 = new TwoDimensionalVector(4, 7);
        TwoDimensionalVector coord8 = new TwoDimensionalVector(1, 7);
        vectors2.add(coord4);
        vectors2.add(coord5);
        vectors2.add(coord6);
        vectors2.add(coord7);
        vectors2.add(coord8);
        ConvexPolygon convexPolygon = new ConvexPolygon(vectors2); // convexPolygon : area = 27, perimeter = 3 + 6 + 3 + (2 * sqrt(18))


        List<Shape> shapes = new ArrayList<Shape>();
        shapes.add(circle);
        shapes.add(rectangle);
        shapes.add(triangle);
        shapes.add(convexPolygon);

        assertEquals(circle.area(), shapes.get(0).area());
        assertEquals(rectangle.area(), shapes.get(1).area());
        assertEquals(triangle.area(), shapes.get(2).area());
        assertEquals(convexPolygon.area(), shapes.get(3).area());
    }

    @Test
    public void testShapePerimeter() throws Exception {
        Circle circle = new Circle(3); // circle : area = 28.274, perimeter = 18.8495
        Rectangle rectangle = new Rectangle(4, 5); // rectangle : area = 20, perimeter = 18

        List<TwoDimensionalVector> vectors1 = new ArrayList<>();
        TwoDimensionalVector coord1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector coord2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector coord3 = new TwoDimensionalVector(1, 5);
        vectors1.add(coord1);
        vectors1.add(coord2);
        vectors1.add(coord3);
        Triangle triangle = new Triangle(vectors1); // triangle : area = 6, perimeter = 12

        List<TwoDimensionalVector> vectors2 = new ArrayList<>();
        TwoDimensionalVector coord4 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector coord5 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector coord6 = new TwoDimensionalVector(7, 4);
        TwoDimensionalVector coord7 = new TwoDimensionalVector(4, 7);
        TwoDimensionalVector coord8 = new TwoDimensionalVector(1, 7);
        vectors2.add(coord4);
        vectors2.add(coord5);
        vectors2.add(coord6);
        vectors2.add(coord7);
        vectors2.add(coord8);
        ConvexPolygon convexPolygon = new ConvexPolygon(vectors2); // convexPolygon : area = 27, perimeter = 3 + 6 + 3 + (2 * sqrt(18))


        List<Shape> shapes = new ArrayList<Shape>();
        shapes.add(circle);
        shapes.add(rectangle);
        shapes.add(triangle);
        shapes.add(convexPolygon);

        assertEquals(circle.perimeter(), shapes.get(0).perimeter());
        assertEquals(rectangle.perimeter(), shapes.get(1).perimeter());
        assertEquals(triangle.perimeter(), shapes.get(2).perimeter());
        assertEquals(convexPolygon.perimeter(), shapes.get(3).perimeter());
    }

    @Test
    public void testShapeAddWithCircleAddRectangle() {
        Shape circle = new Circle(3);
        Shape Rectangle = new Rectangle(3, 4);

        ShapeException exception = assertThrows(ShapeException.class, () -> {
            circle.add(Rectangle);
        });
        assertEquals("Illegal Operation", exception.getMessage());
    }

    @Test
    public void testShapeGetIterator() {
        Shape circle = new Circle(3);
        Iterator<Shape> iterator = circle.iterator();
        assertFalse(iterator.hasNext());
        NoSuchElementException exception =  assertThrows(NoSuchElementException.class, () -> {
            iterator.next();
        });
        assertEquals("Null iterator does not point to any element", exception.getMessage());
    }
}