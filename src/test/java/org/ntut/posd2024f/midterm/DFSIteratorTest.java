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
    public void testDFSIteratorHasNext() {
        Item book = new Book("book1", 100);
        DFSIterator dfsIterator = new DFSIterator(book);
        assertTrue(dfsIterator.hasNext());
    }

    @Test
    public void testDFSIteratorNext() {
        Item book = new Book("book1", 100);
        DFSIterator dfsIterator = new DFSIterator(book);
        assertEquals(book.getTitle(), dfsIterator.next().getTitle());
    }

    @Test
    public void testDFSIteratorWithBundle() {
        Book book1 = new Book("book1", 1);
        Book book2 = new Book("book2", 2);
        Bundle bundle2 = new Bundle("bundle2");
        bundle2.add(book1);
        bundle2.add(book2);

        Book book3 = new Book("book3", 3);
        Bundle bundle1 = new Bundle("bundle1");
        bundle1.add(bundle2);
        bundle1.add(book3);

        DFSIterator dfsIterator = new DFSIterator(bundle1);
        assertEquals(bundle1.getTitle(), dfsIterator.next().getTitle());
        assertEquals(bundle2.getTitle(), dfsIterator.next().getTitle());
        assertEquals(book1.getTitle(), dfsIterator.next().getTitle());
        assertEquals(book2.getTitle(), dfsIterator.next().getTitle());
        assertEquals(book3.getTitle(), dfsIterator.next().getTitle());
        assertFalse(dfsIterator.hasNext());
    }

    @Test
    public void testDFSIteratorWithDisCount() {
        Book book1 = new Book("Happy Potter", 100);
        Book book2 = new Book("Sad Potter", 150);
        Book book3 = new Book("Angry Potter", 200);

        Bundle bundle2 = new Bundle("Bundle");
        bundle2.add(book2);

        Bundle bundle1 = new Bundle("Fake Potter Series");
        bundle1.add(book1);
        bundle1.add(bundle2);
        bundle1.add(book3);

        DiscountItem discountItem = new DiscountItem(bundle1, 0.1);

        DFSIterator iterator = new DFSIterator(discountItem);
        assertEquals(discountItem.getTitle(), iterator.next().getTitle());  // discountItem
        assertEquals(book1.getTitle(), iterator.next().getTitle());         // Happy Potter
        assertEquals(bundle2.getTitle(), iterator.next().getTitle());       // Bundle
        assertEquals(book2.getTitle(), iterator.next().getTitle());         // Sad Potter
        assertEquals(book3.getTitle(), iterator.next().getTitle());         // Angry Potter
        assertFalse(iterator.hasNext());
    }
}
