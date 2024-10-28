package org.ntut.posd2024f.midterm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class BookTest {    
    @Test
    public void testBookCreate() {
        String title = "book title";
        double price = 5;
        new Book(title, price);
    }

    @Test
    public void testBookCreateWithEmptyTitle() {
        String title = "";
        double price = 5;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Book(title, price));
        assertEquals("The book should have a title.", exception.getMessage());
    }

    @Test
    public void testBookCreateWithMulSpace() {
        String title = "    ";
        double price = 5;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Book(title, price));
        assertEquals("The book should have a title.", exception.getMessage());
    }

    @Test
    public void testBookCreateWithNullTitle() {
        String title = null;
        double price = 5;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Book(title, price));
        assertEquals("The book should have a title.", exception.getMessage());
    }

    @Test
    public void testBookCreateWithNegativePrice() {
        String title = "book title";
        double price = -1;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Book(title, price));
        assertEquals("The price should be greater than or equal to 0.", exception.getMessage());
    }

    @Test
    public void testBookGetTitle() {
        String title = "book title";
        double price = 5;
        Book book = new Book(title, price);
        assertEquals("book title", book.getTitle());
    }

    @Test
    public void testBookGetPrice() {
        String title = "book title";
        double price = 5;
        Book book = new Book(title, price);
        assertEquals(5, book.getPrice());
    }
}
