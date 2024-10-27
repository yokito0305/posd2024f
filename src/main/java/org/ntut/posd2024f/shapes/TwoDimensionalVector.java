package org.ntut.posd2024f.shapes;

public class TwoDimensionalVector {
    private int x;
    private int y;

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

    @Override
    public String toString() {
        return "[" + x + "," + y + "]";
    }
}