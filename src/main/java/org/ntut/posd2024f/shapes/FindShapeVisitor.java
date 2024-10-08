package org.ntut.posd2024f.shapes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class FindShapeVisitor implements Visitor<List<Shape>> {
    private Predicate<Shape> _condition;
    private List<Shape> _result;

    public FindShapeVisitor(Predicate<Shape> condition) {
        this._condition = condition;
        this._result = new ArrayList<>();
    }

    @Override
    public void visitCircle(Circle circle) {
        if (_condition.test(circle)) {
            _result.add(circle);
        }
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        if (_condition.test(rectangle)) {
            _result.add(rectangle);
        }
    }

    @Override
    public void visitTriangle(Triangle triangle) {
        if (_condition.test(triangle)) {
            _result.add(triangle);
        }
    }

    @Override
    public void visitConvexPolygon(ConvexPolygon convexPolygon) {
        if (_condition.test(convexPolygon)) {
            _result.add(convexPolygon);
        }
    }

    @Override
    public void visitCompoundShape(CompoundShape compoundShape) {
        if (_condition.test(compoundShape)) {
            _result.add(compoundShape);
        }
        Iterator<Shape> iterator = compoundShape.iterator();
        while (iterator.hasNext()) {
            Shape shape = iterator.next();
            shape.accept(this);
        }
        
    }

    @Override
    public void visitTextedShape(TextedShape textedShape) {
        if (_condition.test(textedShape)) {
            _result.add(textedShape);
        }
        textedShape.getShape().accept(this);
    }

    @Override
    public void visitColoredShape(ColoredShape coloredShape) {
        if (_condition.test(coloredShape)) {
            _result.add(coloredShape);
        }
        coloredShape.getShape().accept(this);
    }

    public List<Shape> getResult() {
        return _result;
    }
}