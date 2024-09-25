package org.ntut.posd2024f.shapes;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class NullIteratorTest {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void testCircleReturnNullIterator() {
        Circle circle = new Circle(5.0);
        Iterator<Shape> iterator = circle.iterator();
        assertEquals(false, iterator.hasNext());
    }

    @Test
    public void testCircleNext() {
        expectedEx.expect(NoSuchElementException.class);
        expectedEx.expectMessage("Null iterator does not point to any element");
        Circle circle = new Circle(5.0);
        Iterator<Shape> iterator = circle.iterator();
        assertEquals(null, iterator.next());
    }

    @Test
    public void testCircleAddRectangle() {
        expectedEx.expect(ShapeException.class);
        expectedEx.expectMessage("Illegal Operation");
        Circle circle = new Circle(5.0);
        Rectangle rectangle = new Rectangle(3.0, 4.0);
        circle.add(rectangle);
    }
}
