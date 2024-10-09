package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class FindShapeVisitorTest {
    @Test
    public void testFindShapeVisitor() {
        FindShapeVisitor findShapeVisitor = new FindShapeVisitor(shape -> shape.area() == 10);
        Circle circle = new Circle(1.0);
        Rectangle rectangle = new Rectangle(2.0, 5.0);
        TwoDimensionalVector vector1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector vector3 = new TwoDimensionalVector(1, 5);
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);
        Triangle triangle = new Triangle(vectors);

        List<Shape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(rectangle);
        shapes.add(triangle);

        for (Shape shape : shapes) {
            shape.accept(findShapeVisitor);
        }

        List<Shape> result = findShapeVisitor.getResult();
        assertEquals(1, result.size());
        assertEquals(rectangle, result.get(0));
    }

    @Test
    public void testFindShapeVisitorOfPerimeter() {
        FindShapeVisitor findShapeVisitor = new FindShapeVisitor(shape -> shape.perimeter() == 14);
        Circle circle = new Circle(1.0);
        Rectangle rectangle = new Rectangle(2.0, 5.0);
        TwoDimensionalVector vector1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector vector3 = new TwoDimensionalVector(1, 5);
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);
        Triangle triangle = new Triangle(vectors);

        List<Shape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(rectangle);
        shapes.add(triangle);

        for (Shape shape : shapes) {
            shape.accept(findShapeVisitor);
        }

        List<Shape> result = findShapeVisitor.getResult();
        assertEquals(1, result.size());
        assertEquals(rectangle, result.get(0));
    }

    @Test
    public void testFindShapeVisitorWithConvexPolygon() {
        FindShapeVisitor findShapeVisitor = new FindShapeVisitor(shape -> shape.area() == 10);
        TwoDimensionalVector vector1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(3, 1);
        TwoDimensionalVector vector3 = new TwoDimensionalVector(3, 6);
        TwoDimensionalVector vector4 = new TwoDimensionalVector(1, 6);
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);
        vectors.add(vector4);
        ConvexPolygon convexPolygon = new ConvexPolygon(vectors);

        List<Shape> shapes = new ArrayList<>();
        shapes.add(convexPolygon);

        for (Shape shape : shapes) {
            shape.accept(findShapeVisitor);
        }

        List<Shape> result = findShapeVisitor.getResult();
        assertEquals(1, result.size());
        assertEquals(convexPolygon, result.get(0));
    }

    @Test
    public void testFindShapeVisitorWithNotFind() {
        FindShapeVisitor findShapeVisitor = new FindShapeVisitor(shape -> shape.area() == 100);
        Circle circle = new Circle(1.0);
        Rectangle rectangle = new Rectangle(2.0, 5.0);
        TwoDimensionalVector vector1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector vector3 = new TwoDimensionalVector(1, 5);
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);
        Triangle triangle = new Triangle(vectors);

        List<Shape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(rectangle);
        shapes.add(triangle);

        for (Shape shape : shapes) {
            shape.accept(findShapeVisitor);
        }

        List<Shape> result = findShapeVisitor.getResult();
        assertEquals(0, result.size());
    }

    @Test
    public void testFindShapeVisitorWithCompoundShape() {
        FindShapeVisitor findShapeVisitor = new FindShapeVisitor(shape -> shape.area() > 8);
        Circle circle = new Circle(2.0); // area = 12.5664, perimeter = 12.5664
        Rectangle rectangle = new Rectangle(2.0, 3.0); // area = 6, perimeter = 10

        CompoundShape compoundShape = new CompoundShape();
        compoundShape.add(circle);
        compoundShape.add(rectangle);

        compoundShape.accept(findShapeVisitor);
        List<Shape> result = findShapeVisitor.getResult();
        assertEquals(2, result.size());
        assertEquals(compoundShape, result.get(0));
        assertEquals(circle, result.get(1));
    }

    @Test
    public void testFindShapeVisitorWithCompoundShape2() {
        FindShapeVisitor findShapeVisitor = new FindShapeVisitor(shape -> shape.perimeter() > 10);
        Circle circle = new Circle(2.0); // area = 12.5664, perimeter = 12.5664
        Rectangle rectangle = new Rectangle(2.0, 3.0); // area = 6, perimeter = 10

        CompoundShape compoundShape = new CompoundShape();
        compoundShape.add(circle);
        compoundShape.add(rectangle);

        compoundShape.accept(findShapeVisitor);
        List<Shape> result = findShapeVisitor.getResult();
        assertEquals(2, result.size());
        assertEquals(compoundShape, result.get(0));
        assertEquals(circle, result.get(1));
    }

    @Test
    public void testFindShapeVisitorWithTextedShape() {
        FindShapeVisitor findShapeVisitor = new FindShapeVisitor(shape -> shape.area() > 8);
        Circle circle = new Circle(2.0); // area = 12.5664
        TextedShape textedShape = new TextedShape(circle, "Hello");

        textedShape.accept(findShapeVisitor);
        List<Shape> result = findShapeVisitor.getResult();
        assertEquals(2, result.size());
        assertEquals(textedShape, result.get(0));
        assertEquals(circle, result.get(1));
    }

    @Test
    public void testFindShapeVisitorWithColoredShape() {
        FindShapeVisitor findShapeVisitor = new FindShapeVisitor(shape -> shape.area() > 8);
        Circle circle = new Circle(2.0); // area = 12.5664
        ColoredShape coloredShape = new ColoredShape(circle, "Red");

        coloredShape.accept(findShapeVisitor);
        List<Shape> result = findShapeVisitor.getResult();
        assertEquals(2, result.size());
        assertEquals(coloredShape, result.get(0));
        assertEquals(circle, result.get(1));
    }

    // if the condition is shape is an instance of TextedShape, the visitor should return the texted shape.
    @Test
    public void testFindShapeVisitorWithTextedShapeCondition() {
        FindShapeVisitor findShapeVisitor = new FindShapeVisitor(shape -> shape instanceof TextedShape);
        Circle circle = new Circle(2.0); // area = 12.5664
        TextedShape textedShape = new TextedShape(circle, "Hello");

        textedShape.accept(findShapeVisitor);
        List<Shape> result = findShapeVisitor.getResult();
        assertEquals(1, result.size());
        assertEquals(textedShape, result.get(0));
    }
}
