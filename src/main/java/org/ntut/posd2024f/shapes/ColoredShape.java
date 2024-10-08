package org.ntut.posd2024f.shapes;

import java.util.Iterator;

public class ColoredShape implements Shape {
    private Shape _shape;
    private String _color;

    public ColoredShape(Shape shape, String color) {
        _color = color;
        _shape = shape;
    }

    @Override
    public double area() {
        return _shape.area();
    }

    @Override
    public double perimeter() {
        return _shape.perimeter();
    }

    @Override
    public void add(Shape shape) {
        _shape.add(shape);
    }

    @Override
    public Iterator<Shape> iterator() {
        return _shape.iterator();
    }

    public Shape getShape() {
        return _shape;
    }

    public String getColor() {
        return _color;
    }

    @Override
    public <T> void accept(Visitor<T> visitor) {
        visitor.visitColoredShape(this);
    }
}
