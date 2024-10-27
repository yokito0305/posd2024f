package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;


public class NullIteratorTest {
    @Test
    public void testNullIteratorHasNext() {
        NullIterator nullIterator = new NullIterator();
        assertFalse(nullIterator.hasNext());
    }

    @Test
    public void testNullIteratorNext() {
        NullIterator nullIterator = new NullIterator();
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            nullIterator.next();
        });
        assertEquals("Null iterator does not point to any element", exception.getMessage());
    }
}
