package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class TextedShapeTest {
    @Test
    public void testTextedShapeCreate() {
        Shape shape = new Rectangle(1, 1);
        new TextedShape(shape, "text");
    }
    
    @Test
    public void testTextedShapeGetShape() {
        Shape shape = new Rectangle(1, 1);
        TextedShape textedShape = new TextedShape(shape, "text");
        assertEquals(shape, textedShape.getShape());
    }

    @Test
    public void testTextedShapeGetText() {
        Shape shape = new Rectangle(1, 1);
        TextedShape textedShape = new TextedShape(shape, "text");
        assertEquals("text", textedShape.getText());
    }

    @Test
    public void testTextedShapeArea() {
        Shape shape = new Rectangle(1, 1);
        TextedShape textedShape = new TextedShape(shape, "text");
        assertEquals(1, textedShape.area());
    }

    @Test
    public void testTextedShapePerimeter() {
        Shape shape = new Rectangle(1, 1);
        TextedShape textedShape = new TextedShape(shape, "text");
        assertEquals(4, textedShape.perimeter());
    }

    @Test
    public void testTextedShapeCircleAddRectangle() {
        Shape shape = new Circle(1);
        TextedShape textedShape = new TextedShape(shape, "text");
        assertThrows(ShapeException.class, () -> textedShape.add(new Rectangle(1, 1)));
    }

    @Test
    public void testTextedShapeCompoundShapeAddRectangle() {
        Shape shape = new CompoundShape();
        TextedShape textedShape = new TextedShape(shape, "text");
        textedShape.add(new Rectangle(1, 1));
    }

    @Test
    public void testTextedShapeIterator() {
        Shape shape = new Rectangle(1, 1);
        TextedShape textedShape = new TextedShape(shape, "text");
        Iterator<Shape> iterator = textedShape.iterator();
        assumeFalse(iterator.hasNext());
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> iterator.next());
        assertEquals("Null iterator does not point to any element", exception.getMessage());
    } 

    @Test
    public void testTextedShapeWithColoredShape() {
        Shape shape = new Rectangle(1, 1);
        ColoredShape coloredShape = new ColoredShape(shape, "red");
        TextedShape textedShape = new TextedShape(coloredShape, "text");
        assertEquals("red", ((ColoredShape)textedShape.getShape()).getColor());
    }
}
