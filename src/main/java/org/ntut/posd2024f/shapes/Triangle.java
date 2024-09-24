package org.ntut.posd2024f.shapes;

import java.util.List;

public class Triangle implements Shape{
    private double side1;
    private double side2;
    private double side3;

    Triangle(List<TwoDimensionalVector> vectors) throws ShapeException {
        if (vectors.size() != 3) {
            throw new ShapeException("It's not a triangle!");
        }
        if (!isConvex(vectors)) {
            throw new ShapeException("It's not a triangle!");
        }

        this.side1 = vectors.get(0).length();
        this.side2 = vectors.get(1).length();
        this.side3 = vectors.get(2).length();

        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            throw new ShapeException("It's not a triangle!");
        }
    }

    /** Function to check if the polygon is
     * convex polygon or not */
    private boolean isConvex(List<TwoDimensionalVector> vectors) {
        int tmpX = 0, tmpY = 0;
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

            tmpX += vectors.get(i).x;
            tmpY += vectors.get(i).y;
        }

        // If the sums of the x or y coordinates are both zero, then it is a closed polygon.
        if (tmpX != 0 || tmpY != 0) {
            return false;
        }

        return true;
    }

    public double area() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public double perimeter() {
        return side1 + side2 + side3;
    }
}
