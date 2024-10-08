package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ColoredShapeTest {
    @Test
    public void testColoredShapeWithCircle() {
        Circle circle = new Circle(1.0); // radius = 1.0 -> area = 3.1416, perimeter = 6.2832
        ColoredShape coloredShape = new ColoredShape(circle, "Red");
        assertEquals("Red", coloredShape.getColor());
        assertEquals(circle.getRadius(), ((Circle)coloredShape.getShape()).getRadius());

        assertEquals(3.1416, coloredShape.area(), 0.0001);
        assertEquals(6.2832, coloredShape.perimeter(), 0.0001);
    }

    @Test
    public void testColoredShapeWithRectangle() {
        Rectangle rectangle = new Rectangle(2.0, 3.0); // width = 2.0, height = 3.0 -> area = 6.0, perimeter = 10.0
        ColoredShape coloredShape = new ColoredShape(rectangle, "Blue");
        assertEquals("Blue", coloredShape.getColor());
        assertEquals(rectangle.getLength(), ((Rectangle)coloredShape.getShape()).getLength());
        assertEquals(rectangle.getWidth(), ((Rectangle)coloredShape.getShape()).getWidth());

        assertEquals(6.0, coloredShape.area(), 0.0001);
        assertEquals(10.0, coloredShape.perimeter(), 0.0001);
    }
    
    @Test
    public void testColoredShapeWithTriangle() {
        TwoDimensionalVector vector1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector vector3 = new TwoDimensionalVector(1, 5);
        List<TwoDimensionalVector> vectors = new java.util.ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);
        Triangle triangle = new Triangle(vectors); // area = 6.0, perimeter = 12.0

        ColoredShape coloredShape = new ColoredShape(triangle, "Green");
        assertEquals("Green", coloredShape.getColor());
        assertEquals(triangle.getVectors().get(0).toString(), ((Triangle)coloredShape.getShape()).getVectors().get(0).toString());
        assertEquals(triangle.getVectors().get(1).toString(), ((Triangle)coloredShape.getShape()).getVectors().get(1).toString());
        assertEquals(triangle.getVectors().get(2).toString(), ((Triangle)coloredShape.getShape()).getVectors().get(2).toString());

        assertEquals(6.0, coloredShape.area(), 0.0001);
        assertEquals(12.0, coloredShape.perimeter(), 0.0001);
    }

    @Test
    public void testColoredShapeWithCompoundShape() {
        Circle circle = new Circle(1.0); // radius = 1.0 -> area = 3.1416, perimeter = 6.2832
        Rectangle rectangle = new Rectangle(2.0, 3.0); // width = 2.0, height = 3.0 -> area = 6.0, perimeter = 10.0
        CompoundShape compoundShape = new CompoundShape();
        compoundShape.add(circle);
        compoundShape.add(rectangle);

        ColoredShape coloredShape = new ColoredShape(compoundShape, "Yellow");
        assertEquals("Yellow", coloredShape.getColor());
        Iterator<Shape> iterator = ((CompoundShape)coloredShape.getShape()).iterator();
        Shape ItCircle = iterator.next();
        Shape ItRectangle = iterator.next();
        assertEquals(circle.getRadius(), ((Circle)ItCircle).getRadius());
        assertEquals(rectangle.getLength(), ((Rectangle)ItRectangle).getLength());
        assertEquals(rectangle.getWidth(), ((Rectangle)ItRectangle).getWidth());
        assertFalse(iterator.hasNext());

        assertEquals(9.1416, coloredShape.area(), 0.0001);
        assertEquals(16.2832, coloredShape.perimeter(), 0.0001);
    }

    // test ColoredShape can decorate a TextedShape
    @Test
    public void testColoredShapeWithTextedShape() {
        TextedShape textedShape = new TextedShape(new Circle(1.0), "Circle");
        ColoredShape coloredShape = new ColoredShape(textedShape, "Red");
        assertEquals("Red", coloredShape.getColor());
        assertEquals(textedShape.getText(), ((TextedShape)coloredShape.getShape()).getText());
        assertEquals(((Circle)textedShape.getShape()).getRadius(), ((Circle)((TextedShape)coloredShape.getShape()).getShape()).getRadius());

        assertEquals(3.1416, coloredShape.area(), 0.0001);
        assertEquals(6.2832, coloredShape.perimeter(), 0.0001);
    }
}
