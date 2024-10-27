package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class FindShapeVisitorTest {
    @Test
    public void testFindShapeVisitorWithCircle() {
        FindShapeVisitor findShapeVisitor = new FindShapeVisitor(shape -> shape.area() > 10);
        Circle circle = new Circle(3);
        circle.accept(findShapeVisitor);
        assertEquals(1, findShapeVisitor.getResult().size());
    }

    @Test
    public void testFindShapeVisitorWithRectangle() {
        FindShapeVisitor findShapeVisitor = new FindShapeVisitor(shape -> shape.area() > 10);
        Rectangle rectangle = new Rectangle(3, 4);
        rectangle.accept(findShapeVisitor);
        assertEquals(1, findShapeVisitor.getResult().size());
    }

    @Test
    public void testFindShapeVisitorWithTriangle() {
        FindShapeVisitor findShapeVisitor = new FindShapeVisitor(shape -> shape.area() > 10);
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        TwoDimensionalVector v1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector v2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector v3 = new TwoDimensionalVector(1, 5);
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);

        Triangle triangle = new Triangle(vectors);  // area = 6, perimeter = 12
        triangle.accept(findShapeVisitor);
        assertEquals(0, findShapeVisitor.getResult().size());
    }

    @Test
    public void testFindShapeVisitorWithConvexPolygon() {
        FindShapeVisitor findShapeVisitor = new FindShapeVisitor(shape -> shape.area() > 10);
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        TwoDimensionalVector v1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector v2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector v3 = new TwoDimensionalVector(1, 5);
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);

        ConvexPolygon convexPolygon = new ConvexPolygon(vectors); // area = 6, perimeter = 12
        convexPolygon.accept(findShapeVisitor);
        assertEquals(0, findShapeVisitor.getResult().size());
    }

    @Test
    public void testFindShapeVisitorWithCompoundShape() {
        FindShapeVisitor findShapeVisitor = new FindShapeVisitor(shape -> shape.area() > 10);
        CompoundShape compoundShape = new CompoundShape();
        Circle circle = new Circle(3);
        compoundShape.add(circle);
        compoundShape.accept(findShapeVisitor);
        assertEquals(2, findShapeVisitor.getResult().size());
    }

    @Test
    public void testFindShapeVisitorWithTextedShape() {
        FindShapeVisitor findShapeVisitor = new FindShapeVisitor(shape -> shape.area() > 10);
        TextedShape textedShape = new TextedShape(new Circle(3), "Circle");
        textedShape.accept(findShapeVisitor);
        assertEquals(2, findShapeVisitor.getResult().size());
    }

    @Test
    public void testFindShapeVisitorWithTextedShape2() {
        FindShapeVisitor findShapeVisitor = new FindShapeVisitor(shape -> shape instanceof TextedShape);
        TextedShape textedShape = new TextedShape(new Circle(3), "Circle");
        textedShape.accept(findShapeVisitor);
        assertEquals(1, findShapeVisitor.getResult().size());
    }

    @Test
    public void testFindShapeVisitorWithColoredShape() {
        FindShapeVisitor findShapeVisitor = new FindShapeVisitor(shape -> shape.area() > 10);
        ColoredShape coloredShape = new ColoredShape(new Circle(3), "Red");
        coloredShape.accept(findShapeVisitor);
        assertEquals(2, findShapeVisitor.getResult().size());
    }

    @Test
    public void testFindShapeVisitorWithColoredShape2() {
        FindShapeVisitor findShapeVisitor = new FindShapeVisitor(shape -> shape instanceof ColoredShape);
        ColoredShape coloredShape = new ColoredShape(new Circle(3), "Red");
        coloredShape.accept(findShapeVisitor);
        assertEquals(1, findShapeVisitor.getResult().size());
    }
}
