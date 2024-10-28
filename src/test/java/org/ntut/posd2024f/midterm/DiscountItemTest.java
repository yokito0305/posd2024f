package org.ntut.posd2024f.midterm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class DiscountItemTest {
    @Test
    public void testDiscountItemCreate() {
        Item book = new Book("book1", 5);
        double discount = 0.1;
        new DiscountItem(book, discount);
    }

    @Test
    public void testDiscountItemDiscountLessZero() {
        Item book = new Book("book1", 5);
        double discount = -1;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new DiscountItem(book, discount));
        assertEquals("The discount should be between 0 and 1.", exception.getMessage());
    }

    @Test
    public void testDiscountItemDiscountGreaterOne() {
        Item book = new Book("book1", 5);
        double discount = 1.1;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new DiscountItem(book, discount));
        assertEquals("The discount should be between 0 and 1.", exception.getMessage());
    }

    @Test
    public void testDiscountItemGetItem() {
        Item book = new Book("book1", 5);
        double discount = 0.1;
        DiscountItem discountItem = new DiscountItem(book, discount);
        assertEquals(book.getTitle(), discountItem.getItem().getTitle());
    }

    @Test
    public void testDiscountItemGetDiscount() {
        Item book = new Book("book1", 5);
        double discount = 0.1;
        DiscountItem discountItem = new DiscountItem(book, discount);
        assertEquals(0.1, discountItem.getDiscount());
    }

    @Test
    public void testDiscountItemGetTitle() {
        Item book = new Book("Happy Potter", 100);
        double discount = 0.1;
        DiscountItem discountItem = new DiscountItem(book, discount);
        assertEquals("<Happy Potter> is on sale! 10% off!", discountItem.getTitle());
    }

    @Test
    public void testDiscountItemGetTitleWithBundle() {
        Item book = new Book("Happy Potter", 100);
        Item bundle = new Bundle("bundle of Happy Potter");
        bundle.add(book);

        double discount = 0.1;
        DiscountItem discountItem = new DiscountItem(bundle, discount);
        assertEquals("<bundle of Happy Potter> is on sale! 10% off!", discountItem.getTitle());
    }

    @Test
    public void testDiscountItemGetTitleWithDiscountItem() {
        Item book = new Book("book", 100);
        double discount = 0.1;
        DiscountItem discountItem = new DiscountItem(book, discount);
        assertEquals("<book> is on sale! 10% off!", discountItem.getTitle());

        double discount2 = 0.2;
        DiscountItem discountItem2 = new DiscountItem(discountItem, discount2);
        assertEquals("<<book> is on sale! 10% off!> is on sale! 20% off!", discountItem2.getTitle());
    }

    @Test
    public void  testDiscountItemAdd() {
        Item book = new Book("book", 100);
        double discount = 0.1;
        DiscountItem discountItem = new DiscountItem(book, discount);

        BookStoreException exception = assertThrows(BookStoreException.class, () -> discountItem.add(book));
        assertEquals("Only bundle can add the item.", exception.getMessage());
    }
}
