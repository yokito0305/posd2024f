package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class TriangleTest {
    @Test
    public void testTriangleCreate() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        TwoDimensionalVector v1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector v2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector v3 = new TwoDimensionalVector(1, 5);
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);

        new Triangle(vectors); // area = 6, perimeter = 12
    }

    @Test
    public void testTriangleCreateWithTwoVectors() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        TwoDimensionalVector v1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector v2 = new TwoDimensionalVector(4, 1);
        vectors.add(v1);
        vectors.add(v2);

        ShapeException exception = assertThrows(ShapeException.class, () -> new Triangle(vectors));
        assertEquals("It's not a triangle!", exception.getMessage());
    }

    @Test
    public void testTriangleCreateWithThreeVectorsOnSameLine() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        TwoDimensionalVector v1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector v2 = new TwoDimensionalVector(2, 2);
        TwoDimensionalVector v3 = new TwoDimensionalVector(3, 3);
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);

        ShapeException exception = assertThrows(ShapeException.class, () -> new Triangle(vectors));
        assertEquals("It's not a triangle!", exception.getMessage());
    }

    @Test
    public void testTriangleCreateWithThreeVectorsOnSamePoint() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        TwoDimensionalVector v1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector v2 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector v3 = new TwoDimensionalVector(1, 1);
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);

        ShapeException exception = assertThrows(ShapeException.class, () -> new Triangle(vectors));
        assertEquals("It's not a triangle!", exception.getMessage());
    }

    @Test
    public void testTriangleArea() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        TwoDimensionalVector v1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector v2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector v3 = new TwoDimensionalVector(1, 5);
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);

        Triangle triangle = new Triangle(vectors); // area = 6
        assertEquals(6, triangle.area());
    }

    @Test
    public void testTrianglePerimeter() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        TwoDimensionalVector v1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector v2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector v3 = new TwoDimensionalVector(1, 5);
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);

        Triangle triangle = new Triangle(vectors); // perimeter = 12
        assertEquals(12, triangle.perimeter());
    }

    @Test
    public void testTriangleGetVectors() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        TwoDimensionalVector v1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector v2 = new TwoDimensionalVector(4, 1);
        TwoDimensionalVector v3 = new TwoDimensionalVector(1, 5);
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);

        Triangle triangle = new Triangle(vectors);
        assertEquals(vectors, triangle.getVectors());
    }

    @Test
    public void foo() {
        String input = "Triangle [1,1] [4,1] [1,5], color=RED, text=This is a triangle";
        Scanner scanner = new Scanner(input).useDelimiter(", ");

        while (scanner.hasNext()) {
            String token = scanner.next();
            System.out.println(token);
        }
        scanner.close();
    }

    @Test
    public void foo2() {
        String input = "Triangle [1,1] [4,1] [1,5], color=RED, text=This is a triangle\n" + 
                        "CompoundShape {\n" + 
                        "  Circle 3.0\n" + 
                        "  Rectangle 3.0 4.0\n" + 
                        "}";
        Scanner scanner = new Scanner(input).useDelimiter(", ");

        while (scanner.hasNext()) {
            String token = scanner.next();
            System.out.println(token);
        }
        scanner.close();
    }

    @Test
    public void foo3TestVector() {
        String input = " [13,1] [4,1] [1,5]";
        Scanner scanner = new Scanner(input);
        scanner.useDelimiter("\\s+|(?<=\\[)|(?=\\[)|(?<=\\])|(?=\\])|(?<=,)|(?=,)");
        assertEquals("[", scanner.next());
        assertEquals("13", scanner.next());
        assertEquals(",", scanner.next());
        assertEquals("1", scanner.next());
        assertEquals("]", scanner.next());
        assertEquals("[", scanner.next());
        assertEquals("4", scanner.next());
        assertEquals(",", scanner.next());
        assertEquals("1", scanner.next());
        assertEquals("]", scanner.next());
        assertEquals("[", scanner.next());
        assertEquals("1", scanner.next());
        assertEquals(",", scanner.next());
        assertEquals("5", scanner.next());
        assertEquals("]", scanner.next());

        scanner.close();
    }

    @Test
    public void testParseTriangle() {
        String input = "Triangle [1,1] [4,1] [1,5]";
        String path = "src/test_data/emptyCompoundShape2.txt";
        File file = new File(path);
        ShapeParser parser = new ShapeParser(file);
        Scanner scanner = new Scanner(input);

        scanner.useDelimiter(" ");
        assertEquals("Triangle", scanner.next());

        List<TwoDimensionalVector> vectors = parser.parseTwoDimensionalVectors(scanner);
        assertEquals(3, vectors.size());

       }
}