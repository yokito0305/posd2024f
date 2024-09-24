package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortTest {
    @Test
    public void testByAreaAscendingCompare() throws Exception {
        Circle circle = new Circle(5.0); // area = 78.54
        Circle circle2 = new Circle(10.0); // area = 314.16

        assertTrue(Sort.BY_AREA_ASCENDING.compare(circle, circle2) < 0);
        assertTrue(Sort.BY_AREA_ASCENDING.compare(circle2, circle) > 0);
        assertEquals(0, Sort.BY_AREA_ASCENDING.compare(circle, circle));
    }

    @Test
    public void testByAreaDescendingCompare() throws Exception {
        Circle circle = new Circle(5.0); // area = 78.54
        Circle circle2 = new Circle(10.0); // area = 314.16

        assertTrue(Sort.BY_AREA_DESCENDING.compare(circle, circle2) > 0);
        assertTrue(Sort.BY_AREA_DESCENDING.compare(circle2, circle) < 0);
        assertEquals(0, Sort.BY_AREA_DESCENDING.compare(circle, circle));
    }

    @Test
    public void testByPerimeterAscendingCompare() throws Exception {
        Circle circle = new Circle(5.0); // perimeter = 31.42
        Circle circle2 = new Circle(10.0); // perimeter = 62.83

        assertTrue(Sort.BY_PERIMETER_ASCENDING.compare(circle, circle2) < 0);
        assertTrue(Sort.BY_PERIMETER_ASCENDING.compare(circle2, circle) > 0);
        assertEquals(0, Sort.BY_PERIMETER_ASCENDING.compare(circle, circle));
    }

    @Test
    public void testByPerimeterDescendingCompare() throws Exception {
        Circle circle = new Circle(5.0); // perimeter = 31.42
        Circle circle2 = new Circle(10.0); // perimeter = 62.83

        assertTrue(Sort.BY_PERIMETER_DESCENDING.compare(circle, circle2) > 0);
        assertTrue(Sort.BY_PERIMETER_DESCENDING.compare(circle2, circle) < 0);
        assertEquals(0, Sort.BY_PERIMETER_DESCENDING.compare(circle, circle));
    }
}