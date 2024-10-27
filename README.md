## Pattern Oriented Software Design 2024 Fall Assignment

## Important Links
- [Course Link](http://140.124.181.100/yccheng/posd2024f)
- [Gitlab](http://140.124.181.100)
- [Jenkins](http://140.124.181.97:8080)
- [Microsoft Teams](https://teams.microsoft.com/l/team/19%3AoQBubdF152LO2WVrJMRHVX7rOx0wb_v4twMSorq8Va81%40thread.tacv2/conversations?groupId=f0cff185-d612-415d-8bf9-76ed37baeee0&tenantId=dfb5e216-2b8a-4b32-b1cb-e786a1095218)
- [Environment Setting](http://140.124.181.100/course/posd2024f_ta/tree/environment_setting)

## Assignment List

* [Assignment 1](http://140.124.181.100/course/posd2024f_ta/tree/assignment1): Due 9/15 23:59
* [Assignment 2](http://140.124.181.100/course/posd2024f_ta/tree/assignment2): Due 10/7 13:00
* [Assignment 3](#assignment-3): Due ~~10/14 13:00~~ 10/15 14:00

## Assignment 3
**Deadline**: 13:00 on Oct 14, 2024.

**Notice**:
1. If your code fails to compile on Jenkins server, you'll get no point for the assignment.
2. If the unit tests written by yourself fails, you'll get no point for the unit tests written by TA.

Here's [the code](http://140.124.181.100/course/posd2024f_ta/-/tree/assignment_template_code) modified from the code written in class, please download and add them to your homework repository.

**Attention: Please ensure you use the pom.xml file in the template code; otherwise, you will have trouble running it on Jenkins.**

**Attention: From this assignment, the test engine is revised from _org.junit_ to _org.junit.jupiter.api.Assertions_. Please refer to the pom.xml.**

**Note: Each class in the sample file is the skeleton. You should finish implementation by yourself.**

For this Assignment, you'll [implement the **Decorator pattern**](#specification-1-decorator-pattern), and [implement the **Visitor pattern**](#specification-2-visitor-pattern) based on the Assignment 2.

Please complete the given code to satisfy all the following conditions.

### Specification 1: Decorator Pattern
* Please implement the class - `TextedShape`.
    - The class `TextedShape` is a shape that contains a shape and a text. It has a shape and a text as its attributes.
    - The class `TextedShape` has the following methods:
        - `getText()`: return the text of the shape.
        - `getShape()`: return the decorated shape.
    - The class `TextedShape` needs to implement or override the methods on the `Shape` interface.

* Please implement the class - `ColoredShape`.
    - The class `ColoredShape` is a shape that contains a shape and a color. It has a shape and a color as its attributes.
    - The color is represented by a string. The color can be `RED`, `GREEN`, or `BLUE`.
    - The class `ColoredShape` has the following methods:
        - `getColor()`: return the color of the shape.
        - `getShape()`: return the decorated shape.
    - The class `ColoredShape` needs to implement or override the methods on the `Shape` interface.

* The class `TextedShape` and `ColoredShape` should be able to decorate any shape.
    - For example, a `TextedShape` can decorate a `ColoredShape`, and a `ColoredShape` can decorate a `TextedShape`.

### Specification 2: Visitor Pattern
* The interface `Visitor` is already implemented in the code. You can use it directly.
    - The interface `Visitor` has the following methods:
        - `visitCircle()`: visit the circle.
        - `visitRectangle()`: visit the rectangle.
        - `visitTriangle()`: visit the triangle.
        - `visitConvexPolygon()`: visit the convex polygon.
        - `visitCompoundShape()`: visit the compound shape.
        - `visitTextedShape()`: visit the texted shape.
        - `visitColoredShape()`: visit the colored shape.

* For each shape, please implement the `accept` method to accept the visitor.
    - The method `accept` is to accept the visitor and call the corresponding method in the visitor.
    - For example, if the shape is a circle, the method `accept` should call the method `visitCircle` in the visitor.

* Please implement the class - `findShapeVisitor`.
    - The `findShapeVisitor` class is to find the shape satisfying the given condition.
        - The visitor should receive a predicate to find the shape.
            - For example, if the condition is `area = 10`, the visitor should return the shape whose area equals to 10.
        - The visitor should return a list of shapes satisfying the condition.
        - If the shape satisfying the condition is not found, the visitor should return an empty list.
        - For the `CompoundShape`, the visitor should check the condition for itself first, then check the condition for its children.
            - For example, given a compound shape contains a circle with area is 10 and a rectangle with area is 6, if the condition is `area > 8`, the visitor should return the compound shape and the circle.
        - For the `TextedShape` and `ColoredShape`, the visitor should check the condition for itself first, then check the decorated shape.
            - For example, given a texted shape containing a circle with area is 10 and a text is "Hello":
                - if the condition is `area = 10`, the visitor should return the texted shape and the circle.
                - if the condition is `shape is an instance of TextedShape`, the visitor should return the texted shape.

* Please implement the class - `PrettyPrintVisitor`.
    - The `PrettyPrintVisitor` class is to print the shape in a pretty format.
        - The visitor should return a string.
        - The visitor should print the shape in the following format:
            - Circle: `Circle 1.0`
            - Rectangle: `Rectangle 1.0 2.0`
            - Triangle: `Triangle [0,0] [1,0] [0,1]`
            - ConvexPolygon: `ConvexPolygon [0,0] [1,0] [1,1] [0,1]`
            - CompoundShape:
                - an empty compound shape:
                ```
                CompoundShape {}
                ```
                - a compound shape containing a circle and a rectangle:
                ```
                CompoundShape {
                  Circle 1.0
                  Rectangle 1.0 2.0
                }
                ```
                - The shapes in the compound shape should have an indent of 2 spaces. If the shape is a compound shape, the indent should be increased by 2 spaces.
                - For the `CompoundShape`, the visitor should print the shapes in the compound shape in the order they are added.
            - TextedShape: `Circle 1.0, text: Hello`
                - The text should be printed after the shape.
            - ColoredShape: `\033[0;31mCircle 1.0\033[0m`
                - For the `ColoredShape`, please use the color code as follows:
                    - Red: `\033[0;31m`
                    - Green: `\033[0;32m`
                    - Blue: `\033[0;34m`
                    - Reset Color: `\033[0m`
                - The color should be printed before the shape, and reset the color after printed the shape.

            - Please implement the `getRadius` in `Circle`, `getWidth` and `getHeight` in `Rectangle`, `getVectors` in `Triangle` and `ConvexPolygon`, `toString` in `TwoDimensionalVector`.

* Please make your directory follow the following file structure:

```
├── pom.xml
└── src
    ├── main
    │   └── java
    │       └── org
    │           └── ntut
    │               └── posd2024f
    │                   └── shapes
    │                       ├── Circle.java
    │                       ├── ColoredShape.java
    │                       ├── CompoundShape.java
    │                       ├── ConvexPolygon.java
    │                       ├── FindShapeVisitor.java
    │                       ├── NullIterator.java
    │                       ├── PrettyPrintVisitor.java
    │                       ├── Rectangle.java
    │                       ├── Shape.java
    │                       ├── ShapeException.java
    │                       ├── Sort.java
    │                       ├── TextedShape.java
    │                       ├── Triangle.java
    │                       ├── TwoDimensionalVector.java
    │                       └── Visitor.java
    └── test
        └── java
            └── org
                └── ntut
                    └── posd2024f
                        └── shapes
                            ├── CircleTest.java
                            ├── ColoredShapeTest.java
                            ├── CompoundShapeTest.java
                            ├── ConvexPolygonTest.java
                            ├── FindShapeVisitorTest.java
                            ├── NullIteratorTest.java
                            ├── PrettyPrintVisitorTest.java
                            ├── RectangleTest.java
                            ├── ShapeTest.java
                            ├── SortTest.java
                            ├── TextedShapeTest.java
                            ├── TriangleTest.java
                            └── TwoDimensionalVectorTest.java

```

## Score
1. Unit tests written by yourself: 35%.
2. Unit tests written by TA: 35%.
3. Correctness pattern implementation: 30%.

## References
* [Predicate](https://docs.oracle.com/javase/8/docs/api/?java/util/function/Predicate.html)

* [static class](https://www.geeksforgeeks.org/static-class-in-java/)

* [Comparator](https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html)

* [YC Cheng's blog about polygon](http://htsicpp.blogspot.com/2014/10/convex-polygon.html)

* [Oracle Java Document](https://docs.oracle.com/javase/8/docs/api/index.html)
