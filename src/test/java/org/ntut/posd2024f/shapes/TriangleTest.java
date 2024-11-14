package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TriangleTest {
    @Test
    public void testTriangleCreate() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        TwoDimensionalVector v1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector v2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector v3 = new TwoDimensionalVector(1, 5);
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);

        new Triangle(vectors); // area = 6, perimeter = 12
    }

    @Test
    public void testTriangleCreateWithTwoVectors() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        TwoDimensionalVector v1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector v2 = new TwoDimensionalVector(4, 1);
        vectors.add(v1);
        vectors.add(v2);

        ShapeException exception = assertThrows(ShapeException.class, () -> new Triangle(vectors));
        assertEquals("It's not a triangle!", exception.getMessage());
    }

    @Test
    public void testTriangleCreateWithThreeVectorsOnSameLine() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        TwoDimensionalVector v1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector v2 = new TwoDimensionalVector(2, 2);
        TwoDimensionalVector v3 = new TwoDimensionalVector(3, 3);
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);

        ShapeException exception = assertThrows(ShapeException.class, () -> new Triangle(vectors));
        assertEquals("It's not a triangle!", exception.getMessage());
    }

    @Test
    public void testTriangleCreateWithThreeVectorsOnSamePoint() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        TwoDimensionalVector v1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector v2 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector v3 = new TwoDimensionalVector(1, 1);
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);

        ShapeException exception = assertThrows(ShapeException.class, () -> new Triangle(vectors));
        assertEquals("It's not a triangle!", exception.getMessage());
    }

    @Test
    public void testTriangleArea() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        TwoDimensionalVector v1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector v2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector v3 = new TwoDimensionalVector(1, 5);
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);

        Triangle triangle = new Triangle(vectors); // area = 6
        assertEquals(6, triangle.area());
    }

    @Test
    public void testTrianglePerimeter() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        TwoDimensionalVector v1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector v2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector v3 = new TwoDimensionalVector(1, 5);
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);

        Triangle triangle = new Triangle(vectors); // perimeter = 12
        assertEquals(12, triangle.perimeter());
    }

    @Test
    public void testTriangleGetVectors() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        TwoDimensionalVector v1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector v2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector v3 = new TwoDimensionalVector(1, 5);
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);

        Triangle triangle = new Triangle(vectors);
        assertEquals(vectors, triangle.getVectors());
    }
}