package org.ntut.posd2024f.shapes;

import java.util.Iterator;

public class TextedShape implements Shape {
    private Shape _shape;
    private String _text;

    public TextedShape(Shape shape, String text) {
        this._text = text;
        this._shape = shape;
    }

    @Override
    public double area() {
        return this._shape.area();
    }

    @Override
    public double perimeter() {
        return _shape.perimeter();
    }
    
    @Override
    public void add(Shape shape) {
        this._shape.add(shape);
    }

    @Override
    public Iterator<Shape> iterator() {
        return _shape.iterator();
    }

    public Shape getShape() {
        return _shape;
    }

    public String getText() {
        return _text;
    }

    @Override
    public <T> void accept(Visitor<T> visitor) {
        visitor.visitTextedShape(this);
    }
}
