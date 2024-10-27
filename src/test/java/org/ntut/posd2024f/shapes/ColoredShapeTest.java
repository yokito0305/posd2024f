package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class ColoredShapeTest {
    @Test
    public void testColoredShapeCreate() {
        Shape shape = new Rectangle(1, 1);
        new ColoredShape(shape, "color");
    }
    
    @Test
    public void testColoredShapeGetShape() {
        Shape shape = new Rectangle(1, 1);
        ColoredShape coloredShape = new ColoredShape(shape, "color");
        assertEquals(shape, coloredShape.getShape());
    }

    @Test
    public void testColoredShapeGetColor() {
        Shape shape = new Rectangle(1, 1);
        ColoredShape coloredShape = new ColoredShape(shape, "color");
        assertEquals("color", coloredShape.getColor());
    }

    @Test
    public void testColoredShapeArea() {
        Shape shape = new Rectangle(1, 1);
        ColoredShape coloredShape = new ColoredShape(shape, "color");
        assertEquals(1, coloredShape.area());
    }

    @Test
    public void testColoredShapePerimeter() {
        Shape shape = new Rectangle(1, 1);
        ColoredShape coloredShape = new ColoredShape(shape, "color");
        assertEquals(4, coloredShape.perimeter());
    }

    @Test
    public void testColoredShapeCircleAddRectangle() {
        Shape shape = new Circle(1);
        ColoredShape coloredShape = new ColoredShape(shape, "color");
        assertThrows(ShapeException.class, () -> coloredShape.add(new Rectangle(1, 1)));
    }

    @Test
    public void testColoredShapeCompoundShapeAddRectangle() {
        Shape shape = new CompoundShape();
        ColoredShape coloredShape = new ColoredShape(shape, "color");
        coloredShape.add(new Rectangle(1, 1));
    }

    @Test
    public void testColoredShapeIterator() {
        Shape shape = new Rectangle(1, 1);
        ColoredShape coloredShape = new ColoredShape(shape, "color");
        Iterator<Shape> it = coloredShape.iterator();
        assertFalse(it.hasNext());
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> it.next());
        assertEquals("Null iterator does not point to any element", exception.getMessage());
    }

    @Test
    public void testColoredShapeWithTextedShape() {
        Shape shape = new Rectangle(1, 1);
        TextedShape textedShape = new TextedShape(shape, "text");
        ColoredShape coloredShape = new ColoredShape(textedShape, "color");
        assertEquals("text", ((TextedShape)coloredShape.getShape()).getText());
    }
}
