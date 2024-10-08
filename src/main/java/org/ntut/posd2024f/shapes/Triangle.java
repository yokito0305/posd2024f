package org.ntut.posd2024f.shapes;

import java.util.List;

public class Triangle implements Shape{
    private List<TwoDimensionalVector> vectors;
    private double side1;
    private double side2;
    private double side3;

    Triangle(List<TwoDimensionalVector> vectors) throws ShapeException {
        if (vectors.size() != 3) {
            throw new ShapeException("It's not a triangle!");
        }

        this.vectors = vectors;
        this.side1 = vectors.get(0).subtract(vectors.get(1)).length(); // side1 = |vector1 - vector2|
        this.side2 = vectors.get(1).subtract(vectors.get(2)).length(); // side2 = |vector2 - vector3|
        this.side3 = vectors.get(2).subtract(vectors.get(0)).length(); // side3 = |vector3 - vector1|

        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            throw new ShapeException("It's not a triangle!");
        }
    }

    public double area() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

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
