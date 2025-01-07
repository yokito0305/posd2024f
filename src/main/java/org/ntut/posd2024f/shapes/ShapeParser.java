package org.ntut.posd2024f.shapes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShapeParser {
    private List<Shape> shapes = null;
    private ShapeBuilder builder = null;
    private File file = null;
    private int expectOpenBracket = 0;

    public ShapeParser(File file) {
        try (Scanner scanner = new Scanner(file)) {
        } catch (IOException e) {
            throw new RuntimeException("File not found");
        }

        this.builder = new ShapeBuilder();
        this.shapes = new ArrayList<Shape>();
        this.file = file;
    }

    public void parse() {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line != null && !line.isEmpty()) {
                    parseLine(line);
                }
            }
            if (expectOpenBracket != 0) {
                throw new IllegalArgumentException("Expected token '}'");
            }
            shapes = builder.getResult();
        } catch (IOException e) {
            throw new RuntimeException("File not found");
        }
    }

    public void parseLine(String line) {
        try (Scanner scanner = new Scanner(line)) {
            scanner.useDelimiter(",\\s+|(?=\\{)");
            String shape = scanner.next().trim();
            // get color and text
            String[] info = {null, null, null};
            while (scanner.hasNext()) {
                parseInfo(scanner.next().trim() , info);
            }
            parseShape(shape, info);
        } catch (Exception e) {
            throw e;
        }
    }

    public void parseInfo(String info , String[] tokens) {
        try (Scanner scanner = new Scanner(info)) {
            scanner.useDelimiter("=");
            String key = scanner.next().trim();
            switch (key) {
                case "color":
                    tokens[0] = scanner.next().trim();
                    break;
                case "text":
                    tokens[1] = scanner.next().trim();
                    break;
                default:
                    // get {}
                    tokens[2] = key;
                    break;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void parseShape(String shape, String[] info) {
        try (Scanner scanner = new Scanner(shape)) {
            scanner.useDelimiter(" ");
            String shapeType = scanner.next();
            switch (shapeType) {
                case "Circle":
                    double radius = scanner.nextDouble();
                    builder.buildCircle(radius, info[0], info[1]);
                    break;
                case "Rectangle":
                    double width = scanner.nextDouble();
                    double height = scanner.nextDouble();
                    builder.buildRectangle(width, height, info[0], info[1]);
                    break;
                case "Triangle":
                    List<TwoDimensionalVector> vectors;
                    vectors = parseTwoDimensionalVectors(scanner);
                    builder.buildTriangle(vectors, info[0], info[1]);
                    break;
                case "ConvexPolygon":
                    List<TwoDimensionalVector> vectors2;
                    vectors2 = parseTwoDimensionalVectors(scanner);
                    builder.buildConvexPolygon(vectors2, info[0], info[1]);
                    break;
                case "CompoundShape":
                    String check = info[2];
                    if (check != null && check.contains("{")) {
                        expectOpenBracket++;
                    } else {
                        throw new IllegalArgumentException("Expected token '{'");
                    }
                    builder.beginBuildCompoundShape(info[0], info[1]);

                    if (check != null && check.contains("}")) {
                        builder.endBuildCompoundShape();
                        expectOpenBracket--;
                    }
                    break;
                case "}":
                    if (expectOpenBracket == 0) {
                        throw new IllegalArgumentException("Expected token '{'");
                    }
                    builder.endBuildCompoundShape();
                    expectOpenBracket--;
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<TwoDimensionalVector> parseTwoDimensionalVectors(Scanner scanner) {
        List<TwoDimensionalVector> vectors = new ArrayList<TwoDimensionalVector>();
        int count = 0;
        int[] coordinates = {0, 0, 0};
        scanner.useDelimiter("");
        while (scanner.hasNext()) {
            String token = scanner.next();
            switch (token) {
                case "[":
                    if (count != 0) {
                        throw new IllegalArgumentException("Expected token ']'");
                    }
                    count++;
                    break;
                case ",":
                    if (count != 1) {
                        throw new IllegalArgumentException("Expected token '['");
                    }
                    count++;
                    break;
                case "]":
                    if (count != 2) {
                        throw new IllegalArgumentException("Expected token ','");
                    }
                    vectors.add(new TwoDimensionalVector(coordinates[1], coordinates[2]));
                    coordinates[1] = 0;
                    coordinates[2] = 0;
                    count = 0;
                    break;
                case " ":
                    break;
                default:
                    if (count > 2) {
                        throw new IllegalArgumentException("Expected token ']'");
                    } else if (count == 0) {
                        throw new IllegalArgumentException("Expected token '['");
                    }
                    coordinates[count] = coordinates[count] * 10 + Integer.parseInt(token);
                    break;
            }
        }
        if (count != 0) {
            throw new IllegalArgumentException("Expected token ']'");
        }
        return vectors;
    }

    public List<Shape> getResult() {
        return shapes;
    }
}
