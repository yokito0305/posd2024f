package org.ntut.posd2024f.midterm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class PriceVisitorTest {
    @Test
    public void testPriceVisitorWithBook() {
        Book book = new Book("book1", 100);

        PriceVisitor visitor = new PriceVisitor();
        book.accept(visitor);
        assertEquals(100, visitor.getResult());
    }

    @Test
    public void testPriceVisitorWithBundle() {
        Book book = new Book("book1", 100);
        Book book2 = new Book("book2", 200);
        Bundle bundle = new Bundle("bundle");
        bundle.add(book);
        bundle.add(book2);

        PriceVisitor visitor = new PriceVisitor();
        bundle.accept(visitor);
        assertEquals(300, visitor.getResult());
    }

    @Test
    public void testPriceVisitorWithDiscountItem() {
        Book book = new Book("book1", 100);
        DiscountItem discountItem = new DiscountItem(book, 0.1);

        PriceVisitor visitor = new PriceVisitor();
        discountItem.accept(visitor);
        assertEquals(90, visitor.getResult());
    }

    @Test
    public void testPriceVisitorWithDiscountedDiscountItem() {
        Book book = new Book("Happy Potter", 100);
        DiscountItem discountItem2 = new DiscountItem(book, 0.2);
        DiscountItem discountItem = new DiscountItem(discountItem2, 0.5);

        PriceVisitor visitor = new PriceVisitor();
        discountItem.accept(visitor);
        assertEquals(40, visitor.getResult());
    }

    @Test
    public void testPriceVisitorWithShoppingCart() {
        List<Item> shoppingCart = new ArrayList<Item>();
        Book book = new Book("book1", 100);
        Book book2 = new Book("book2", 200);
        shoppingCart.add(book);
        shoppingCart.add(book2);

        Book book3 = new Book("Happy Potter", 100);
        DiscountItem discountItem2 = new DiscountItem(book3, 0.2);
        DiscountItem discountItem = new DiscountItem(discountItem2, 0.5);

        shoppingCart.add(discountItem);

        PriceVisitor priceVisitor = new PriceVisitor();
        for (Item item : shoppingCart) {
            item.accept(priceVisitor); // Accept the visitor to visit the item
        }

        assertEquals(340, priceVisitor.getResult());
    }
}
