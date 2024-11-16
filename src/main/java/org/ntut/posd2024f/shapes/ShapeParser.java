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
        String[] info = line.trim().split(", ");

        // get color and text
        String color = null;
        String text = null;
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
        // build shape
        switch (info[0].split(" ")[0]) {
            case "Circle":
                parseCircle(info, color, text);
                break;
            case "Rectangle":
                parseRectangle(info, color, text);
                break;
            case "Triangle":
                parseTriangle(info, color, text);
                break;
            case "ConvexPolygon":
                parseConvexPolygon(info, color, text);
                break;
            case "CompoundShape":
                parseCompoundShape(info, color, text, getSpacesNum(line));
                break;
            default:
                break;
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

    private void parseCompoundShape(String[] info, String color, String text, int spacesNum) {
        Boolean isFirst = true;
        int length = info.length;
        
        // check if it is a empty compound shape
        if (!info[length - 1].contains("{")) {
            throw new IllegalArgumentException("Expected token '{'");
        }
        builder.beginBuildCompoundShape(color, text);

        if (isFirst && info[length - 1].contains("}")) {
            builder.endBuildCompoundShape();
            return;
        }
        isFirst = false;

        // parse compound shape
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int nextLineSpaces = getSpacesNum(line);
            if (nextLineSpaces <= spacesNum) {
                if (line.trim().equals("}")) {
                    builder.endBuildCompoundShape();
                    return;
                }
            }
            parseLine(line);
        }
        
        // check if there is no '}' at the end of the file
        throw new IllegalArgumentException("Expected token '}'");
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
    
    // get the number of spaces in the beginning of the line
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

    public List<Shape> getResult() {
        return shapes;
    }
}
