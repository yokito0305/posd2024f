package org.ntut.posd2024f.midterm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class ItemTest {
    @Test
    public void testItemGetTitle() {
        List<Item> items = new ArrayList<Item>();

        Book book = new Book("book1", 5);
        Bundle bundle = new Bundle("bundle1");
        items.add(book);
        items.add(bundle);

        assertEquals(book.getTitle(), items.get(0).getTitle());
        assertEquals(bundle.getTitle(), items.get(1).getTitle());
    }

    @Test
    public void testItemBookAddBook() {
        Item book = new Book("book1", 5);
        Item book2 = new Book("book2", 10);

        BookStoreException exception = assertThrows(BookStoreException.class, () -> book.add(book2));
        assertEquals("Only bundle can add the item.", exception.getMessage());
    }

    @Test
    public void testItemBundleAddBook() {
        Item book = new Book("book1", 5);
        Item bundle = new Bundle("bundle1");

        bundle.add(book);
    }

    @Test
    public void  testItemDiscountItemAddBook() {
        Item book = new Book("book", 100);
        double discount = 0.1;
        Item discountItem = new DiscountItem(book, discount);

        BookStoreException exception = assertThrows(BookStoreException.class, () -> discountItem.add(book));
        assertEquals("Only bundle can add the item.", exception.getMessage());
    }

    @Test
    public void testItemIterator() {
        Item book = new Book("book1", 100);
        Iterator<Item> iterator = book.iterator();

        assertFalse(iterator.hasNext());
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, ()-> iterator.next());
        assertEquals("No more element.", exception.getMessage());
    }
}
