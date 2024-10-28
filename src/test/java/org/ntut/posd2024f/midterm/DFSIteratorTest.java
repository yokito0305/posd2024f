package org.ntut.posd2024f.midterm;

import org.junit.jupiter.api.Test;

public class DFSIteratorTest {
    @Test
    public void testDFSIteratorCreate() {
        Item book = new Book("book1", 100);
        new DFSIterator(book);
    }

    
}
