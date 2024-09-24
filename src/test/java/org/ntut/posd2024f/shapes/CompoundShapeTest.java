package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class CompoundShapeTest {
    private static Circle circle;
    private static Triangle triangle;
    private static Rectangle rectangle;
    private static CompoundShape compoundShape;

    @Test
    public void testAdd() {
        Rectangle rectangle = new Rectangle(3, 4); // area = 12.0 perimeter = 14.0
        Circle circle = new Circle(5); // area = 78.54 perimeter = 31.42

        CompoundShape compoundShape = new CompoundShape();
        compoundShape.add(rectangle);
        compoundShape.add(circle);
    }

    @BeforeClass
    public static void setUp() {
        TwoDimensionalVector side1 = new TwoDimensionalVector(3, 0);
        TwoDimensionalVector side2 = new TwoDimensionalVector(-3, 4);
        TwoDimensionalVector side3 = new TwoDimensionalVector(0, -4);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(side1);
        vectors.add(side2);
        vectors.add(side3);

        triangle = new Triangle(vectors); // area = 6.0 perimeter = 12.0
        rectangle = new Rectangle(3, 4); // area = 12.0 perimeter = 14.0
        circle = new Circle(5); // area = 78.54 perimeter = 31.42

        compoundShape = new CompoundShape();
        compoundShape.add(triangle);
        compoundShape.add(rectangle);
        compoundShape.add(circle);
    }

    @Test
    public void testArea() {
        assertEquals(96.54, compoundShape.area(), 0.01);
    }

    @Test
    public void testPerimeter() {
        assertEquals(57.42, compoundShape.perimeter(), 0.01);
    }
}