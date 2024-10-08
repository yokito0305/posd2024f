package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class NullIteratorTest {
    @Test
    public void testCircleReturnNullIterator() {
        Circle circle = new Circle(5.0);
        Iterator<Shape> iterator = circle.iterator();
        assertEquals(false, iterator.hasNext());
    }

    @Test
    public void testCircleNext() {
        Circle circle = new Circle(5.0);

        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            circle.iterator().next();
        });
        assertEquals("Null iterator does not point to any element", exception.getMessage());
    }

    @Test
    public void testCircleAddRectangle() {
        Circle circle = new Circle(5.0);
        Rectangle rectangle = new Rectangle(3.0, 4.0);

        ShapeException exception = assertThrows(ShapeException.class, () -> {
            circle.add(rectangle);
        });
        assertEquals("Illegal Operation", exception.getMessage());
    }
}
