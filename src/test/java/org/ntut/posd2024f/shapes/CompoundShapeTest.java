package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class CompoundShapeTest {
    @Test
    public void testCompoundShapeCreate() {
        new CompoundShape();
    }

    @Test
    public void testCompoundShapeAdd() {
        // setup
        Circle circle = new Circle(3); // circle : area = 28.274, perimeter = 18.8495
        Rectangle rectangle = new Rectangle(4, 5); // rectangle : area = 20, perimeter = 18

        List<TwoDimensionalVector> vectors1 = new ArrayList<>();
        TwoDimensionalVector coord1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector coord2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector coord3 = new TwoDimensionalVector(1, 5);
        vectors1.add(coord1);
        vectors1.add(coord2);
        vectors1.add(coord3);
        Triangle triangle = new Triangle(vectors1); // triangle : area = 6, perimeter = 12

        List<TwoDimensionalVector> vectors2 = new ArrayList<>();
        TwoDimensionalVector coord4 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector coord5 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector coord6 = new TwoDimensionalVector(7, 4);
        TwoDimensionalVector coord7 = new TwoDimensionalVector(4, 7);
        TwoDimensionalVector coord8 = new TwoDimensionalVector(1, 7);
        vectors2.add(coord4);
        vectors2.add(coord5);
        vectors2.add(coord6);
        vectors2.add(coord7);
        vectors2.add(coord8);
        ConvexPolygon convexPolygon = new ConvexPolygon(vectors2); // area = 27, perimeter = 3 + 6 + 3 + (2 * sqrt(18))

        // test
        CompoundShape compoundShape = new CompoundShape();
        compoundShape.add(circle);
        compoundShape.add(rectangle);
        compoundShape.add(triangle);
        compoundShape.add(convexPolygon);

        //assertEquals(4, compoundShape.list.size());
    }

    @Test
    public void testCompoundShapeArea() {
        // setup
        Circle circle = new Circle(3); // circle : area = 28.274, perimeter = 18.8495
        Rectangle rectangle = new Rectangle(4, 5); // rectangle : area = 20, perimeter = 18

        List<TwoDimensionalVector> vectors1 = new ArrayList<>();
        TwoDimensionalVector coord1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector coord2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector coord3 = new TwoDimensionalVector(1, 5);
        vectors1.add(coord1);
        vectors1.add(coord2);
        vectors1.add(coord3);
        Triangle triangle = new Triangle(vectors1); // triangle : area = 6, perimeter = 12

        List<TwoDimensionalVector> vectors2 = new ArrayList<>();
        TwoDimensionalVector coord4 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector coord5 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector coord6 = new TwoDimensionalVector(7, 4);
        TwoDimensionalVector coord7 = new TwoDimensionalVector(4, 7);
        TwoDimensionalVector coord8 = new TwoDimensionalVector(1, 7);
        vectors2.add(coord4);
        vectors2.add(coord5);
        vectors2.add(coord6);
        vectors2.add(coord7);
        vectors2.add(coord8);
        ConvexPolygon convexPolygon = new ConvexPolygon(vectors2); // area = 27, perimeter = 3 + 6 + 3 + (2 * sqrt(18))

        // test
        CompoundShape compoundShape = new CompoundShape();
        compoundShape.add(circle);
        compoundShape.add(rectangle);
        compoundShape.add(triangle);
        compoundShape.add(convexPolygon);

        double area = circle.area() + triangle.area() + rectangle.area() + convexPolygon.area();
        assertEquals(area, compoundShape.area(), 0.01);
    }

    @Test
    public void testCompoundShapePerimeter() {
        // setup
        Circle circle = new Circle(3); // circle : area = 28.274, perimeter = 18.8495
        Rectangle rectangle = new Rectangle(4, 5); // rectangle : area = 20, perimeter = 18

        List<TwoDimensionalVector> vectors1 = new ArrayList<>();
        TwoDimensionalVector coord1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector coord2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector coord3 = new TwoDimensionalVector(1, 5);
        vectors1.add(coord1);
        vectors1.add(coord2);
        vectors1.add(coord3);
        Triangle triangle = new Triangle(vectors1); // triangle : area = 6, perimeter = 12

        List<TwoDimensionalVector> vectors2 = new ArrayList<>();
        TwoDimensionalVector coord4 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector coord5 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector coord6 = new TwoDimensionalVector(7, 4);
        TwoDimensionalVector coord7 = new TwoDimensionalVector(4, 7);
        TwoDimensionalVector coord8 = new TwoDimensionalVector(1, 7);
        vectors2.add(coord4);
        vectors2.add(coord5);
        vectors2.add(coord6);
        vectors2.add(coord7);
        vectors2.add(coord8);
        ConvexPolygon convexPolygon = new ConvexPolygon(vectors2); // area = 27, perimeter = 3 + 6 + 3 + (2 * sqrt(18))

        // test
        CompoundShape compoundShape = new CompoundShape();
        compoundShape.add(circle);
        compoundShape.add(rectangle);
        compoundShape.add(triangle);
        compoundShape.add(convexPolygon);

        double perimeter = circle.perimeter() + triangle.perimeter() + rectangle.perimeter() + convexPolygon.perimeter();
        assertEquals(perimeter, compoundShape.perimeter(), 0.01);
    }

    @Test
    public void testCompoundShapeIterator() {
        Circle circle = new Circle(3); // circle : area = 28.274, perimeter = 18.8495
        Rectangle rectangle = new Rectangle(4, 5); // rectangle : area = 20, perimeter = 18

        CompoundShape compoundShape = new CompoundShape();
        compoundShape.add(circle);
        compoundShape.add(rectangle);

        Iterator<Shape> iterator = compoundShape.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(circle.getClass(), iterator.next().getClass());
    }

    @Test
    public void foo() {
        String s = "text=This is a compound shape {}";
        s = s.substring(0, s.indexOf("{"));
        System.out.println(s);
    }
}
