package org.ntut.posd2024f.shapes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompoundShape implements Shape {
    private List<Shape> shapes = new ArrayList<Shape>();

    public CompoundShape() {
    }
    
    public double area() {
        double area = 0;
        for (Shape shape : shapes) {
            area += shape.area();
        }

        return area;
    }

    public double perimeter() {
        double perimeter = 0;
        for (Shape shape : shapes) {
            perimeter += shape.perimeter();
        }

        return perimeter;
    }

    @Override
    public void add(Shape shape) {
        this.shapes.add(shape);
    }

    @Override
    public Iterator<Shape> iterator() {
        return shapes.iterator();
    }

    @Override
    public <T> void accept(Visitor<T> visitor) {
        visitor.visitCompoundShape(this);
    }
}
