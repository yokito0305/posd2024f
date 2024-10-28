package org.ntut.posd2024f.midterm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PriceVisitorTest {
    @Test
    public void testPriceVisitorWithBook() {
        Item book = new Book("book1", 100);

        PriceVisitor visitor = new PriceVisitor();
        book.accept(visitor);
        assertEquals(100, visitor.getResult());
    }

    @Test
    public void testPriceVisitorWithBundle() {
        Item book = new Book("book1", 100);
        Item bundle = new Bundle("bundle");
        bundle.add(book);

        PriceVisitor visitor = new PriceVisitor();
        bundle.accept(visitor);
        assertEquals(100, visitor.getResult());
    }

    // @Test
    // public void testPriceVisitorWithDiscountItem() {
    //     Item book = new Book("book1", 100);
    //     Item bundle = new Bundle("bundle");
    //     bundle.add(book);
    //     Item discountItem = new DiscountItem(bundle, 0.5);

    //     PriceVisitor visitor = new PriceVisitor();
    //     discountItem.accept(visitor);
    //     assertEquals(50, visitor.getResult());
    // }
}
