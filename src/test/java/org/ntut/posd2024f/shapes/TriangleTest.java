package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

@SuppressWarnings("unused")
public class TriangleTest {
    @Test
    public void testConstructor() {
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
    public void testConstructorWithOneSide() {
        TwoDimensionalVector vector = new TwoDimensionalVector(3, 0);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector);

        ShapeException exception = assertThrows(ShapeException.class, () -> {
            Triangle triangle = new Triangle(vectors);
        });
        assertEquals("It's not a triangle!", exception.getMessage());
    }

    @Test
    public void testConstructorWithZeroSide(){
        TwoDimensionalVector vector1 = new TwoDimensionalVector(0, 0);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(0, 0);
        TwoDimensionalVector vector3 = new TwoDimensionalVector(0, 0);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);

        ShapeException exception = assertThrows(ShapeException.class, () -> {
            Triangle triangle = new Triangle(vectors);
        });
        assertEquals("It's not a triangle!", exception.getMessage());
    }

    @Test
    public void testConstructorWithPallarelSide() {
        TwoDimensionalVector vector1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector vector3 = new TwoDimensionalVector(7, 1);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);

        ShapeException exception = assertThrows(ShapeException.class, () -> {
            Triangle triangle = new Triangle(vectors);
        });
        assertEquals("It's not a triangle!", exception.getMessage());
    }

    @Test
    public void testPerimeter() {
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
    public void testArea() {
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

    @Test
    public void testGetVectors() {
        TwoDimensionalVector vector1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector vector3 = new TwoDimensionalVector(1, 5);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);

        Triangle triangle = new Triangle(vectors);
        assertEquals(vectors, triangle.getVectors());
    }
}