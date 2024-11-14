package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class PrettyPrintVisitorTest {
    @Test
    public void testPrettyPrintVisitorWithCircle() {
        Circle circle = new Circle(3);
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();
        circle.accept(visitor);
        assertEquals("Circle 3.0", visitor.getResult());
    }

    @Test
    public void testPrettyPrintVisitorWithRectangle() {
        Rectangle rectangle = new Rectangle(3, 4);
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();
        rectangle.accept(visitor);
        assertEquals("Rectangle 3.0 4.0", visitor.getResult());
    }

    @Test
    public void testPrettyPrintVisitorWithTriangle() {
        List<TwoDimensionalVector> vectors = new ArrayList<TwoDimensionalVector>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(3, 0));
        vectors.add(new TwoDimensionalVector(0, 4));
        Triangle triangle = new Triangle(vectors);

        PrettyPrintVisitor visitor = new PrettyPrintVisitor();
        triangle.accept(visitor);
        assertEquals("Triangle [0,0] [3,0] [0,4]", visitor.getResult());
    }

    @Test
    public void testPrettyPrintVisitorWithConvexPolygon() {
        List<TwoDimensionalVector> vectors = new ArrayList<TwoDimensionalVector>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(3, 0));
        vectors.add(new TwoDimensionalVector(0, 4));
        ConvexPolygon convexPolygon = new ConvexPolygon(vectors);

        PrettyPrintVisitor visitor = new PrettyPrintVisitor();
        convexPolygon.accept(visitor);
        assertEquals("ConvexPolygon [0,0] [3,0] [0,4]", visitor.getResult());
    }

    @Test
    public void testPrettyPrintVisitorWithEmptyCompoundShape() {
        CompoundShape compoundShape = new CompoundShape();
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();
        compoundShape.accept(visitor);
        assertEquals("CompoundShape {}", visitor.getResult());
    }

    @Test
    public void testPrettyPrintVisitorWithCircleInCompoundShape() {
        CompoundShape compoundShape = new CompoundShape();
        Circle circle = new Circle(3);
        compoundShape.add(circle);

        PrettyPrintVisitor visitor = new PrettyPrintVisitor();
        compoundShape.accept(visitor);
        assertEquals("CompoundShape {\n" + 
                     "  Circle 3.0\n" + 
                     "}", visitor.getResult());
    }

    @Test
    public void testPrettyPrintVisitorWithTwoLevelCompoundShape() {
        CompoundShape compoundShape = new CompoundShape();
        Circle circle = new Circle(3);
        compoundShape.add(circle);
        CompoundShape compoundShape2 = new CompoundShape();
        compoundShape2.add(compoundShape);
        
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();
        compoundShape2.accept(visitor);

        assertEquals("CompoundShape {\n" + 
                     "  CompoundShape {\n" +
                     "    Circle 3.0\n" +
                     "  }\n" +
                     "}", visitor.getResult());
    }

    @Test
    public void testPrettyPrintVisitorWithTextedShape() {
        Circle circle = new Circle(3);
        TextedShape textedShape = new TextedShape(circle, "Hello");

        PrettyPrintVisitor visitor = new PrettyPrintVisitor();
        textedShape.accept(visitor);

        assertEquals("Circle 3.0, text: Hello", visitor.getResult());
    }

    @Test
    public void testPrettyPrintVisitorWithCircleInColoredShape() {
        Circle circle = new Circle(3);
        ColoredShape coloredShape = new ColoredShape(circle, "red");

        PrettyPrintVisitor visitor = new PrettyPrintVisitor();
        coloredShape.accept(visitor);

        assertEquals("\033[0;31mCircle 3.0\033[0m", visitor.getResult());
    }

    @Test
    public void testPrettyPrintVisitorWithTwoLevelColoredShape() {
        CompoundShape compoundShape = new CompoundShape();
        Circle circle = new Circle(3);
        compoundShape.add(circle);
        TextedShape textedShape = new TextedShape(compoundShape, "this is blue");
        ColoredShape coloredShape = new ColoredShape(textedShape, "BLUE");

        CompoundShape compoundShape2 = new CompoundShape();
        compoundShape2.add(coloredShape);
        
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();
        compoundShape2.accept(visitor);

        assertEquals("CompoundShape {\n" + 
                     "  \033[0;34mCompoundShape {\n" +
                     "    Circle 3.0\n" +
                     "  }, text: this is blue\033[0m\n" +
                     "}", visitor.getResult());
    }
}
