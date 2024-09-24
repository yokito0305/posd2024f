package org.ntut.posd2024f.shapes;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) throws ShapeException {
        if (radius <= 0) {
            throw new ShapeException("It's not a circle!");
        }
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    } 

    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}
