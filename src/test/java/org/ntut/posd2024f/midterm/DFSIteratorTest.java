package org.ntut.posd2024f.midterm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DFSIteratorTest {
    @Test
    public void testDFSIteratorCreate() {
        Item book = new Book("book1", 100);
        new DFSIterator(book);
    }

    @Test
    public void testDFSIteratorWithBookNext() {
        Item book = new Book("book1", 100);
        DFSIterator dfsIterator = new DFSIterator(book);
        assertTrue(dfsIterator.hasNext());
        assertEquals(book.getTitle(), dfsIterator.next().getTitle());
    }

    @Test
    public void testDFSIteratorWithBundleNext() {
        Item book = new Book("book1", 100);
        Item bundle = new Bundle("bundle");
        bundle.add(book);

        DFSIterator dfsIterator = new DFSIterator(bundle);

        assertTrue(dfsIterator.hasNext());
        assertEquals(bundle.getTitle(), dfsIterator.next().getTitle());
        assertTrue(dfsIterator.hasNext());
        assertEquals(book.getTitle(), dfsIterator.next().getTitle());
        assertFalse(dfsIterator.hasNext());
    }

    @Test
    public void testDFSIteratorWithBookHasNext() {
        Item book = new Book("book1", 100);
        DFSIterator dfsIterator = new DFSIterator(book);
        assertTrue(dfsIterator.hasNext());
        dfsIterator.next();
        assertFalse(dfsIterator.hasNext());
    }

    @Test
    public void testDFSIteratorWithBundleHasNext() {
        Item book = new Book("book1", 100);
        Item bundle = new Bundle("bundle");
        bundle.add(book);

        DFSIterator dfsIterator = new DFSIterator(bundle);

        assertTrue(dfsIterator.hasNext());
        dfsIterator.next();
        assertTrue(dfsIterator.hasNext());
        dfsIterator.next();
        assertFalse(dfsIterator.hasNext());
    }
}
