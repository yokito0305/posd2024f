package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TwoDimensionalVectorTest {
    @Test
    public void testTwoDimensionalVectorCreate() {
        new TwoDimensionalVector(3, 4);
    }

    @Test
    public void testTwoDimensionalVectorLength() {
        TwoDimensionalVector vector = new TwoDimensionalVector(3, 4);
        assertEquals(5, vector.length());
    }

    @Test
    public void testTwoDimensionalVectorDot() {
        TwoDimensionalVector vector1 = new TwoDimensionalVector(3, 4);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(5, 6);
        assertEquals(39, vector1.dot(vector2));
    }

    @Test
    public void testTwoDimensionalVectorCross() {
        TwoDimensionalVector vector1 = new TwoDimensionalVector(3, 4);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(5, 6);
        assertEquals(-2, vector1.cross(vector2));
    }

    @Test
    public void testTwoDimensionalVectorSubtract() {
        TwoDimensionalVector vector1 = new TwoDimensionalVector(3, 4);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(5, 6);
        TwoDimensionalVector result = vector1.subtract(vector2); // (-2, -2)
        double length = Math.sqrt(8);
        assertEquals(length , result.length());
    }

    @Test
    public void testTwoDimensionalVectorToString() {
        TwoDimensionalVector vector = new TwoDimensionalVector(3, 4);
        assertEquals("[3,4]", vector.toString());
    }
}