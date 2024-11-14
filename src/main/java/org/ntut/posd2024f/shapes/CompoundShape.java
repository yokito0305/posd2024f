package org.ntut.posd2024f.shapes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompoundShape implements Shape {
    private List<Shape> list = new ArrayList<>();

    public CompoundShape() {
        list = new ArrayList<>();
    }

    @Override
    public double area() {
        double area = 0;
        for (Shape shape : list) {
            area += shape.area();
        }
        return area;
    }

    @Override
    public double perimeter() {
        double perimeter = 0;
        for (Shape shape : list) {
            perimeter += shape.perimeter();
        }
        return perimeter;
    }

    @Override
    public void add(Shape shape) {
        list.add(shape);
    }

    @Override
    public Iterator<Shape> iterator() {
        return list.iterator();
    }

    @Override
    public <T> void accept(Visitor<T> visitor) {
        visitor.visitCompoundShape(this);
    }
}
