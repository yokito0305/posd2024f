package org.ntut.posd2024f.shapes;

import java.util.ArrayList;
import java.util.List;

public class ConvexPolygon implements Shape {
    private List<TwoDimensionalVector> vectors;
    private List<TwoDimensionalVector> sideVector;
    private int sideCount;

    public ConvexPolygon(List<TwoDimensionalVector> vectors) {
        if (vectors.size() < 3) {
            throw new ShapeException("It's not a convex polygon!");
        }
        this.vectors = vectors;
        this.sideCount = vectors.size();

        sideVector = new ArrayList<TwoDimensionalVector>();
        for (int i = 0; i < sideCount; i++) {
            sideVector.add(vectors.get((i + 1) % sideCount).subtract(vectors.get(i % sideCount)));
        }

        if (!isConvex()) {
            throw new ShapeException("It's not a convex polygon!");
        }
    }

    private boolean isConvex() {
        boolean isClockWise = true;
        boolean isCounterCloockWise = true;

        for (int i = 0; i < sideCount; i++) {
            TwoDimensionalVector side1 = sideVector.get(i % sideCount);
            TwoDimensionalVector side2 = sideVector.get((i + 1) % sideCount);

            int cross = side1.cross(side2);
            if (cross > 0) {
                isClockWise = false;
            } else if (cross < 0) {
                isCounterCloockWise = false;
            }
        }
        if (!isClockWise && !isCounterCloockWise) {
            return false;
        }

        return true;
    }

    @Override
    public double area() {
        double area = 0;
        for (int i = 0; i < sideCount - 2; i++) {
            TwoDimensionalVector side1 = vectors.get((i + 1) % sideCount).subtract(vectors.get(0));
            TwoDimensionalVector side2 = vectors.get((i + 2) % sideCount).subtract(vectors.get(0));

            area += side1.cross(side2);
        }
        area = Math.abs(area * 0.5);
        return area;
    }

    @Override
    public double perimeter() {
        double perimeter = 0;
        for (int i = 0; i < sideCount; i++) {
            perimeter += sideVector.get(i).length();
        }
        return perimeter;
    }

    @Override
    public <T> void accept(Visitor<T> visitor) {
        visitor.visitConvexPolygon(this);
    }

    public List<TwoDimensionalVector> getVectors() {
        return vectors;
    }
}