package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

@SuppressWarnings("unused")
public class ConvexPolygonTest {
    @Test
    public void testConstructor(){
        TwoDimensionalVector vector1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector vector3 = new TwoDimensionalVector(6, 3);
        TwoDimensionalVector vector4 = new TwoDimensionalVector(4, 5);
        TwoDimensionalVector vector5 = new TwoDimensionalVector(1, 5);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);
        vectors.add(vector4);
        vectors.add(vector5);
        
        ConvexPolygon convexPolygon = new ConvexPolygon(vectors);

    }

    @Test
    public void testConstructorWithTwoPallarelVector(){
        TwoDimensionalVector vector1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(2, 1);
        TwoDimensionalVector vector3 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector vector4 = new TwoDimensionalVector(6, 3);
        TwoDimensionalVector vector5 = new TwoDimensionalVector(4, 5);
        TwoDimensionalVector vector6 = new TwoDimensionalVector(1, 5);
        TwoDimensionalVector vector7 = new TwoDimensionalVector(1, 4);


        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);
        vectors.add(vector4);
        vectors.add(vector5);
        vectors.add(vector6);
        vectors.add(vector7);
        
        ConvexPolygon convexPolygon = new ConvexPolygon(vectors);

    }

    @Test
    public void testConstructorWithClockwiseDirection(){
        TwoDimensionalVector vector1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(1, 5);
        TwoDimensionalVector vector3 = new TwoDimensionalVector(4, 5);
        TwoDimensionalVector vector4 = new TwoDimensionalVector(6, 3);
        TwoDimensionalVector vector5 = new TwoDimensionalVector(4, 1);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);
        vectors.add(vector4);
        vectors.add(vector5);
        
        ConvexPolygon convexPolygon = new ConvexPolygon(vectors);
    }

    @Test
    public void testConstructorWithCounterclockwiseDirection(){
        TwoDimensionalVector vector1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector vector3 = new TwoDimensionalVector(6, 3);
        TwoDimensionalVector vector4 = new TwoDimensionalVector(4, 5);
        TwoDimensionalVector vector5 = new TwoDimensionalVector(1, 5);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);
        vectors.add(vector4);
        vectors.add(vector5);
        
        ConvexPolygon convexPolygon = new ConvexPolygon(vectors);
    }

    @Test
    public void testConstructorWithTwoVectors(){
        TwoDimensionalVector side1 = new TwoDimensionalVector(3, 0);
        TwoDimensionalVector side2 = new TwoDimensionalVector(-3, 4);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(side1);
        vectors.add(side2);

        ShapeException exception = assertThrows(ShapeException.class, () -> {
            ConvexPolygon convexPolygon = new ConvexPolygon(vectors);
        });

        assertEquals("It's not a convex polygon!", exception.getMessage());
    }

    @Test
    public void testConstructorWithUnsortedVectors(){
        TwoDimensionalVector vector1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector vector3 = new TwoDimensionalVector(4, 5);
        TwoDimensionalVector vector4 = new TwoDimensionalVector(6, 3);
        TwoDimensionalVector vector5 = new TwoDimensionalVector(1, 5);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);
        vectors.add(vector4);
        vectors.add(vector5);

        ShapeException exception = assertThrows(ShapeException.class, () -> {
            ConvexPolygon convexPolygon = new ConvexPolygon(vectors);
        });

        assertEquals("It's not a convex polygon!", exception.getMessage());
    }

    @Test
    public void testConstructorWithNotConvexPolygon(){
        TwoDimensionalVector vector1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector vector3 = new TwoDimensionalVector(3, 3);
        TwoDimensionalVector vector4 = new TwoDimensionalVector(4, 5);
        TwoDimensionalVector vector5 = new TwoDimensionalVector(1, 5);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);
        vectors.add(vector4);
        vectors.add(vector5);

        ShapeException exception = assertThrows(ShapeException.class, () -> {
            ConvexPolygon convexPolygon = new ConvexPolygon(vectors);
        });

        assertEquals("It's not a convex polygon!", exception.getMessage());
    }

    @Test
    public void testArea(){
        TwoDimensionalVector vector1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector vector3 = new TwoDimensionalVector(6, 3);
        TwoDimensionalVector vector4 = new TwoDimensionalVector(4, 5);
        TwoDimensionalVector vector5 = new TwoDimensionalVector(1, 5);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);
        vectors.add(vector4);
        vectors.add(vector5);

        ConvexPolygon convexPolygon = new ConvexPolygon(vectors);
        assertEquals(16.0, convexPolygon.area(), 0.01);
    }

    @Test
    public void testPerimeter(){
        TwoDimensionalVector vector1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector vector3 = new TwoDimensionalVector(6, 3);
        TwoDimensionalVector vector4 = new TwoDimensionalVector(4, 5);
        TwoDimensionalVector vector5 = new TwoDimensionalVector(1, 5);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);
        vectors.add(vector4);
        vectors.add(vector5);

        ConvexPolygon convexPolygon = new ConvexPolygon(vectors);
        assertEquals(15.66, convexPolygon.perimeter(), 0.01);
    }

    @Test
    public void testConvexWithRectangle(){
        TwoDimensionalVector vector1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(3, 1);
        TwoDimensionalVector vector3 = new TwoDimensionalVector(3, 6);
        TwoDimensionalVector vector4 = new TwoDimensionalVector(1, 6);

        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);
        vectors.add(vector4);

        ConvexPolygon convexPolygon = new ConvexPolygon(vectors); // area = 10, perimeter = 14

        assertEquals(10, convexPolygon.area(), 0.01);
        assertEquals(14, convexPolygon.perimeter(), 0.01);
    }
}