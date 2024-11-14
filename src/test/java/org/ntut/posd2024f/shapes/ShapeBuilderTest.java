package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ShapeBuilderTest {
    // Test buildCircle
    @Test
    public void testBuildCircleWithNoColorAndText() {
        ShapeBuilder shapeBuilder = new ShapeBuilder();
        shapeBuilder.buildCircle(3, null, null); // area = 28.274, perimeter = 18.8495

        List<Shape> shapes = shapeBuilder.getResult();

        assertEquals(28.274, shapes.get(0).area(), 0.001);
    }

    @Test
    public void testBuildCircleWithColor() {
        ShapeBuilder shapeBuilder = new ShapeBuilder();
        shapeBuilder.buildCircle(3, "red", null); // area = 28.274, perimeter = 18.8495

        List<Shape> shapes = shapeBuilder.getResult();

        assertEquals(ColoredShape.class, shapes.get(0).getClass());
        assertEquals("red", ((ColoredShape) shapes.get(0)).getColor());
    }

    @Test
    public void testBuildCircleWithText() {
        ShapeBuilder shapeBuilder = new ShapeBuilder();
        shapeBuilder.buildCircle(3, null, "circle"); // area = 28.274, perimeter = 18.8495

        List<Shape> shapes = shapeBuilder.getResult();

        assertEquals(TextedShape.class, shapes.get(0).getClass());
        assertEquals("circle", ((TextedShape) shapes.get(0)).getText());
    }

    @Test
    public void testBuildCircleWithColorAndText() {
        ShapeBuilder shapeBuilder = new ShapeBuilder();
        shapeBuilder.buildCircle(3, "red", "circle"); // area = 28.274, perimeter = 18.8495

        List<Shape> shapes = shapeBuilder.getResult();

        assertEquals(TextedShape.class, shapes.get(0).getClass());
        assertEquals("circle", ((TextedShape) shapes.get(0)).getText());
        assertEquals(ColoredShape.class, ((TextedShape) shapes.get(0)).getShape().getClass());
        assertEquals("red", ((ColoredShape) ((TextedShape) shapes.get(0)).getShape()).getColor());
    }

    // Test buildRectangle
    @Test
    public void testBuildRectangleWithNoColorAndText() {
        ShapeBuilder shapeBuilder = new ShapeBuilder();
        shapeBuilder.buildRectangle(3, 4, null, null); // area = 12, perimeter = 14

        List<Shape> shapes = shapeBuilder.getResult();

        assertEquals(12, shapes.get(0).area(), 0.001);
    }

    @Test
    public void testBuildRectangleWithColor() {
        ShapeBuilder shapeBuilder = new ShapeBuilder();
        shapeBuilder.buildRectangle(3, 4, "red", null); // area = 12, perimeter = 14

        List<Shape> shapes = shapeBuilder.getResult();

        assertEquals(ColoredShape.class, shapes.get(0).getClass());
        assertEquals("red", ((ColoredShape) shapes.get(0)).getColor());
    }

    @Test
    public void testBuildRectangleWithText() {
        ShapeBuilder shapeBuilder = new ShapeBuilder();
        shapeBuilder.buildRectangle(3, 4, null, "rectangle"); // area = 12, perimeter = 14

        List<Shape> shapes = shapeBuilder.getResult();

        assertEquals(TextedShape.class, shapes.get(0).getClass());
        assertEquals("rectangle", ((TextedShape) shapes.get(0)).getText());
    }

    @Test
    public void testBuildRectangleWithColorAndText() {
        ShapeBuilder shapeBuilder = new ShapeBuilder();
        shapeBuilder.buildRectangle(3, 4, "red", "rectangle"); // area = 12, perimeter = 14

        List<Shape> shapes = shapeBuilder.getResult();

        assertEquals(TextedShape.class, shapes.get(0).getClass());
        assertEquals("rectangle", ((TextedShape) shapes.get(0)).getText());
        assertEquals(ColoredShape.class, ((TextedShape) shapes.get(0)).getShape().getClass());
        assertEquals("red", ((ColoredShape) ((TextedShape) shapes.get(0)).getShape()).getColor());
    }

    // Test buildTriangle
    @Test
    public void testBuildTriangleWithNoColorAndText() {
        ShapeBuilder shapeBuilder = new ShapeBuilder();

        List<TwoDimensionalVector> vectors = new ArrayList<TwoDimensionalVector>();
        TwoDimensionalVector v1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector v2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector v3 = new TwoDimensionalVector(1, 5);
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);

        shapeBuilder.buildTriangle(vectors, null, null); // area = 6, perimeter = 12

        List<Shape> shapes = shapeBuilder.getResult();

        assertEquals(6, shapes.get(0).area(), 0.001);
    }
    
    @Test
    public void testBuildTriangleWithColor() {
        ShapeBuilder shapeBuilder = new ShapeBuilder();

        List<TwoDimensionalVector> vectors = new ArrayList<TwoDimensionalVector>();
        TwoDimensionalVector v1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector v2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector v3 = new TwoDimensionalVector(1, 5);
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);

        shapeBuilder.buildTriangle(vectors, "red", null); // area = 6, perimeter = 12

        List<Shape> shapes = shapeBuilder.getResult();

        assertEquals(ColoredShape.class, shapes.get(0).getClass());
        assertEquals("red", ((ColoredShape) shapes.get(0)).getColor());
    }

    @Test
    public void testBuildTriangleWithText() {
        ShapeBuilder shapeBuilder = new ShapeBuilder();

        List<TwoDimensionalVector> vectors = new ArrayList<TwoDimensionalVector>();
        TwoDimensionalVector v1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector v2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector v3 = new TwoDimensionalVector(1, 5);
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);

        shapeBuilder.buildTriangle(vectors, null, "triangle"); // area = 6, perimeter = 12

        List<Shape> shapes = shapeBuilder.getResult();

        assertEquals(TextedShape.class, shapes.get(0).getClass());
        assertEquals("triangle", ((TextedShape) shapes.get(0)).getText());
    }

    @Test
    public void testBuildTriangleWithColorAndText() {
        ShapeBuilder shapeBuilder = new ShapeBuilder();

        List<TwoDimensionalVector> vectors = new ArrayList<TwoDimensionalVector>();
        TwoDimensionalVector v1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector v2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector v3 = new TwoDimensionalVector(1, 5);
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);

        shapeBuilder.buildTriangle(vectors, "red", "triangle"); // area = 6, perimeter = 12

        List<Shape> shapes = shapeBuilder.getResult();

        assertEquals(TextedShape.class, shapes.get(0).getClass());
        assertEquals("triangle", ((TextedShape) shapes.get(0)).getText());
        assertEquals(ColoredShape.class, ((TextedShape) shapes.get(0)).getShape().getClass());
        assertEquals("red", ((ColoredShape) ((TextedShape) shapes.get(0)).getShape()).getColor());
    }

    // Test buildConvexPolygon
    @Test
    public void testBuildConvexPolygonWithNoColorAndText() {
        ShapeBuilder shapeBuilder = new ShapeBuilder();

        List<TwoDimensionalVector> vectors = new ArrayList<TwoDimensionalVector>();
        TwoDimensionalVector v1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector v2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector v3 = new TwoDimensionalVector(1, 5);
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);

        shapeBuilder.buildConvexPolygon(vectors, null, null); // area = 6, perimeter = 12

        List<Shape> shapes = shapeBuilder.getResult();

        assertEquals(6, shapes.get(0).area(), 0.001);
    }

    @Test
    public void testBuildConvexPolygonWithColor() {
        ShapeBuilder shapeBuilder = new ShapeBuilder();

        List<TwoDimensionalVector> vectors = new ArrayList<TwoDimensionalVector>();
        TwoDimensionalVector v1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector v2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector v3 = new TwoDimensionalVector(1, 5);
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);

        shapeBuilder.buildConvexPolygon(vectors, "red", null); // area = 6, perimeter = 12

        List<Shape> shapes = shapeBuilder.getResult();

        assertEquals(ColoredShape.class, shapes.get(0).getClass());
        assertEquals("red", ((ColoredShape) shapes.get(0)).getColor());
    }

    @Test
    public void testBuildConvexPolygonWithText() {
        ShapeBuilder shapeBuilder = new ShapeBuilder();

        List<TwoDimensionalVector> vectors = new ArrayList<TwoDimensionalVector>();
        TwoDimensionalVector v1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector v2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector v3 = new TwoDimensionalVector(1, 5);
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);

        shapeBuilder.buildConvexPolygon(vectors, null, "convexPolygon"); // area = 6, perimeter = 12

        List<Shape> shapes = shapeBuilder.getResult();

        assertEquals(TextedShape.class, shapes.get(0).getClass());
        assertEquals("convexPolygon", ((TextedShape) shapes.get(0)).getText());
    }

    @Test
    public void testBuildConvexPolygonWithColorAndText() {
        ShapeBuilder shapeBuilder = new ShapeBuilder();

        List<TwoDimensionalVector> vectors = new ArrayList<TwoDimensionalVector>();
        TwoDimensionalVector v1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector v2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector v3 = new TwoDimensionalVector(1, 5);
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);

        shapeBuilder.buildConvexPolygon(vectors, "red", "convexPolygon"); // area = 6, perimeter = 12

        List<Shape> shapes = shapeBuilder.getResult();

        assertEquals(TextedShape.class, shapes.get(0).getClass());
        assertEquals("convexPolygon", ((TextedShape) shapes.get(0)).getText());
        assertEquals(ColoredShape.class, ((TextedShape) shapes.get(0)).getShape().getClass());
        assertEquals("red", ((ColoredShape) ((TextedShape) shapes.get(0)).getShape()).getColor());
    }

    // Test buildCompoundShape
    @Test
    public void testBuildCompoundShapeWithNoColorAndText() {
        ShapeBuilder shapeBuilder = new ShapeBuilder();
        shapeBuilder.beginBuildCompoundShape(null, null);
        shapeBuilder.buildCircle(3, null, null); // area = 28.274
        shapeBuilder.buildRectangle(3, 4, null, null); // area = 12
        shapeBuilder.endBuildCompoundShape();

        List<Shape> shapes = shapeBuilder.getResult();

        assertEquals(CompoundShape.class, shapes.get(0).getClass());
        assertEquals(40.274, shapes.get(0).area(), 0.001);
    }

    @Test
    public void testBuildCompoundShapeWithColor() {
        ShapeBuilder shapeBuilder = new ShapeBuilder();
        shapeBuilder.beginBuildCompoundShape("red", null);
        shapeBuilder.buildCircle(3, null, null); // area = 28.274
        shapeBuilder.buildRectangle(3, 4, null, null); // area = 12
        shapeBuilder.endBuildCompoundShape();

        List<Shape> shapes = shapeBuilder.getResult();

        assertEquals(ColoredShape.class, shapes.get(0).getClass());
        assertEquals("red", ((ColoredShape) shapes.get(0)).getColor());
    }

    @Test
    public void testBuildCompoundShapeWithText() {
        ShapeBuilder shapeBuilder = new ShapeBuilder();
        shapeBuilder.beginBuildCompoundShape(null, "compoundShape");
        shapeBuilder.buildCircle(3, null, null); // area = 28.274
        shapeBuilder.buildRectangle(3, 4, null, null); // area = 12
        shapeBuilder.endBuildCompoundShape();

        List<Shape> shapes = shapeBuilder.getResult();

        assertEquals(TextedShape.class, shapes.get(0).getClass());
        assertEquals("compoundShape", ((TextedShape) shapes.get(0)).getText());
    }

    @Test
    public void testBuildCompoundShapeWithColorAndText() {
        ShapeBuilder shapeBuilder = new ShapeBuilder();
        shapeBuilder.beginBuildCompoundShape("red", "compoundShape");
        shapeBuilder.buildCircle(3, null, null); // area = 28.274
        shapeBuilder.buildRectangle(3, 4, null, null); // area = 12
        shapeBuilder.endBuildCompoundShape();

        List<Shape> shapes = shapeBuilder.getResult();

        assertEquals(TextedShape.class, shapes.get(0).getClass());
        assertEquals("compoundShape", ((TextedShape) shapes.get(0)).getText());
        assertEquals(ColoredShape.class, ((TextedShape) shapes.get(0)).getShape().getClass());
        assertEquals("red", ((ColoredShape) ((TextedShape) shapes.get(0)).getShape()).getColor());
    }
}
