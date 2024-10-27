package org.ntut.posd2024f.shapes;

import java.util.Iterator;

public class PrettyPrintVisitor implements Visitor<String>{
    private String result = "";
    private int level = 0;

    @Override
    public void visitCircle(Circle circle) {
        result += "Circle " + Double.toString(circle.getRadius());
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        result += "Rectangle " + Double.toString(rectangle.getLength()) + " " + Double.toString(rectangle.getWidth());
    }

    @Override
    public void visitTriangle(Triangle triangle) {
        String v1 = triangle.getVectors().get(0).toString();
        String v2 = triangle.getVectors().get(1).toString();
        String v3 = triangle.getVectors().get(2).toString();
        result += "Triangle " + v1 + " " + v2 + " " + v3;
    }

    @Override
    public void visitConvexPolygon(ConvexPolygon convexPolygon) {
        String vectors = "";
        for (TwoDimensionalVector vector : convexPolygon.getVectors()) {
            vectors += " " + vector.toString();
        }
        result += "ConvexPolygon" + vectors;
    }

    @Override
    public void visitCompoundShape(CompoundShape compoundShape) {
        Iterator<Shape> it = compoundShape.iterator();
        if (!it.hasNext()) {
            result += "CompoundShape {}";
        }
        else {
            result += "CompoundShape {";
            level++;
            while (it.hasNext()) {
                Shape shape = it.next();
                result += "\n" + getSpace();
                shape.accept(this);
            }
            level--;
            result += "\n" + getSpace() + "}";
        }
    }

    private String getSpace() {
        String str = "";
        for (int i = 0; i < level; i++) {
            str += "  ";
        }
        return str;
    }

    @Override
    public void visitTextedShape(TextedShape textedShape) {
        textedShape.getShape().accept(this);
        result += ", text: " + textedShape.getText();
    }

    @Override
    public void visitColoredShape(ColoredShape coloredShape) {
        switch (coloredShape.getColor().toUpperCase()) {
            case "RED":
                result += "\033[0;31m";
                coloredShape.getShape().accept(this);
                result += "\033[0m";
                break;
            case "GREEN": 
                result += "\033[0;32m";
                coloredShape.getShape().accept(this);
                result += "\033[0m";
                break;
            case "BLUE": 
                result += "\033[0;34m";
                coloredShape.getShape().accept(this);
                result += "\033[0m";
                break;
            default:
                coloredShape.getShape().accept(this);
                break;
        }
    }

    @Override
    public String getResult() {
        return result;
    }
}
