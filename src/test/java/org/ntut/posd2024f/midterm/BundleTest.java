package org.ntut.posd2024f.midterm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class BundleTest {
    @Test
    public void testBundleCreate() {
        String title = "Bundle title";
        new Bundle(title);
    } 

    @Test
    public void testBundleCreateWithNullTitle() {
        String title = null;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Bundle(title));
        assertEquals("The bundle should have a title.", exception.getMessage());
    } 

    @Test
    public void testBundleCreateWithEmptyTitle() {
        String title = "";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Bundle(title));
        assertEquals("The bundle should have a title.", exception.getMessage());
    }

    @Test
    public void testBundleAdd() {
        String title = "Bundle title";
        Bundle bundle = new Bundle(title);

        Book book = new Book("book1", 5);
        bundle.add(book);
    } 

    @Test
    public void testBundleGetTitle() {
        String title = "Bundle title";
        Bundle bundle = new Bundle(title);
        assertEquals("Bundle title", bundle.getTitle());
    } 

    @Test
    public void testBundleIterator() {
        String title = "Bundle title";
        Bundle bundle = new Bundle(title);

        Book book = new Book("book1", 5);
        bundle.add(book);

        assertEquals(book.getTitle(), bundle.iterator().next().getTitle());
    }
}
