package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TwoDimensionalVectorTest {
    @Test
    public void testLength() {
        TwoDimensionalVector v = new TwoDimensionalVector(3, 4);
        assertEquals(5, v.length(), 0.001);
    }

    @Test
    public void testDot() {
        TwoDimensionalVector v1 = new TwoDimensionalVector(3, 4);
        TwoDimensionalVector v2 = new TwoDimensionalVector(5, 6);
        assertEquals(39, v1.dot(v2));
    }

    @Test
    public void testCross() {
        TwoDimensionalVector v1 = new TwoDimensionalVector(3, 4);
        TwoDimensionalVector v2 = new TwoDimensionalVector(5, 6);
        assertEquals(-2, v1.cross(v2));
    }

    @Test
    public void testSubtract() {
        TwoDimensionalVector v1 = new TwoDimensionalVector(3, 4);
        TwoDimensionalVector v2 = new TwoDimensionalVector(5, 6);
        TwoDimensionalVector v3 = v1.subtract(v2);
        assertEquals(-2, v3.x);
        assertEquals(-2, v3.y);
    }
}