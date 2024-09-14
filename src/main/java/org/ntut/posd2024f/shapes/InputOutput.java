package org.ntut.posd2024f.shapes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class InputOutput {
    public InputOutput() {
    }

    public ArrayList<Shape> handleInput(String inputFileName) throws NumberFormatException, Exception {
        try {
            File file = new File(inputFileName);
            BufferedReader br = new BufferedReader(new FileReader(file));

            String str;
            ArrayList<Shape> Shapes = new ArrayList<Shape>();
            while ((str = br.readLine()) != null) {
                try {
                    Shapes.add(ConstructShape(str));
                } catch (Exception e) {
                    continue;
                }
            }
            br.close();
            
            return Shapes;
        } catch (IOException e) {
            throw new IOException("File not found!");
        }

    }

    public ArrayList<Shape> handleSort(ArrayList<Shape> Shapes, String compare, String order) {
        if (compare.equals("area")) {
            if (order.equals("inc")) {
                Shapes.sort(Sort.BY_AREA_ASCENDING);
            } else if (order.equals("dec")) {
                Shapes.sort(Sort.BY_AREA_DESCENDING);
            }
        } else if (compare.equals("perimeter")) {
            if (order.equals("inc")) {
                Shapes.sort(Sort.BY_PERIMETER_ASCENDING);
            } else if (order.equals("dec")) {
                Shapes.sort(Sort.BY_PERIMETER_DESCENDING);
            }
        }
        return Shapes;
    }

    public void handleOutput(ArrayList<Shape> Shapes, String outputFileName) {
        try {
            PrintWriter writer = new PrintWriter(outputFileName, "UTF-8");
            for (Shape shape : Shapes) {
                writer.println(shape.toString());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Shape ConstructShape(String str) throws NumberFormatException, Exception {
        String[] tokens = str.split(" ");
        if (tokens[0].equals("Circle")) {
            return new Circle(Double.parseDouble(tokens[1]));
        } else if (tokens[0].equals("Rectangle")) {
            return new Rectangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
        } else if (tokens[0].equals("Triangle")) {
            return new Triangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]),
                    Double.parseDouble(tokens[3]));
        } else {
            throw new Exception("Invalid shape!");
        }
    }
}
