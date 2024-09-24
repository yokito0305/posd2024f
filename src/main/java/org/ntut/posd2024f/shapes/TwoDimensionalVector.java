package org.ntut.posd2024f.shapes;

/**
 * The class TwoDimensionalVector is a vector in 2D space. 
 * It has two attributes, x and y, which are the coordinates of the vector. 
 */
public class TwoDimensionalVector {
    public int x;
    public int y;

    public TwoDimensionalVector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    public int dot(TwoDimensionalVector v) {
        return x * v.x + y * v.y;
    }

    public int cross(TwoDimensionalVector v) {
        return x * v.y - y * v.x;
    }

    public TwoDimensionalVector subtract(TwoDimensionalVector v) {
        return new TwoDimensionalVector(x - v.x, y - v.y);
    }
}