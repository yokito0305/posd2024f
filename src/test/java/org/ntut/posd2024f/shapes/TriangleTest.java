package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

@SuppressWarnings("unused")
public class TriangleTest {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void testConstructor() throws ShapeException {
        TwoDimensionalVector side1 = new TwoDimensionalVector(3, 0);
        TwoDimensionalVector side2 = new TwoDimensionalVector(-3, 4);
        TwoDimensionalVector side3 = new TwoDimensionalVector(0, -4);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(side1);
        vectors.add(side2);
        vectors.add(side3);

        Triangle triangle = new Triangle(vectors);
    }

    @Test
    public void testConstructorWithOneSide() throws ShapeException {
        expectedEx.expect(ShapeException.class);
        expectedEx.expectMessage("It's not a triangle!");

        TwoDimensionalVector side1 = new TwoDimensionalVector(3, 0);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(side1);

        Triangle triangle = new Triangle(vectors);
    }

    @Test
    public void testConstructorWithZeroSide() throws ShapeException {
        expectedEx.expect(ShapeException.class);
        expectedEx.expectMessage("It's not a triangle!");

        TwoDimensionalVector side1 = new TwoDimensionalVector(0, 0);
        TwoDimensionalVector side2 = new TwoDimensionalVector(0, 0);
        TwoDimensionalVector side3 = new TwoDimensionalVector(0, 0);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(side1);
        vectors.add(side2);
        vectors.add(side3);

        Triangle triangle = new Triangle(vectors);
    }

    @Test
    public void testConstructorWithInvalidSide() throws ShapeException {
        expectedEx.expect(ShapeException.class);
        expectedEx.expectMessage("It's not a triangle!");

        TwoDimensionalVector side1 = new TwoDimensionalVector(3, 0);
        TwoDimensionalVector side2 = new TwoDimensionalVector(-3, 4);
        TwoDimensionalVector side3 = new TwoDimensionalVector(0, -1);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(side1);
        vectors.add(side2);
        vectors.add(side3);

        Triangle triangle = new Triangle(vectors);
    }

    @Test
    public void testConstructorWithParallelSide() throws ShapeException {
        expectedEx.expect(ShapeException.class);
        expectedEx.expectMessage("It's not a triangle!");

        TwoDimensionalVector side1 = new TwoDimensionalVector(3, 0);
        TwoDimensionalVector side2 = new TwoDimensionalVector(6, 0);
        TwoDimensionalVector side3 = new TwoDimensionalVector(4, 0);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(side1);
        vectors.add(side2);
        vectors.add(side3);

        Triangle triangle = new Triangle(vectors);
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

        Triangle triangle = new Triangle(vectors);
        assertEquals(12.0, triangle.perimeter(), 0.01);
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

        Triangle triangle = new Triangle(vectors);
        assertEquals(6.0, triangle.area(), 0.01);
    }
}