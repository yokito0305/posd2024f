package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

@SuppressWarnings("unused")
public class ConvexPolygonTest {
    @Rule
    public ExpectedException expectEx = ExpectedException.none();

    @Test
    public void testConstructor() throws ShapeException {
        TwoDimensionalVector side1 = new TwoDimensionalVector(3, 0);
        TwoDimensionalVector side2 = new TwoDimensionalVector(-3, 4);
        TwoDimensionalVector side3 = new TwoDimensionalVector(0, -4);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(side1);
        vectors.add(side2);
        vectors.add(side3);

    }

    @Test
    public void testConstructorWithClockwiseDirection() throws ShapeException {
        TwoDimensionalVector side1 = new TwoDimensionalVector(0, 4);
        TwoDimensionalVector side2 = new TwoDimensionalVector(3, -4);
        TwoDimensionalVector side3 = new TwoDimensionalVector(-3, 0);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(side1);
        vectors.add(side2);
        vectors.add(side3);

        ConvexPolygon convexPolygon = new ConvexPolygon(vectors);
    }

    @Test
    public void testConstructorWithCounterclockwiseDirection() throws ShapeException {
        TwoDimensionalVector side1 = new TwoDimensionalVector(3, 0);
        TwoDimensionalVector side2 = new TwoDimensionalVector(-3, 4);
        TwoDimensionalVector side3 = new TwoDimensionalVector(0, -4);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(side1);
        vectors.add(side2);
        vectors.add(side3);

        ConvexPolygon convexPolygon = new ConvexPolygon(vectors);
    }

    @Test
    public void testConstructorWithTwoVectors() throws ShapeException {
        expectEx.expect(ShapeException.class);
        expectEx.expectMessage("It's not a convex polygon!");

        TwoDimensionalVector side1 = new TwoDimensionalVector(3, 0);
        TwoDimensionalVector side2 = new TwoDimensionalVector(-3, 4);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(side1);
        vectors.add(side2);

        ConvexPolygon convexPolygon = new ConvexPolygon(vectors);
    }

    @Test
    public void testConstructorWithUnsortedVectors() throws ShapeException {
        expectEx.expect(ShapeException.class);
        expectEx.expectMessage("It's not a convex polygon!");

        TwoDimensionalVector side1 = new TwoDimensionalVector(3, 0);
        TwoDimensionalVector side2 = new TwoDimensionalVector(0, -4);
        TwoDimensionalVector side3 = new TwoDimensionalVector(3, 4);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(side1);
        vectors.add(side3);
        vectors.add(side2);

        ConvexPolygon convexPolygon = new ConvexPolygon(vectors);
    }

    @Test
    public void testArea() throws ShapeException {
        TwoDimensionalVector side1 = new TwoDimensionalVector(3, 0);
        TwoDimensionalVector side2 = new TwoDimensionalVector(-3, 4);
        TwoDimensionalVector side3 = new TwoDimensionalVector(0, -4);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(side1);
        vectors.add(side2);
        vectors.add(side3);

        ConvexPolygon convexPolygon = new ConvexPolygon(vectors);
        assertEquals(12.0, convexPolygon.area(), 0.01);
    }

    @Test
    public void testAreaWithRectangle() throws ShapeException {
        TwoDimensionalVector side1 = new TwoDimensionalVector(3, 0);
        TwoDimensionalVector side2 = new TwoDimensionalVector(0, 4);
        TwoDimensionalVector side3 = new TwoDimensionalVector(-3, 0);
        TwoDimensionalVector side4 = new TwoDimensionalVector(0, -4);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(side1);
        vectors.add(side2);
        vectors.add(side3);
        vectors.add(side4);

        ConvexPolygon convexPolygon = new ConvexPolygon(vectors);
        assertEquals(12.0, convexPolygon.area(), 0.01);
    }

    @Test
    public void testPerimeter() throws ShapeException {
        TwoDimensionalVector side1 = new TwoDimensionalVector(3, 0);
        TwoDimensionalVector side2 = new TwoDimensionalVector(-3, 4);
        TwoDimensionalVector side3 = new TwoDimensionalVector(0, -4);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(side1);
        vectors.add(side2);
        vectors.add(side3);

        ConvexPolygon convexPolygon = new ConvexPolygon(vectors);
        assertEquals(12.0, convexPolygon.perimeter(), 0.01);
    }

    @Test
    public void testPerimeterWithRectangle() throws ShapeException {
        TwoDimensionalVector side1 = new TwoDimensionalVector(3, 0);
        TwoDimensionalVector side2 = new TwoDimensionalVector(0, 4);
        TwoDimensionalVector side3 = new TwoDimensionalVector(-3, 0);
        TwoDimensionalVector side4 = new TwoDimensionalVector(0, -4);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(side1);
        vectors.add(side2);
        vectors.add(side3);
        vectors.add(side4);

        ConvexPolygon convexPolygon = new ConvexPolygon(vectors);
        assertEquals(14.0, convexPolygon.perimeter(), 0.01);
    }
}