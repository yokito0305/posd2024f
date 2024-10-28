package org.ntut.posd2024f.midterm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class NullIteratorTest {
    @Test
    public void testNullIteratorHasNext() {
        NullIterator it = new NullIterator();
        assertFalse(it.hasNext());
    }

    @Test
    public void testNullIteratorNext() {
        NullIterator it = new NullIterator();
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> it.next());
        assertEquals("No more element.", exception.getMessage());
    }
}
