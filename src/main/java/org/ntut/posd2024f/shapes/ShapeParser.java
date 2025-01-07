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
        parseFix();
    }

    public void parseFix() {
        try (Scanner scanner = new Scanner(file)) {
            scanner.useDelimiter("\n");
            while (scanner.hasNext()) {
                String line = scanner.next().trim();
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


    // ========================================================================================================
    @Deprecated
    public void parseBefore() {
        try (Scanner scanner = new Scanner(file)) {
            int count_bracket = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                String[] info = line.split(", ");

                // get color and text
                // tokens[0] = shape, tokens[1] = color.info, tokens[2] = text.info
                String[] tokens = getToken(info);

                // build shape
                switch (tokens[0]) {
                    case "Circle":
                        parseCircle(info, tokens[1], tokens[2]);
                        break;
                    case "Rectangle":
                        parseRectangle(info, tokens[1], tokens[2]);
                        break;
                    case "Triangle":
                        parseTriangle(info, tokens[1], tokens[2]);
                        break;
                    case "ConvexPolygon":
                        parseConvexPolygon(info, tokens[1], tokens[2]);
                        break;
                    case "CompoundShape":
                        count_bracket++;
                        parseCompoundShape(info, tokens[1], tokens[2]);
                        if (info[info.length - 1].contains("{") && info[info.length - 1].contains("}")) {
                            builder.endBuildCompoundShape();
                            count_bracket--;
                        }
                        break;
                    case "}":
                        builder.endBuildCompoundShape();
                        count_bracket--;
                        break;
                    default:
                        break;
                }
            }

            if (count_bracket != 0) {
                throw new IllegalArgumentException("Expected token '}'");
            }
            shapes = builder.getResult();
        } catch (IOException e) {
            throw new RuntimeException("File not found");
        }
    }

    private void parseCircle(String[] info, String color, String text) {
        double radius = Double.parseDouble(info[0].split(" ")[1]);
        builder.buildCircle(radius, color, text);
    }

    private void parseRectangle(String[] info, String color, String text) {
        double width = Double.parseDouble(info[0].split(" ")[1]);
        double height = Double.parseDouble(info[0].split(" ")[2]);
        builder.buildRectangle(width, height, color, text);
    }

    private void parseTriangle(String[] info, String color, String text) {
        List<TwoDimensionalVector> vectors = new ArrayList<TwoDimensionalVector>();
        TwoDimensionalVector v1 = getTwoDimensionalVector(info[0].split(" ")[1]);
        TwoDimensionalVector v2 = getTwoDimensionalVector(info[0].split(" ")[2]);
        TwoDimensionalVector v3 = getTwoDimensionalVector(info[0].split(" ")[3]);
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);
        builder.buildTriangle(vectors, color, text);
    }

    private void parseConvexPolygon(String[] info, String color, String text) {
        List<TwoDimensionalVector> vectors = new ArrayList<TwoDimensionalVector>();
        String[] vectorStrings = info[0].split(" ");
        for (int i = 1; i < vectorStrings.length; i++) {
            vectors.add(getTwoDimensionalVector(vectorStrings[i]));
        }
        builder.buildConvexPolygon(vectors, color, text);
    }

    private void parseCompoundShape(String[] info, String color, String text) {
        if (!info[info.length - 1].contains("{")) {
            throw new IllegalArgumentException("Expected token '{'");
        }
        builder.beginBuildCompoundShape(color, text);
    }

    // getToken from string[]
    private String[] getToken(String[] info) {
        // get color and text
        String[] tokens = {null, null, null};
        String color = null;
        String text = null;
        String shape = info[0].split(" ")[0];
        for (int i = 1; i < info.length; i++) {
            String[] keyValue = info[i].split("=");
            switch (keyValue[0]) {
                case "color":
                    color = (shape.equals("CompoundShape") ? keyValue[1].split(" ")[0] : keyValue[1]);
                    break;
                case "text":
                    int j = (keyValue[1].contains("}") ? 3 : 2);
                    text = (shape.equals("CompoundShape") ? keyValue[1].substring(0, keyValue[1].length() -  j) : keyValue[1]);
                    break;
                default:
                    break;
            }
        }
        tokens[0] = shape;
        tokens[1] = color;
        tokens[2] = text;
        return tokens;
    }

    // get two dimensional vector from string
    private TwoDimensionalVector getTwoDimensionalVector(String vector) {
        if (!vector.startsWith("[")) {
            throw new IllegalArgumentException("Expected token '['");
        }
        if (!vector.endsWith("]")) {
            throw new IllegalArgumentException("Expected token ']'");
        }
        if (!vector.contains(",")) {
            throw new IllegalArgumentException("Expected token ','");
        }
        
        String[] coordinates = vector.substring(1, vector.length() - 1).split(",");
        return new TwoDimensionalVector(Integer.parseInt(coordinates[0].trim()), Integer.parseInt(coordinates[1].trim()));
    }

    public List<Shape> getResult() {
        return shapes;
    }
}
