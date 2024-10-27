package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ConvexPolygonTest {
    @Test
    public void testConvexPolygonCreate() {
        List<TwoDimensionalVector> vectors = new ArrayList<TwoDimensionalVector>();
        TwoDimensionalVector v1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector v2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector v3 = new TwoDimensionalVector(7, 4);
        TwoDimensionalVector v4 = new TwoDimensionalVector(4, 7);
        TwoDimensionalVector v5 = new TwoDimensionalVector(1, 7);
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);
        vectors.add(v4);
        vectors.add(v5);

        new ConvexPolygon(vectors); // area = 27, perimeter = 3 + 6 + 3 + (2 * sqrt(18))
    }

    @Test
    public void testConvexGetVectors() {
        List<TwoDimensionalVector> vectors = new ArrayList<TwoDimensionalVector>();
        TwoDimensionalVector v1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector v2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector v3 = new TwoDimensionalVector(7, 4);
        TwoDimensionalVector v4 = new TwoDimensionalVector(4, 7);
        TwoDimensionalVector v5 = new TwoDimensionalVector(1, 7);
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);
        vectors.add(v4);
        vectors.add(v5);

        ConvexPolygon convexPolygon = new ConvexPolygon(vectors);
        assertEquals(vectors, convexPolygon.getVectors());
    }

    @Test
    public void testConvexPolygonCreateWithTwoVectors() {
        List<TwoDimensionalVector> vectors = new ArrayList<TwoDimensionalVector>();
        TwoDimensionalVector v1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector v2 = new TwoDimensionalVector(4, 1);
        vectors.add(v1);
        vectors.add(v2);

        ShapeException exception = assertThrows(ShapeException.class, () -> new ConvexPolygon(vectors));
        assertEquals("It's not a convex polygon!", exception.getMessage());
    }

    @Test
    public void testConvexPolygonWithNotOrdered() {
        List<TwoDimensionalVector> vectors = new ArrayList<TwoDimensionalVector>();
        TwoDimensionalVector v1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector v2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector v3 = new TwoDimensionalVector(7, 4);
        TwoDimensionalVector v4 = new TwoDimensionalVector(4, 7);
        TwoDimensionalVector v5 = new TwoDimensionalVector(1, 7);
        vectors.add(v1);
        vectors.add(v3);
        vectors.add(v2);
        vectors.add(v4);
        vectors.add(v5);

        ShapeException exception = assertThrows(ShapeException.class, () -> new ConvexPolygon(vectors));
        assertEquals("It's not a convex polygon!", exception.getMessage());
    }

    @Test
    public void testConvexPolygonWithNotConvex() {
        List<TwoDimensionalVector> vectors = new ArrayList<TwoDimensionalVector>();
        TwoDimensionalVector v1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector v2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector v3 = new TwoDimensionalVector(4, 7);
        TwoDimensionalVector v4 = new TwoDimensionalVector(7, 4);
        TwoDimensionalVector v5 = new TwoDimensionalVector(1, 7);
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);
        vectors.add(v4);
        vectors.add(v5);

        ShapeException exception = assertThrows(ShapeException.class, () -> new ConvexPolygon(vectors));
        assertEquals("It's not a convex polygon!", exception.getMessage());
    }

    @Test
    public void testConvexPolygonCreateWithCounterClockWise() {
        List<TwoDimensionalVector> vectors = new ArrayList<TwoDimensionalVector>();
        TwoDimensionalVector v1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector v2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector v3 = new TwoDimensionalVector(7, 4);
        TwoDimensionalVector v4 = new TwoDimensionalVector(4, 7);
        TwoDimensionalVector v5 = new TwoDimensionalVector(1, 7);
        vectors.add(v5);
        vectors.add(v4);
        vectors.add(v3);
        vectors.add(v2);
        vectors.add(v1);

        new ConvexPolygon(vectors); // area = 27, perimeter = 3 + 6 + 3 + (2 * sqrt(18))
    }

    @Test
    public void testConvexPolygonArea() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();

        TwoDimensionalVector coord1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector coord2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector coord3 = new TwoDimensionalVector(7, 4);
        TwoDimensionalVector coord4 = new TwoDimensionalVector(4, 7);
        TwoDimensionalVector coord5 = new TwoDimensionalVector(1, 7);

        vectors.add(coord1);
        vectors.add(coord2);
        vectors.add(coord3);
        vectors.add(coord4);
        vectors.add(coord5);

        ConvexPolygon convexPolygon = new ConvexPolygon(vectors); // area = 27, perimeter = 3 + 6 + 3 + (2 * sqrt(18))
        assertEquals(27, convexPolygon.area(), 0.01);
    }

    @Test
    public void testConvexPolygonPerimeter() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();

        TwoDimensionalVector coord1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector coord2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector coord3 = new TwoDimensionalVector(7, 4);
        TwoDimensionalVector coord4 = new TwoDimensionalVector(4, 7);
        TwoDimensionalVector coord5 = new TwoDimensionalVector(1, 7);

        vectors.add(coord1);
        vectors.add(coord2);
        vectors.add(coord3);
        vectors.add(coord4);
        vectors.add(coord5);

        ConvexPolygon convexPolygon = new ConvexPolygon(vectors); // area = 27, perimeter = 3 + 6 + 3 + (2 * sqrt(18))
        double perimeter = 3 + 6 + 3 + 2 * Math.sqrt(18);
        assertEquals(perimeter, convexPolygon.perimeter(), 0.01);
    }
}