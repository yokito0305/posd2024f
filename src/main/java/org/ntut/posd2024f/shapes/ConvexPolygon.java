package org.ntut.posd2024f.shapes;

import java.util.List;

public class ConvexPolygon implements Shape {
    private List<TwoDimensionalVector> vectors;
    
    /**
     * The vectors which used to create the ConvexPolygon need to be sorted in the clockwise direction or counterclockwise direction, 
     * the unsorted vectors are unavailable and needs to throw the ShapeException.
     * @param vectors
     */
    public ConvexPolygon(List<TwoDimensionalVector> vectors) throws ShapeException {
        if (!isConvex(vectors)) {
            throw new ShapeException("It's not a convex polygon!");
        }

        this.vectors = vectors;
    }

    /** Function to check if the polygon is
     * convex polygon or not */
    private boolean isConvex(List<TwoDimensionalVector> vectors) {
        int n = vectors.size();
        int curr = 0;
        int prev = 0;

        for(int i = 0; i < n; i++) {
            curr = vectors.get(i).cross(vectors.get((i + 1) % n));

            // If curr is not equal to 0
            if (curr != 0) {

                // If direction of cross product of
                // all adjacent edges are not same
                if (curr * prev < 0) {
                    return false;
                } else {
                    // Update curr
                    prev = curr;
                }
            }
        }

        return true;
    }

    public double area() {
        double area = 0.0;
        int n = vectors.size();
        for (int i = 0; i < n; i += 2) {
            TwoDimensionalVector current = vectors.get(i);
            TwoDimensionalVector next = vectors.get((i + 1) % n);
            area += current.cross(next);
        }
        return Math.abs(area) / 2.0;
    }

    public double perimeter() {
        double perimeter = 0.0;
        int n = vectors.size();
        for (int i = 0; i < n; i++) {
            perimeter += vectors.get(i).length();
        }
        return perimeter;
    }
}