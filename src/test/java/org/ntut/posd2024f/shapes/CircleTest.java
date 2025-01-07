package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class CircleTest {
    @Test
    public void testCircleCreate(){
        new Circle(3);
    }

    @Test
    public void testCircleCreateWithZero(){
        ShapeException exception = assertThrows(ShapeException.class, () -> new Circle(0));
        assertEquals("It's not a circle!", exception.getMessage());
    }

    @Test
    public void testCircleArea(){
        Circle circle = new Circle(3); // area = 28.274
        assertEquals(28.274, circle.area(), 0.001);
    }

    @Test
    public void testCirclePerimeter(){
        Circle circle = new Circle(3); // perimeter = 18.8495
        assertEquals(18.849, circle.perimeter(), 0.001);
    }

    @Test
    public void testGetRadius(){
        Circle circle = new Circle(3);
        assertEquals(3, circle.getRadius());
    }

    @Test
    public void foo(){
        String s = "Circle 3.0, color=RED, text=This is a circle";
        Scanner scanner = new Scanner(s);
        scanner.useDelimiter("(?<=\\[)|(?=\\[)|(?<=\\])|(?=\\])|,\\s*|\\s+|=");
        
        System.out.println(scanner.next()); // Circle
        System.out.println(scanner.nextDouble()); // 3.0
        System.out.println(scanner.next()); // color
        System.out.println(scanner.next()); // Red
        System.out.println(scanner.next()); // text
        scanner.useDelimiter("=|\n");
        System.out.println(scanner.next()); // This is a circle

        scanner.close();
    }
}