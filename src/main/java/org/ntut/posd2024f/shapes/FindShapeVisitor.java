package org.ntut.posd2024f.shapes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class FindShapeVisitor implements Visitor<List<Shape>> {
    List<Shape> shapes;
    Predicate<Shape> condition;

    public FindShapeVisitor(Predicate<Shape> condition) {
        this.shapes = new ArrayList<>();
        this.condition = condition;
    }

    @Override
    public void visitCircle(Circle circle) {
        if (condition.test(circle)) {
            shapes.add(circle);
        }
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        if (condition.test(rectangle)) {
            shapes.add(rectangle);
        }
    }

    @Override
    public void visitTriangle(Triangle triangle) {
        if (condition.test(triangle)) {
            shapes.add(triangle);
        }
    }

    @Override
    public void visitConvexPolygon(ConvexPolygon convexPolygon) {
        if (condition.test(convexPolygon)) {
            shapes.add(convexPolygon);
        }
    }

    @Override
    public void visitCompoundShape(CompoundShape compoundShape) {
        if (condition.test(compoundShape)) {
            shapes.add(compoundShape);
        }
        Iterator<Shape> it = compoundShape.iterator();
        while (it.hasNext()) {
            Shape shape = it.next();
            shape.accept(this);
        }
    }

    @Override
    public void visitTextedShape(TextedShape textedShape) {
        if (condition.test(textedShape)) {
            shapes.add(textedShape);
        }
        Shape shape = textedShape.getShape();
        shape.accept(this);
    }

    @Override
    public void visitColoredShape(ColoredShape coloredShape) {
        if (condition.test(coloredShape)) {
            shapes.add(coloredShape);
        }
        Shape shape = coloredShape.getShape();
        shape.accept(this);
    }

    public List<Shape> getResult() {
        return shapes;
    }
}