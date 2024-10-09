package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TextedShapeTest {
    @Test
    public void testTextedShapeWithCircle() {
        Circle circle = new Circle(1.0); // radius = 1.0 -> area = 3.1416, perimeter = 6.2832
        TextedShape textedShape = new TextedShape(circle, "Circle");
        assertEquals("Circle", textedShape.getText());
        assertEquals(circle.getRadius(), ((Circle)textedShape.getShape()).getRadius());

        assertEquals(3.1416, textedShape.area(), 0.0001);
        assertEquals(6.2832, textedShape.perimeter(), 0.0001);
    }

    @Test
    public void testTextedShapeWithRectangle() {
        Rectangle rectangle = new Rectangle(2.0, 3.0); // width = 2.0, height = 3.0 -> area = 6.0, perimeter = 10.0
        TextedShape textedShape = new TextedShape(rectangle, "Rectangle");
        assertEquals("Rectangle", textedShape.getText());
        assertEquals(rectangle.getLength(), ((Rectangle)textedShape.getShape()).getLength());
        assertEquals(rectangle.getWidth(), ((Rectangle)textedShape.getShape()).getWidth());

        assertEquals(6.0, textedShape.area(), 0.0001);
        assertEquals(10.0, textedShape.perimeter(), 0.0001);
    }
    
    @Test
    public void testTextedShapeWithTriangle() {
        TwoDimensionalVector vector1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector vector3 = new TwoDimensionalVector(1, 5);
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);
        Triangle triangle = new Triangle(vectors); // area = 6.0, perimeter = 12.0

        TextedShape textedShape = new TextedShape(triangle, "Triangle");
        assertEquals("Triangle", textedShape.getText());
        assertEquals(triangle.getVectors().get(0).toString(), ((Triangle)textedShape.getShape()).getVectors().get(0).toString());
        assertEquals(triangle.getVectors().get(1).toString(), ((Triangle)textedShape.getShape()).getVectors().get(1).toString());
        assertEquals(triangle.getVectors().get(2).toString(), ((Triangle)textedShape.getShape()).getVectors().get(2).toString());

        assertEquals(6.0, textedShape.area(), 0.0001);
        assertEquals(12.0, textedShape.perimeter(), 0.0001);
    }

    @Test
    public void testTextedShapeWithCompoundShape() {
        Circle circle = new Circle(1.0); // radius = 1.0 -> area = 3.1416, perimeter = 6.2832
        Rectangle rectangle = new Rectangle(2.0, 3.0); // width = 2.0, height = 3.0 -> area = 6.0, perimeter = 10.0
        CompoundShape compoundShape = new CompoundShape();
        compoundShape.add(circle);
        compoundShape.add(rectangle);

        TextedShape textedShape = new TextedShape(compoundShape, "CompoundShape");
        assertEquals("CompoundShape", textedShape.getText());
        assertEquals(compoundShape, textedShape.getShape());

        assertEquals(9.1416, textedShape.area(), 0.0001);
        assertEquals(16.2832, textedShape.perimeter(), 0.0001);
    }

    @Test
    public void testTextedShapeWithCompoundShapeOfIterators() {
        Circle circle = new Circle(1.0); // radius = 1.0 -> area = 3.1416, perimeter = 6.2832
        Rectangle rectangle = new Rectangle(2.0, 3.0); // width = 2.0, height = 3.0 -> area = 6.0, perimeter = 10.0
        CompoundShape compoundShape = new CompoundShape();
        compoundShape.add(circle);
        compoundShape.add(rectangle);

        TextedShape textedShape = new TextedShape(compoundShape, "CompoundShape");
        Iterator<Shape> iterator = textedShape.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }
        assertEquals(2, count);
    }

    @Test
    public void testTextedShapeWithCompoundShapeAddCircle() {
        Circle circle = new Circle(1.0); // radius = 1.0 -> area = 3.1416, perimeter = 6.2832
        CompoundShape compoundShape = new CompoundShape();
        compoundShape.add(circle);

        TextedShape textedShape = new TextedShape(compoundShape, "CompoundShape");
        Rectangle rectangle = new Rectangle(2.0, 3.0); // width = 2.0, height = 3.0 -> area = 6.0, perimeter = 10.0
        textedShape.add(rectangle);

        assertEquals(9.1416, textedShape.area(), 0.0001);
        assertEquals(16.2832, textedShape.perimeter(), 0.0001);
    }

    @Test
    public void testTextedShapeWithCircleAddRectangle() {
        Circle circle = new Circle(1.0); // radius = 1.0 -> area = 3.1416, perimeter = 6.2832
        TextedShape textedShape = new TextedShape(circle, "Circle");
        Rectangle rectangle = new Rectangle(2.0, 3.0); // width = 2.0, height = 3.0 -> area = 6.0, perimeter = 10.0
        
        ShapeException exception = assertThrows(ShapeException.class, () -> {
            textedShape.add(rectangle);
        });
        assertEquals("Illegal Operation", exception.getMessage());
    }

    // test TextedShape can decorate a ColoredShape
    @Test
    public void testTextedShapeWithColoredShape() {
        ColoredShape coloredShape = new ColoredShape(new Circle(1.0), "Red");
        TextedShape textedShape = new TextedShape(coloredShape, "Circle");
        assertEquals("Circle", textedShape.getText());
        assertEquals(coloredShape.getColor(), ((ColoredShape)textedShape.getShape()).getColor());
        assertEquals(((Circle)coloredShape.getShape()).getRadius(), ((Circle)((ColoredShape)textedShape.getShape()).getShape()).getRadius());

        assertEquals(3.1416, textedShape.area(), 0.0001);
        assertEquals(6.2832, textedShape.perimeter(), 0.0001);
    }
}
