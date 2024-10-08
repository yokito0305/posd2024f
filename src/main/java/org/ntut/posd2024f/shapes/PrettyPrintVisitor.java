package org.ntut.posd2024f.shapes;

import java.util.Iterator;

public class PrettyPrintVisitor implements Visitor<String>{
    private String _result = "";
    private int indentLevel = 0;

    @Override
    public void visitCircle(Circle circle) {
        _result += getIndent() + "Circle " + circle.getRadius();
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        _result += getIndent() + "Rectangle " + rectangle.getLength() + " " + rectangle.getWidth();
    }

    @Override
    public void visitTriangle(Triangle triangle) {
        _result += getIndent() + "Triangle ";
        for (TwoDimensionalVector vector : triangle.getVectors()) {
            _result += vector.toString() + " ";
        }
        _result = _result.trim();
    }

    @Override
    public void visitConvexPolygon(ConvexPolygon convexPolygon) {
        _result += getIndent() + "ConvexPolygon ";
        for (TwoDimensionalVector vector : convexPolygon.getVectors()) {
            _result += vector.toString() + " ";
        }
        _result = _result.trim();
    }

    @Override
    public void visitCompoundShape(CompoundShape compoundShape) {
        Boolean isEmpty = compoundShape.iterator().hasNext();
        if (!isEmpty) {
            _result += getIndent() + "CompoundShape {}";
        } else {
            /*The shapes in the compound shape should have an indent of 2 spaces. If the shape is a compound shape, the indent should be increased by 2 spaces. */
            _result += getIndent() + "CompoundShape {";
            indentLevel ++;
            Iterator<Shape> iterator = compoundShape.iterator();
            while (iterator.hasNext()) {
                _result += "\n";
                Shape shape = iterator.next();
                shape.accept(this);

            }
            indentLevel --;
            _result += "\n" + getIndent() + "}";
        }
    }

    private String getIndent() {
        String indent = "";
        for (int i = 0; i < indentLevel; i++) {
            indent += "  ";
        }
        return indent;
    }

    @Override
    public void visitTextedShape(TextedShape textedShape) {
        textedShape.getShape().accept(this);
        _result += ", text: " + textedShape.getText();
    }

    @Override
    public void visitColoredShape(ColoredShape coloredShape) {
        switch (coloredShape.getColor().toUpperCase()) {
            case "RED":
                _result += "\033[0;31m";
                coloredShape.getShape().accept(this);
                _result += "\033[0m";
                break;
            case "GREEN":
                _result += "\033[0;32m";
                coloredShape.getShape().accept(this);
                _result += "\033[0m";
                break;
            case "BLUE":
                _result += "\033[0;34m";
                coloredShape.getShape().accept(this);
                _result += "\033[0m";
                break;
            default:
                break;
        }

    }

    @Override
    public String getResult() {
        return _result;
    }
}
