package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.text.AbstractDocument.Content;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

@SuppressWarnings("unused")
public class ShapeTest {
    private static Circle circle;
    private static Triangle triangle;
    private static Rectangle rectangle;
    private static ArrayList<Shape> shapes;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @BeforeClass
    public static void setUp() throws Exception {
        // 初始化全域變數
        TwoDimensionalVector side1 = new TwoDimensionalVector(3, 0);
        TwoDimensionalVector side2 = new TwoDimensionalVector(-3, 4);
        TwoDimensionalVector side3 = new TwoDimensionalVector(0, -4);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(side1);
        vectors.add(side2);
        vectors.add(side3);
      
        circle = new Circle(5.0); // area = 78.54 perimeter = 31.42
        triangle = new Triangle(vectors); // area = 6.0 perimeter = 12.0
        rectangle = new Rectangle(3.0, 4.0); // area = 12.0 perimeter = 14.0

        shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(triangle);
        shapes.add(rectangle);
    }

    @Test
    public void testByArea() throws Exception {
        assertEquals(circle.area(), shapes.get(0).area(), 0.01);
        assertEquals(triangle.area(), shapes.get(1).area(), 0.01);
        assertEquals(rectangle.area(), shapes.get(2).area(), 0.01);
    }

    @Test
    public void testByPerimeter() throws Exception {
        assertEquals(circle.perimeter(), shapes.get(0).perimeter(), 0.01);
        assertEquals(triangle.perimeter(), shapes.get(1).perimeter(), 0.01);
        assertEquals(rectangle.perimeter(), shapes.get(2).perimeter(), 0.01);
    }

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
    public void testCircleAdd() {
        expectedEx.expect(ShapeException.class);
        expectedEx.expectMessage("Illegal Operation");
        Circle circle = new Circle(5.0);
        Rectangle rectangle = new Rectangle(3.0, 4.0);
        circle.add(rectangle);
    }
}