package org.ntut.posd2024f.midterm;

import java.util.Iterator;

public class PriceVisitor implements ItemVisitor<Double> {
    private double price = 0;
    private double discount = 1;

    @Override
    public void visitBook(Book book) {
        price += discount * book.getPrice();
    }

    @Override
    public void visitBundle(Bundle bundle) {
        Iterator<Item> items = bundle.iterator();
        while (items.hasNext()) {
            Item item = items.next();
            item.accept(this);
        }
    }

    @Override
    public void visitDiscountItem(DiscountItem discountItem) {
        discount = discount * (1 - discountItem.getDiscount());
        discountItem.getItem().accept(this);
        discount = discount / (1 - discountItem.getDiscount());
    }

    @Override
    public Double getResult() {
        return price;
    }
}
