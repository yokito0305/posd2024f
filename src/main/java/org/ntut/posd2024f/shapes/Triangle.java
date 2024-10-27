package org.ntut.posd2024f.shapes;

import java.util.List;

public class Triangle implements Shape {
    private List<TwoDimensionalVector> vectors;
    private double side1;
    private double side2;
    private double side3;

    public Triangle(List<TwoDimensionalVector> vectors) {
        if (vectors.size() != 3) {
            throw new ShapeException("It's not a triangle!");
        }
        this.vectors = vectors;

        this.side1 = vectors.get(1).subtract(vectors.get(0)).length();
        this.side2 = vectors.get(2).subtract(vectors.get(1)).length();
        this.side3 = vectors.get(0).subtract(vectors.get(2)).length();
        if ((side1 + side2) <= side3 || (side2 + side3) <= side1 || (side3 + side1) <= side2) {
            throw new ShapeException("It's not a triangle!");
        }
    }

    @Override
    public double area() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public double perimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public <T> void accept(Visitor<T> visitor) {
        visitor.visitTriangle(this);
    }

    public List<TwoDimensionalVector> getVectors() {
        return vectors;
    }
}
