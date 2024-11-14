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
* [Assignment 3](http://140.124.181.100/course/posd2024f_ta/tree/assignment3): Due 10/15 14:00
* [Term project](http://140.124.181.100/course/posd2024f_ta/tree/term_project)
* [Assignment 4](#assignment-4): Due 11/19 14:00

## Assignment 4
**Deadline**: 14:00 on Nov 19, 2024.

**Notice**:
1. If your code fails to compile on Jenkins server, you'll get no point for the assignment.
2. If the unit tests written by yourself fails, you'll get no point for the unit tests written by TA.

Here's [the code](http://140.124.181.100/course/posd2024f_ta/-/tree/assignment_template_code) modified from the code written in class, please download and add them to your homework repository.

**Attention: Please ensure you use the pom.xml file in the template code; otherwise, you will have trouble running it on Jenkins.**
**Attention: Please ensure the Junit version is 5.11.3; otherwise, you will have trouble running it on Jenkins.**
**Attention: Please use Junit 5 for testing instead of Junit 4.**

**Note: Each class in the sample file is the skeleton. You should finish implementation by yourself.**

For this Assignment, you'll [implement the **Builder pattern**](#specification-1-builder-pattern), and [implement the **Parser pattern**](#specification-2-parser-pattern) based on the Assignment 3.

Please complete the given code to satisfy all the following conditions.

### Specification 1: Builder Pattern
* Please implement the class - `ShapeBuilder`.
    - The `ShapeBuilder` class is to build the shape.
    - The `ShapeBuilder` class should have the following methods:
        - `ShapeBuilder()`: constructor.
        - `void buildCircle(double radius, String color, String text)`: build a circle.
        - `void buildRectangle(double length, double width, String color, String text)`: build a rectangle.
        - `void buildTriangle(List<TwoDimensionalVector> vectors, String color, String text)`: build a triangle.
        - `void buildConvexPolygon(List<TwoDimensionalVector> vectors, String color, String text)`: build a convex polygon.
        - `void beginBuildCompoundShape(String color, String text)`: begin building a compound shape.
        - `void endBuildCompoundShape()`: end building a compound shape.
        - `List<Shape> getResult()` : get the result of the shapes.

    - Each method should accept the parameters `color` and `text` to set the color and text of the shape. If the shape does not have a color or text, the parameter should be set to `null`.

    - The `buildCircle`, `buildRectangle`, `buildTriangle`, and `buildConvexPolygon` methods should create a new shape and add it to the list of shapes or the compound shape which is currently being built.
        

### Specification 2: Parser Pattern
* Please implement the class - `ShapeParser`.
    - The `ShapeParser` class is to parse the shape from the plain text file.
    - The `ShapeParser` class uses the `Scanner` class to read the file.
    - The `ShapeParser` class uses the `ShapeBuilder` class to build the shape.
    - The `ShapeParser` class should have the following methods:
        - `ShapeParser(File file)`: constructor, accept a file object.
          - If a file does not exist, throw a `RuntimeException` with the message `File not found`.
        - `void parse()`: parse all shapes from the file.
        - `List<Shape> getResult()`: get the list of shapes.
    - The `parse` method should read the file and parse the shapes from the text. The text file contains the shapes in the following format:
        - A circle: `Circle 3.0`
        - A rectangle: `Rectangle 3.0 4.0`
        - A triangle: `Triangle [4,0] [4,3] [0,3]`
        - A convex polygon: `ConvexPolygon [0,0] [0,4] [4,4] [4,0]`
          - The two-dimensional vector has the format: `[x,y]`, which the x and y is an integer. No spaces between the square bracket, the two integers, and the comma.
          - If a vector does not contain the left square bracket, throw an `IllegalArgumentException` with the message `Expected token '['`
          - If a vector does not contain the comma, throw an `IllegalArgumentException` with the message `Expected token ','`
          - If a vector does not contain the right square bracket, throw an `IllegalArgumentException` with the message `Expected token ']'`
        - A compound shape: 
			```
			CompoundShape {
				Circle 3.0
				Rectangle 3.0 4.0
			}
			```
        - A nested compound shape:
          	```
			CompoundShape {
				Circle 3.0
					CompoundShape {
						Circle 3.0
						Rectangle 3.0 4.0
				}
				Rectangle 3.0 4.0
			}
          	```
        - An empty compound shape: `CompoundShape {}`
          - If a compound shape does not contain the left brace, throw an `IllegalArgumentException` with the message `Expected token '{'`
          - If a compound shape does not contain the right brace, throw an `IllegalArgumentException` with the message `Expected token '}'`.
        - A colored circle: `Circle 3.0, color=RED`
        - A texted circle: `Circle 3.0, text=This is a circle`
        - A colored and texted circle: `Circle 3.0, color=RED, text=This is a circle`
        - A texted triangle: `Triangle [4,0] [4,3] [0,3], text=This is a triangle`
        - A colored and texted compound shape: 
          ```
          CompoundShape, color=RED, text=This is a compound shape {
              Circle 3.0
              Rectangle 3.0 4.0
          }
          ```
          - If a shape contains the color and the text at the same time:
            1. Decorate the shape to colored shape
            2. Decorate the colored shape to texted shape
        - Several shapes:
          ```
          Circle 3.0
          ConvexPolygon [0,0] [0,4] [4,4] [4,0]
          CompoundShape {
              Circle 3.0
              Rectangle 3.0 4.0
          }
          ```
          
        - Hint1: You can use the Scanner class in Java to help you to scan the file.
        - Hint2: You can use different delimiter to split the input.
        - Reference: https://docs.oracle.com/javase/8/docs/api/?java/util/Scanner.html

* Please make your directory follow the following file structure:

```
├── pom.xml
└── src
    ├── __TA_test_data
    │   └── __TA_complex_shape.txt
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
    │                       ├── ShapeBuilder.java
    │                       ├── ShapeException.java
    │                       ├── ShapeParser.java
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
                            ├── ShapeBuilderTest.java
                            ├── ShapeParserTest.java
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
* [Java Scanner](https://docs.oracle.com/javase/8/docs/api/?java/util/Scanner.html)

* [Predicate](https://docs.oracle.com/javase/8/docs/api/?java/util/function/Predicate.html)

* [static class](https://www.geeksforgeeks.org/static-class-in-java/)

* [Comparator](https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html)

* [YC Cheng's blog about polygon](http://htsicpp.blogspot.com/2014/10/convex-polygon.html)

* [Oracle Java Document](https://docs.oracle.com/javase/8/docs/api/index.html)
