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
        TwoDimensionalVector vector1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector vector3 = new TwoDimensionalVector(1, 5);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);
        
        Triangle triangle = new Triangle(vectors);
    }

    @Test
    public void testConstructorWithOneSide() throws ShapeException {
        expectedEx.expect(ShapeException.class);
        expectedEx.expectMessage("It's not a triangle!");

        TwoDimensionalVector vector = new TwoDimensionalVector(3, 0);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector);

        Triangle triangle = new Triangle(vectors);
    }

    @Test
    public void testConstructorWithZeroSide() throws ShapeException {
        expectedEx.expect(ShapeException.class);
        expectedEx.expectMessage("It's not a triangle!");

        TwoDimensionalVector vector1 = new TwoDimensionalVector(0, 0);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(0, 0);
        TwoDimensionalVector vector3 = new TwoDimensionalVector(0, 0);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);

        Triangle triangle = new Triangle(vectors);
    }

    @Test
    public void testConstructorWithPallarelSide() throws ShapeException {
        expectedEx.expect(ShapeException.class);
        expectedEx.expectMessage("It's not a triangle!");

        TwoDimensionalVector vector1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector vector3 = new TwoDimensionalVector(7, 1);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);

        Triangle triangle = new Triangle(vectors);
    }

    @Test
    public void testPerimeter() throws ShapeException {
        TwoDimensionalVector vector1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector vector3 = new TwoDimensionalVector(1, 5);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);

        Triangle triangle = new Triangle(vectors);
        assertEquals(12.0, triangle.perimeter(), 0.01);
    }

    @Test
    public void testArea() throws ShapeException {
        TwoDimensionalVector vector1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector vector3 = new TwoDimensionalVector(1, 5);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);

        Triangle triangle = new Triangle(vectors);
        assertEquals(6.0, triangle.area(), 0.01);
    }
}