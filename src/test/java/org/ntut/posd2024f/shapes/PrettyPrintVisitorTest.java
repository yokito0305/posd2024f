package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class PrettyPrintVisitorTest {
    @Test
    public void PrettyPrintVisitorWithCircle() {
        PrettyPrintVisitor prettyPrintVisitor = new PrettyPrintVisitor();
        Circle circle = new Circle(1.0);
        circle.accept(prettyPrintVisitor);
        assertEquals("Circle 1.0", prettyPrintVisitor.getResult());
    }

    @Test
    public void PrettyPrintVisitorWithRectangle() {
        PrettyPrintVisitor prettyPrintVisitor = new PrettyPrintVisitor();
        Rectangle rectangle = new Rectangle(1.0, 2.0);
        rectangle.accept(prettyPrintVisitor);
        assertEquals("Rectangle 1.0 2.0", prettyPrintVisitor.getResult());
    }

    @Test
    public void PrettyPrintVisitorWithTriangle() {
        PrettyPrintVisitor prettyPrintVisitor = new PrettyPrintVisitor();
        TwoDimensionalVector vector1 = new TwoDimensionalVector(0, 0);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(1, 0);
        TwoDimensionalVector vector3 = new TwoDimensionalVector(0, 1);
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);
        Triangle triangle = new Triangle(vectors);

        triangle.accept(prettyPrintVisitor);
        assertEquals("Triangle [0,0] [1,0] [0,1]", prettyPrintVisitor.getResult());
    }

    @Test
    public void PrettyPrintVisitorWithConvexPolygon() {
        PrettyPrintVisitor prettyPrintVisitor = new PrettyPrintVisitor();
        TwoDimensionalVector vector1 = new TwoDimensionalVector(0, 0);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(2, 0);
        TwoDimensionalVector vector3 = new TwoDimensionalVector(2, 2);
        TwoDimensionalVector vector4 = new TwoDimensionalVector(0, 2);
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);
        vectors.add(vector4);
        ConvexPolygon convexPolygon = new ConvexPolygon(vectors);

        convexPolygon.accept(prettyPrintVisitor);
        assertEquals("ConvexPolygon [0,0] [2,0] [2,2] [0,2]", prettyPrintVisitor.getResult());
    }

    @Test
    public void PrettyPrintVisitorWithCompoundShapeWithEmpty() {
        PrettyPrintVisitor prettyPrintVisitor = new PrettyPrintVisitor();
        CompoundShape compoundShape = new CompoundShape();
        compoundShape.accept(prettyPrintVisitor);
        assertEquals("CompoundShape {}", prettyPrintVisitor.getResult());
    }

    @Test
    public void PrettyPrintVisitorWithCompoundShape() {
        PrettyPrintVisitor prettyPrintVisitor = new PrettyPrintVisitor();
        CompoundShape compoundShape = new CompoundShape();
        Circle circle = new Circle(1.0);
        Rectangle rectangle = new Rectangle(1.0, 2.0);
        compoundShape.add(circle);
        compoundShape.add(rectangle);

        compoundShape.accept(prettyPrintVisitor);
        assertEquals("CompoundShape {\n  Circle 1.0\n  Rectangle 1.0 2.0\n}", prettyPrintVisitor.getResult());
    }

    @Test
    public void PrettyPrintVisitorWithCompoundShapeAddEmptyCompoundShape() {
        PrettyPrintVisitor prettyPrintVisitor = new PrettyPrintVisitor();
        CompoundShape compoundShape = new CompoundShape();
        CompoundShape compoundShape1 = new CompoundShape();
        compoundShape.add(compoundShape1);

        compoundShape.accept(prettyPrintVisitor);
        assertEquals("CompoundShape {\n  CompoundShape {}\n}", prettyPrintVisitor.getResult());
    }

    @Test
    public void PrettyPrintVisitorWithCompoundShapeAddCompoundShape() {
        PrettyPrintVisitor prettyPrintVisitor = new PrettyPrintVisitor();
        CompoundShape compoundShape = new CompoundShape();
        CompoundShape compoundShape1 = new CompoundShape();
        Circle circle = new Circle(1.0);
        Rectangle rectangle = new Rectangle(1.0, 2.0);
        compoundShape1.add(circle);
        compoundShape1.add(rectangle);
        compoundShape.add(compoundShape1);

        compoundShape.accept(prettyPrintVisitor);
        assertEquals("CompoundShape {\n  CompoundShape {\n    Circle 1.0\n    Rectangle 1.0 2.0\n  }\n}", prettyPrintVisitor.getResult());
    }

    @Test
    public void PrettyPrintVisitorWithTextedShape() {
        PrettyPrintVisitor prettyPrintVisitor = new PrettyPrintVisitor();
        Circle circle = new Circle(1.0);
        TextedShape textedShape = new TextedShape(circle, "Hello");
        textedShape.accept(prettyPrintVisitor);
        assertEquals("Circle 1.0, text: Hello", prettyPrintVisitor.getResult());
    }

    @Test
    public void PrettyPrintVisitorWithTextedShapeWithCompoundShape() {
        PrettyPrintVisitor prettyPrintVisitor = new PrettyPrintVisitor();
        CompoundShape compoundShape = new CompoundShape();
        Circle circle = new Circle(1.0);
        Rectangle rectangle = new Rectangle(1.0, 2.0);
        compoundShape.add(circle);
        compoundShape.add(rectangle);
        TextedShape textedShape = new TextedShape(compoundShape, "Hello");
        textedShape.accept(prettyPrintVisitor);
        assertEquals("CompoundShape {\n  Circle 1.0\n  Rectangle 1.0 2.0\n}, text: Hello", prettyPrintVisitor.getResult());
    }

    @Test
    public void PrettyPrintVisitorWithTextedShapeWithTextedShape() {
        PrettyPrintVisitor prettyPrintVisitor = new PrettyPrintVisitor();
        CompoundShape compoundShape = new CompoundShape();
        CompoundShape compoundShape1 = new CompoundShape();

        Circle circle = new Circle(1.0);
        Rectangle rectangle = new Rectangle(1.0, 2.0);
        compoundShape1.add(circle);
        compoundShape1.add(rectangle);

        TextedShape textedShape = new TextedShape(compoundShape1, "Hello");

        compoundShape.add(textedShape);
        TextedShape textedShape1 = new TextedShape(compoundShape, "World!");

        textedShape1.accept(prettyPrintVisitor);
        assertEquals("CompoundShape {\n  CompoundShape {\n    Circle 1.0\n    Rectangle 1.0 2.0\n  }, text: Hello\n}, text: World!", prettyPrintVisitor.getResult());
    }

    @Test
    public void PrettyPrintVisitorWithColoredShapeWithRed() {
        PrettyPrintVisitor prettyPrintVisitor = new PrettyPrintVisitor();
        Circle circle = new Circle(1.0);
        ColoredShape coloredShape = new ColoredShape(circle, "Red");
        coloredShape.accept(prettyPrintVisitor);
        assertEquals("\033[0;31mCircle 1.0\033[0m", prettyPrintVisitor.getResult());
    }

    @Test
    public void PrettyPrintVisitorWithColoredShapeWithGreen() {
        PrettyPrintVisitor prettyPrintVisitor = new PrettyPrintVisitor();
        Circle circle = new Circle(1.0);
        ColoredShape coloredShape = new ColoredShape(circle, "Green");
        coloredShape.accept(prettyPrintVisitor);
        assertEquals("\033[0;32mCircle 1.0\033[0m", prettyPrintVisitor.getResult());
    }

    @Test
    public void PrettyPrintVisitorWithColoredShapeWithBlue() {
        PrettyPrintVisitor prettyPrintVisitor = new PrettyPrintVisitor();
        Circle circle = new Circle(1.0);
        ColoredShape coloredShape = new ColoredShape(circle, "Blue");
        coloredShape.accept(prettyPrintVisitor);
        assertEquals("\033[0;34mCircle 1.0\033[0m", prettyPrintVisitor.getResult());
        // System.out.println(prettyPrintVisitor.getResult());
    }

    @Test
    public void PrettyPrintVisitorWithColoredShapeWithCompoundShapeAndTextedShape() {
        PrettyPrintVisitor prettyPrintVisitor = new PrettyPrintVisitor();
        CompoundShape compoundShape1 = new CompoundShape();
        Circle circle = new Circle(1.0);
        Rectangle rectangle = new Rectangle(1.0, 2.0);
        compoundShape1.add(circle);
        compoundShape1.add(rectangle);
        TextedShape textedShape = new TextedShape(compoundShape1, "This is a blue compound shape");
        ColoredShape coloredShape = new ColoredShape(textedShape, "Blue");

        CompoundShape compoundShape2 = new CompoundShape();
        compoundShape2.add(circle);
        compoundShape2.add(rectangle);
        TextedShape textedShape1 = new TextedShape(compoundShape2, "This is a red compound shape");
        ColoredShape coloredShape1 = new ColoredShape(textedShape1, "Red");

        TextedShape textedShape3 = new TextedShape(circle, "This is a green compound shape");
        ColoredShape coloredShape3 = new ColoredShape(textedShape3, "Green");

        CompoundShape compoundShape3 = new CompoundShape();
        compoundShape3.add(coloredShape);
        compoundShape3.add(coloredShape1);
        compoundShape3.add(coloredShape3);

        compoundShape3.accept(prettyPrintVisitor);
        // System.out.println(prettyPrintVisitor.getResult());
    }
}
