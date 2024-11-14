package org.ntut.posd2024f.shapes;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ShapeBuilder {
    private List<Shape> shapes = null;
    private Stack<Shape> stack = null;
    private String _color = null;
    private String _text = null;


    public ShapeBuilder() {
        shapes = new ArrayList<Shape>();
        stack = new Stack<Shape>();
    }

    private Shape decorateShape(Shape shape, String color, String text) {
        if (color != null) {
            ColoredShape coloredShape = new ColoredShape(shape, color);
            shape = coloredShape;
        }
        if (text != null) {
            TextedShape textedShape = new TextedShape(shape, text);
            shape = textedShape;
        }
        return shape;
    }
    
    public void buildCircle(double radius, String color, String text) {
        Shape circle = new Circle(radius);
        circle = decorateShape(circle, color, text);

        if (stack.isEmpty()) {
            shapes.add(circle);
        } else {
            CompoundShape compoundShape = (CompoundShape) stack.peek();
            compoundShape.add(circle);
        }
    }

    public void buildRectangle(double length, double width, String color, String text) {
        Shape rectangle = new Rectangle(length, width);
        rectangle = decorateShape(rectangle, color, text);
        
        if (stack.isEmpty()) {
            shapes.add(rectangle);
        } else {
            CompoundShape compoundShape = (CompoundShape) stack.peek();
            compoundShape.add(rectangle);
        }
    }

    public void buildTriangle(List<TwoDimensionalVector> vectors, String color, String text) {
        Shape triangle = new Triangle(vectors);
        triangle = decorateShape(triangle, color, text);
        
        if (stack.isEmpty()) {
            shapes.add(triangle);
        } else {
            CompoundShape compoundShape = (CompoundShape) stack.peek();
            compoundShape.add(triangle);
        }
    }

    public void buildConvexPolygon(List<TwoDimensionalVector> vectors, String color, String text) {
        Shape convexPolygon = new ConvexPolygon(vectors);
        convexPolygon = decorateShape(convexPolygon, color, text);
        
        if (stack.isEmpty()) {
            shapes.add(convexPolygon);
        } else {
            CompoundShape compoundShape = (CompoundShape) stack.peek();
            compoundShape.add(convexPolygon);
        }
    }

    public void beginBuildCompoundShape(String color, String text) {
        this._color = color;
        this._text = text;
        CompoundShape compoundShape = new CompoundShape();
        stack.push(compoundShape);
    }

    public void endBuildCompoundShape() {
        CompoundShape compoundShape = (CompoundShape) stack.pop();
        compoundShape = (CompoundShape) decorateShape(compoundShape, this._color, this._text);
        if (stack.isEmpty()) {
            shapes.add(compoundShape);
        } else {
            CompoundShape parent = (CompoundShape) stack.peek();
            parent.add(compoundShape);
        }
    }

    public List<Shape> getResult() {
        return shapes;
    }
}
