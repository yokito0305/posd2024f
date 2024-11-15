package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ShapeParserTest {
    // Test open file
    @Test
    public void testParserOpenFile() {
        String path = "src/test_data/complex_shape.txt";
        File file = new File(path);
        new ShapeParser(file);
    }

    @Test
    public void testParserOpenFileFail() {
        String path = "src/test_data/notfount.txt";
        File file = new File(path);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            new ShapeParser(file);
        });
        assertEquals("File not found", exception.getMessage());
    }

    // Test Circle
    @Test
    public void testParserWithCircle() {
        String path = "src/test_data/circle.txt";
        File file = new File(path);
        ShapeParser parser = new ShapeParser(file);
        parser.parse();

        List<Shape> shapes = parser.getResult();
        assertEquals(1, shapes.size());
        assertEquals(TextedShape.class, shapes.get(0).getClass());
        assertEquals("This is a circle", ((TextedShape)shapes.get(0)).getText());
        Shape coloredShape = ((TextedShape)shapes.get(0)).getShape();
        assertEquals(ColoredShape.class, coloredShape.getClass());
        assertEquals("RED", ((ColoredShape)coloredShape).getColor());
        Shape circle = ((ColoredShape)coloredShape).getShape();
        assertEquals(Circle.class, circle.getClass());
        assertEquals(3.0, ((Circle)circle).getRadius());
    }

    @Test
    public void testParserWithRedCircle() {
        String path = "src/test_data/circle_red.txt";
        File file = new File(path);
        ShapeParser parser = new ShapeParser(file);
        parser.parse();

        List<Shape> shapes = parser.getResult();
        assertEquals(1, shapes.size());
        assertEquals(ColoredShape.class, shapes.get(0).getClass());
        assertEquals("RED", ((ColoredShape)shapes.get(0)).getColor());
        Shape circle = ((ColoredShape)shapes.get(0)).getShape();
        assertEquals(Circle.class, circle.getClass());
        assertEquals(3.0, ((Circle)circle).getRadius());
    }

    @Test
    public void testParserWithCircleWithText() {
        String path = "src/test_data/circle_text.txt";
        File file = new File(path);
        ShapeParser parser = new ShapeParser(file);
        parser.parse();

        List<Shape> shapes = parser.getResult();
        assertEquals(1, shapes.size());
        assertEquals(TextedShape.class, shapes.get(0).getClass());
        assertEquals("This is a circle", ((TextedShape)shapes.get(0)).getText());
        Shape circle = ((TextedShape)shapes.get(0)).getShape();
        assertEquals(Circle.class, circle.getClass());
        assertEquals(3.0, ((Circle)circle).getRadius());
    }

    // Test Rectangle
    @Test
    public void testParserWithRectangle() {
        String path = "src/test_data/rectangle.txt";
        File file = new File(path);
        ShapeParser parser = new ShapeParser(file);
        parser.parse();

        List<Shape> shapes = parser.getResult();
        assertEquals(1, shapes.size());
        assertEquals(TextedShape.class, shapes.get(0).getClass());
        assertEquals("This is a rectangle", ((TextedShape)shapes.get(0)).getText());
        Shape coloredShape = ((TextedShape)shapes.get(0)).getShape();
        assertEquals(ColoredShape.class, coloredShape.getClass());
        assertEquals("RED", ((ColoredShape)coloredShape).getColor());
        Shape rectangle = ((ColoredShape)coloredShape).getShape();
        assertEquals(Rectangle.class, rectangle.getClass());
        // area = 3.0 * 4.0 = 12.0, perimeter = 2 * (3.0 + 4.0) = 14.0
        assertEquals(12.0, ((Rectangle)rectangle).area());
        assertEquals(14.0, ((Rectangle)rectangle).perimeter());
    }

    @Test
    public void testParserWithRedRectangle() {
        String path = "src/test_data/rectangle_red.txt";
        File file = new File(path);
        ShapeParser parser = new ShapeParser(file);
        parser.parse();

        List<Shape> shapes = parser.getResult();
        assertEquals(1, shapes.size());
        assertEquals(ColoredShape.class, shapes.get(0).getClass());
        assertEquals("RED", ((ColoredShape)shapes.get(0)).getColor());
        Shape rectangle = ((ColoredShape)shapes.get(0)).getShape();
        assertEquals(Rectangle.class, rectangle.getClass());
        // area = 3.0 * 4.0 = 12.0, perimeter = 2 * (3.0 + 4.0) = 14.0
        assertEquals(12.0, ((Rectangle)rectangle).area());
        assertEquals(14.0, ((Rectangle)rectangle).perimeter());
    }

    @Test
    public void testParserWithRectangleWithText() {
        String path = "src/test_data/rectangle_text.txt";
        File file = new File(path);
        ShapeParser parser = new ShapeParser(file);
        parser.parse();

        List<Shape> shapes = parser.getResult();
        assertEquals(1, shapes.size());
        assertEquals(TextedShape.class, shapes.get(0).getClass());
        assertEquals("This is a rectangle", ((TextedShape)shapes.get(0)).getText());
        Shape rectangle = ((TextedShape)shapes.get(0)).getShape();
        assertEquals(Rectangle.class, rectangle.getClass());
        // area = 3.0 * 4.0 = 12.0, perimeter = 2 * (3.0 + 4.0) = 14.0
        assertEquals(12.0, ((Rectangle)rectangle).area());
        assertEquals(14.0, ((Rectangle)rectangle).perimeter());
    }

    // Test Triangle
    @Test
    public void testParserWithTriangle() {
        String path = "src/test_data/triangle.txt";
        File file = new File(path);
        ShapeParser parser = new ShapeParser(file);
        parser.parse();

        List<Shape> shapes = parser.getResult();
        assertEquals(1, shapes.size());
        assertEquals(TextedShape.class, shapes.get(0).getClass());
        assertEquals("This is a triangle", ((TextedShape)shapes.get(0)).getText());
        Shape coloredShape = ((TextedShape)shapes.get(0)).getShape();
        assertEquals(ColoredShape.class, coloredShape.getClass());
        assertEquals("RED", ((ColoredShape)coloredShape).getColor());
        Shape triangle = ((ColoredShape)coloredShape).getShape();
        assertEquals(Triangle.class, triangle.getClass());
        // area = 6, perimeter = 12
        assertEquals(6.0, ((Triangle)triangle).area());
        assertEquals(12.0, ((Triangle)triangle).perimeter());
    }

    // Expected token '['
    @Test
    public void testParserTriangleWithIllegalLeftBracket() {
        String path = "src/test_data/triangle_illegal.txt";
        File file = new File(path);
        ShapeParser parser = new ShapeParser(file);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            parser.parse();
        });
        parser.parse();
        assertEquals("Expected token '['", exception.getMessage());
    }

    // Expected token ']'
    @Test
    public void testParserTriangleWithIllegalRightBracket() {
        String path = "src/test_data/triangle_illegal2.txt";
        File file = new File(path);
        ShapeParser parser = new ShapeParser(file);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            parser.parse();
        });
        parser.parse();
        assertEquals("Expected token ']'", exception.getMessage());
    }

    // Expected token ','
    @Test
    public void testParserTriangleWithIllegalComma() {
        String path = "src/test_data/triangle_illegal3.txt";
        File file = new File(path);
        ShapeParser parser = new ShapeParser(file);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            parser.parse();
        });
        parser.parse();
        assertEquals("Expected token ','", exception.getMessage());
    }

    // test convexPolygon
    @Test
    public void testParserWithConvexPolygon() {
        String path = "src/test_data/convexPolygon.txt";
        File file = new File(path);
        ShapeParser parser = new ShapeParser(file);
        parser.parse();

        List<Shape> shapes = parser.getResult();
        assertEquals(1, shapes.size());
        assertEquals(TextedShape.class, shapes.get(0).getClass());
        assertEquals("This is a convexPolygon", ((TextedShape)shapes.get(0)).getText());
        Shape coloredShape = ((TextedShape)shapes.get(0)).getShape();
        assertEquals(ColoredShape.class, coloredShape.getClass());
        assertEquals("RED", ((ColoredShape)coloredShape).getColor());
        Shape convexPolygon = ((ColoredShape)coloredShape).getShape();
        assertEquals(ConvexPolygon.class, convexPolygon.getClass());
        // area = 6, perimeter = 12
        assertEquals(6.0, ((ConvexPolygon)convexPolygon).area());
        assertEquals(12.0, ((ConvexPolygon)convexPolygon).perimeter());
     }

    // Expected token '['
    @Test
    public void testParserConvexPolygonWithIllegalLeftBracket() {
        String path = "src/test_data/convexPolygon_illegal.txt";
        File file = new File(path);
        ShapeParser parser = new ShapeParser(file);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            parser.parse();
        });
        parser.parse();
        assertEquals("Expected token '['", exception.getMessage());
    }

    // Expected token ']'
    @Test
    public void testParserConvexPolygonWithIllegalRightBracket() {
        String path = "src/test_data/convexPolygon_illegal2.txt";
        File file = new File(path);
        ShapeParser parser = new ShapeParser(file);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            parser.parse();
        });
        parser.parse();
        assertEquals("Expected token ']'", exception.getMessage());
    }

    // Expected token ','
    @Test
    public void testParserConvexPolygonWithIllegalComma() {
        String path = "src/test_data/convexPolygon_illegal3.txt";
        File file = new File(path);
        ShapeParser parser = new ShapeParser(file);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            parser.parse();
        });
        parser.parse();
        assertEquals("Expected token ','", exception.getMessage());
    }

    // test compoundShape
    @Test
    public void testParserWithCompoundShape() {
        String path = "src/test_data/compoundShape.txt";
        File file = new File(path);
        ShapeParser parser = new ShapeParser(file);
        parser.parse();

        List<Shape> shapes = parser.getResult();
        assertEquals(1, shapes.size());
        assertEquals(CompoundShape.class, shapes.get(0).getClass());
        Iterator<Shape> iterator = ((CompoundShape)shapes.get(0)).iterator();
        assertEquals(Circle.class, iterator.next().getClass());
        assertEquals(Rectangle.class, iterator.next().getClass());
        assertFalse(iterator.hasNext());
    }

    // Expected token '{'
    @Test
    public void testParserCompoundShapeWithIllegalLeftBracket() {
        String path = "src/test_data/compoundShape_illegal.txt";
        File file = new File(path);
        ShapeParser parser = new ShapeParser(file);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            parser.parse();
        });
        parser.parse();
        assertEquals("Expected token '{'", exception.getMessage());
    }

    // Expected token '{'
    @Test
    public void testParserEmptyCompoundShapeWithIllegalLeftBracket() {
        String path = "src/test_data/compoundShape_illegal3.txt";
        File file = new File(path);
        ShapeParser parser = new ShapeParser(file);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            parser.parse();
        });
        parser.parse();
        assertEquals("Expected token '{'", exception.getMessage());
    }

    // Expected token '}'
    @Test
    public void testParserEmptyCompoundShapeWithIllegalRightBracket() {
        String path = "src/test_data/compoundShape_illegal2.txt";
        File file = new File(path);
        ShapeParser parser = new ShapeParser(file);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            parser.parse();
        });
        parser.parse();
        assertEquals("Expected token '}'", exception.getMessage());
    }

    // Expected token '}'
    @Test
    public void testParserEmptyCompoundShapeWithIllegalRightBracket2() {
        String path = "src/test_data/compoundShape_illegal4.txt";
        File file = new File(path);
        ShapeParser parser = new ShapeParser(file);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            parser.parse();
        });
        parser.parse();
        assertEquals("Expected token '}'", exception.getMessage());
    }

    // test nestedCompoundShape
    @Test
    public void testParserWithNestedCompoundShape() {
        String path = "src/test_data/nestedCompoundShape.txt";
        File file = new File(path);
        ShapeParser parser = new ShapeParser(file);
        parser.parse();

        List<Shape> shapes = parser.getResult();
        assertEquals(1, shapes.size());
        assertEquals(CompoundShape.class, shapes.get(0).getClass());
        Iterator<Shape> iterator = ((CompoundShape)shapes.get(0)).iterator();
        assertEquals(Circle.class, iterator.next().getClass());

        CompoundShape compoundShape = (CompoundShape)iterator.next();
        assertEquals(CompoundShape.class, compoundShape.getClass());
        Iterator<Shape> iterator2 = compoundShape.iterator();
        assertEquals(Circle.class, iterator2.next().getClass());
        assertEquals(Rectangle.class, iterator2.next().getClass());
        assertFalse(iterator2.hasNext());

        assertEquals(Rectangle.class, iterator.next().getClass());
        assertFalse(iterator.hasNext());
    }

    // test emptyCompoundShape
    @Test
    public void testParserWithEmptyCompoundShape() {
        String path = "src/test_data/emptyCompoundShape.txt";
        File file = new File(path);
        ShapeParser parser = new ShapeParser(file);
        parser.parse();

        List<Shape> shapes = parser.getResult();
        assertEquals(1, shapes.size());
        assertEquals(CompoundShape.class, shapes.get(0).getClass());
        assertFalse(((CompoundShape)shapes.get(0)).iterator().hasNext());
    }


    // other test
    @Test
    public void testStringSplit() {
        String line = "Circle 3.0";
        // split : 'Circle 3.0', 'color=RED', 'text=This is a circle'
        String[] info = line.split(", ");
        assertEquals("Circle 3.0", info[0]);
    }
}
