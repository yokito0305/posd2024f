package org.ntut.posd2024f.shapes;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShapeParser {
    private List<Shape> shapes = null;
    private Scanner scanner = null;
    private ShapeBuilder builder = null;

    public ShapeParser(File file) {
        try {
            scanner = new Scanner(file);
        } catch (Exception e) {
            throw new RuntimeException("File not found");
        }

        shapes = new ArrayList<Shape>();
    }

    public void parse() {
        builder = new ShapeBuilder();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            parseLine(line);
        }

        shapes = builder.getResult();
    }

    private void parseLine(String line) {
        String[] info = line.split(", ");
            switch (info[0].split(" ")[0]) {
                case "Circle":
                    parseCircle(info);
                    break;
                case "Rectangle":
                    parseRectangle(info);
                    break;
                case "Triangle":
                    parseTriangle(info);
                    break;
                case "ConvexPolygon":
                    parseConvexPolygon(info);
                    break;
                case "CompoundShape":
                    parseCompoundShape(info, getSpacesNum(line));
                    break;
                default:
                    break;
            }
    }

    private void parseCircle(String[] info) {
        String color = null;
        String text = null;
        double radius = Double.parseDouble(info[0].split(" ")[1]);
        for (int i = 1; i < info.length; i++) {
            String[] keyValue = info[i].split("=");
            switch (keyValue[0]) {
                case "color":
                    color = keyValue[1];
                    break;
                case "text":
                    text = keyValue[1];
                    break;
                default:
                    break;
            }
        }
        builder.buildCircle(radius, color, text);
    }

    private void parseRectangle(String[] info) {
        String color = null;
        String text = null;
        double width = Double.parseDouble(info[0].split(" ")[1]);
        double height = Double.parseDouble(info[0].split(" ")[2]);
        for (int i = 1; i < info.length; i++) {
            String[] keyValue = info[i].split("=");
            switch (keyValue[0]) {
                case "color":
                    color = keyValue[1];
                    break;
                case "text":
                    text = keyValue[1];
                    break;
                default:
                    break;
            }
        }
        builder.buildRectangle(width, height, color, text);
    }

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

    private void parseTriangle(String[] info) {
        String color = null;
        String text = null;
        List<TwoDimensionalVector> vectors = new ArrayList<TwoDimensionalVector>();
        TwoDimensionalVector v1 = getTwoDimensionalVector(info[0].split(" ")[1]);
        TwoDimensionalVector v2 = getTwoDimensionalVector(info[0].split(" ")[2]);
        TwoDimensionalVector v3 = getTwoDimensionalVector(info[0].split(" ")[3]);
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);
        for (int i = 1; i < info.length; i++) {
            String[] keyValue = info[i].split("=");
            switch (keyValue[0]) {
                case "color":
                    color = keyValue[1];
                    break;
                case "text":
                    text = keyValue[1];
                    break;
                default:
                    break;
            }
        }
        builder.buildTriangle(vectors, color, text);
    }

    private void parseConvexPolygon(String[] info) {
        String color = null;
        String text = null;
        List<TwoDimensionalVector> vectors = new ArrayList<TwoDimensionalVector>();
        String[] vectorStrings = info[0].split(" ");
        for (int i = 1; i < vectorStrings.length; i++) {
            vectors.add(getTwoDimensionalVector(vectorStrings[i]));
        }

        for (int i = 1; i < info.length; i++) {
            String[] keyValue = info[i].split("=");
            switch (keyValue[0]) {
                case "color":
                    color = keyValue[1];
                    break;
                case "text":
                    text = keyValue[1];
                    break;
                default:
                    break;
            }
        }
        builder.buildConvexPolygon(vectors, color, text);
    }

    private int getSpacesNum(String line) {
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ' ') {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    private void parseCompoundShape(String[] info, int spacesNum) {
        String color = null;
        String text = null;

        int i = 1;
        for (; i < info.length; i++) {
            String[] keyValue = info[i].split("=");
            switch (keyValue[0]) {
                case "color":
                    color = keyValue[1].split(" ")[0];
                    break;
                case "text":
                    text = keyValue[1].substring(0, keyValue[1].length() - 2);
                    break;
                default:
                    break;
            }
        }
        i--;
        if (!info[i].contains("{")) {
            throw new IllegalArgumentException("Expected token '{'");
        }

        builder.beginBuildCompoundShape(color, text);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int nextLineSpaces = getSpacesNum(line);
            line = line.trim();
            if (nextLineSpaces == spacesNum) {
                if (line.equals("}")) {
                    builder.endBuildCompoundShape();
                    return;
                }

                if (!info[i].contains("}")) {
                    throw new IllegalArgumentException("Expected token '}'");
                }
            }
            
            parseLine(line);
            
            if (line.equals("}")) {
                builder.endBuildCompoundShape();
                return;
            }
        }
        
        throw new IllegalArgumentException("Expected token '}'");
    }

    public List<Shape> getResult() {
        return shapes;
    }
}
