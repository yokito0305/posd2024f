package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.text.AbstractDocument.Content;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

@SuppressWarnings("unused")
public class ShapeTest {
    private static Circle circle;
    private static Triangle triangle;
    private static Rectangle rectangle;
    private static ArrayList<Shape> shapes;

    @BeforeAll
    public static void setUp() {
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
    public void testByArea() {
        assertEquals(circle.area(), shapes.get(0).area(), 0.01);
        assertEquals(triangle.area(), shapes.get(1).area(), 0.01);
        assertEquals(rectangle.area(), shapes.get(2).area(), 0.01);
    }

    @Test
    public void testByPerimeter() {
        assertEquals(circle.perimeter(), shapes.get(0).perimeter(), 0.01);
        assertEquals(triangle.perimeter(), shapes.get(1).perimeter(), 0.01);
        assertEquals(rectangle.perimeter(), shapes.get(2).perimeter(), 0.01);
    }
}