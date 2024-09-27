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
        TwoDimensionalVector vector1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector vector3 = new TwoDimensionalVector(6, 3);
        TwoDimensionalVector vector4 = new TwoDimensionalVector(4, 5);
        TwoDimensionalVector vector5 = new TwoDimensionalVector(1, 5);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);
        vectors.add(vector4);
        vectors.add(vector5);
        
        ConvexPolygon convexPolygon = new ConvexPolygon(vectors);

    }

    @Test
    public void testConstructorWithTwoPallarelVector() throws ShapeException {
        TwoDimensionalVector vector1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(2, 1);
        TwoDimensionalVector vector3 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector vector4 = new TwoDimensionalVector(6, 3);
        TwoDimensionalVector vector5 = new TwoDimensionalVector(4, 5);
        TwoDimensionalVector vector6 = new TwoDimensionalVector(1, 5);
        TwoDimensionalVector vector7 = new TwoDimensionalVector(1, 4);


        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);
        vectors.add(vector4);
        vectors.add(vector5);
        vectors.add(vector6);
        vectors.add(vector7);
        
        ConvexPolygon convexPolygon = new ConvexPolygon(vectors);

    }

    @Test
    public void testConstructorWithClockwiseDirection() throws ShapeException {
        TwoDimensionalVector vector1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(1, 5);
        TwoDimensionalVector vector3 = new TwoDimensionalVector(4, 5);
        TwoDimensionalVector vector4 = new TwoDimensionalVector(6, 3);
        TwoDimensionalVector vector5 = new TwoDimensionalVector(4, 1);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);
        vectors.add(vector4);
        vectors.add(vector5);
        
        ConvexPolygon convexPolygon = new ConvexPolygon(vectors);
    }

    @Test
    public void testConstructorWithCounterclockwiseDirection() throws ShapeException {
        TwoDimensionalVector vector1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector vector3 = new TwoDimensionalVector(6, 3);
        TwoDimensionalVector vector4 = new TwoDimensionalVector(4, 5);
        TwoDimensionalVector vector5 = new TwoDimensionalVector(1, 5);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);
        vectors.add(vector4);
        vectors.add(vector5);
        
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

        TwoDimensionalVector vector1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector vector3 = new TwoDimensionalVector(4, 5);
        TwoDimensionalVector vector4 = new TwoDimensionalVector(6, 3);
        TwoDimensionalVector vector5 = new TwoDimensionalVector(1, 5);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);
        vectors.add(vector4);
        vectors.add(vector5);

        ConvexPolygon convexPolygon = new ConvexPolygon(vectors);
    }

    @Test
    public void testConstructorWithNotConvexPolygon() throws ShapeException {
        expectEx.expect(ShapeException.class);
        expectEx.expectMessage("It's not a convex polygon!");

        TwoDimensionalVector vector1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector vector3 = new TwoDimensionalVector(3, 3);
        TwoDimensionalVector vector4 = new TwoDimensionalVector(4, 5);
        TwoDimensionalVector vector5 = new TwoDimensionalVector(1, 5);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);
        vectors.add(vector4);
        vectors.add(vector5);

        ConvexPolygon convexPolygon = new ConvexPolygon(vectors);
    }

    @Test
    public void testArea() throws ShapeException {
        TwoDimensionalVector vector1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector vector3 = new TwoDimensionalVector(6, 3);
        TwoDimensionalVector vector4 = new TwoDimensionalVector(4, 5);
        TwoDimensionalVector vector5 = new TwoDimensionalVector(1, 5);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);
        vectors.add(vector4);
        vectors.add(vector5);

        ConvexPolygon convexPolygon = new ConvexPolygon(vectors);
        assertEquals(16.0, convexPolygon.area(), 0.01);
    }

    @Test
    public void testPerimeter() throws ShapeException {
        TwoDimensionalVector vector1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector vector3 = new TwoDimensionalVector(6, 3);
        TwoDimensionalVector vector4 = new TwoDimensionalVector(4, 5);
        TwoDimensionalVector vector5 = new TwoDimensionalVector(1, 5);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);
        vectors.add(vector4);
        vectors.add(vector5);

        ConvexPolygon convexPolygon = new ConvexPolygon(vectors);
        assertEquals(15.66, convexPolygon.perimeter(), 0.01);
    }
}