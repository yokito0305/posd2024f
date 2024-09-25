package org.ntut.posd2024f.shapes;

import java.util.List;
import java.util.Vector;

public class ConvexPolygon implements Shape {
    private List<TwoDimensionalVector> vectors;
    
    /**
     * The vectors which used to create the ConvexPolygon need to be sorted in the clockwise direction or counterclockwise direction, 
     * the unsorted vectors are unavailable and needs to throw the ShapeException.
     * @param vectors
     */
    public ConvexPolygon(List<TwoDimensionalVector> vectors) throws ShapeException {
        if(vectors.size() < 3) {
            throw new ShapeException("It's not a convex polygon!");
        }
        if (!isSorted(vectors)) {
            throw new ShapeException("It's not a convex polygon!");
        }
        if (!isConvex(vectors)) {
            throw new ShapeException("It's not a convex polygon!");
            
        }

        this.vectors = vectors;
    }

    /** Function to check if the polygon vectors is
     * sorted or not */
    private boolean isSorted(List<TwoDimensionalVector> vectors) {
        int n = vectors.size();
        
        // find the largest x-coordinate in vectors and find centroid
        int tmpX = 0;
        int tmpY = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            tmpX += vectors.get(i).x;
            tmpY += vectors.get(i).y;

            if(vectors.get(i).x == vectors.get(max).x && vectors.get(i).y > vectors.get(max).y) {
                max = i;
            }
            if (vectors.get(i).x > vectors.get(max).x) {
                max = i;
            }
        }
        
        TwoDimensionalVector centroid = new TwoDimensionalVector(tmpX / n, tmpY / n);

        // define the reference vector
        TwoDimensionalVector R = vectors.get(max).subtract(centroid);

        // check the angle between the reference vector and the other vectors
        Boolean isClockwise = true;
        Boolean isCounterclockwise = true;
        max++;
        for (int i = 2; i < n; i++, max++) {
            TwoDimensionalVector current = vectors.get(max % n).subtract(centroid);
            TwoDimensionalVector next = vectors.get((max + 1) % n).subtract(centroid);
            if (angle(R, current) > angle(R, next)) {
                isCounterclockwise = false;
                System.out.println("isCounterclockwise false");
            }
            if (angle(R, current) < angle(R, next)) {
                isClockwise = false;
                System.out.println("isClockwise false");
            }
            if(!isClockwise && !isCounterclockwise) {
                return false;
            }
        }

        return true;
    }

    private double angle(TwoDimensionalVector v1, TwoDimensionalVector v2) {
        double angle = Math.acos(v1.dot(v2) / (v1.length() * v2.length())) * 180 / Math.PI;
        double crossProduct = v1.cross(v2);
        if (crossProduct < 0) {
            angle = 360 - angle;
        }
        return angle;
    }

    private Boolean isConvex(List<TwoDimensionalVector> vectors) {
        int n = vectors.size();
        for (int i = 0; i < n; i++) {
            TwoDimensionalVector v1 = vectors.get(i).subtract(vectors.get((i + 1) % n));
            TwoDimensionalVector v2 = vectors.get((i + 2) % n).subtract(vectors.get((i + 1) % n));
            if (v1.cross(v2) < 0) {
                return false;
            }
        }
        return true;
    }

    public double area() {
        CompoundShape compoundShape = new CompoundShape();
        for (int i = 1; i < vectors.size() - 1; i++) {
            Vector<TwoDimensionalVector> tmpVectors = new Vector<>();
            tmpVectors.add(vectors.get(0));
            tmpVectors.add(vectors.get((i) % vectors.size()));
            tmpVectors.add(vectors.get((i + 1) % vectors.size()));
            compoundShape.add(new Triangle(tmpVectors));
        }

        return compoundShape.area();
    }

    public double perimeter() {
        double perimeter = 0;
        for (int i = 0; i < vectors.size(); i++) {
            perimeter += vectors.get(i).subtract(vectors.get((i + 1) % vectors.size())).length();
        }

        return perimeter;
    }
}