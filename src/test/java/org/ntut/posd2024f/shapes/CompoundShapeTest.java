package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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

    @BeforeAll
    public static void setUp() {
        TwoDimensionalVector vector1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector vector3 = new TwoDimensionalVector(1, 5);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);

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
