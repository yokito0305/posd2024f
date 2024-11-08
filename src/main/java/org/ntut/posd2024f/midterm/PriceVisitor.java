package org.ntut.posd2024f.midterm;

import java.util.Iterator;

public class PriceVisitor implements ItemVisitor<Double> {
    private double price = 0;
    private double discount = 0;

    @Override
    public void visitBook(Book book) {
        price += book.getPrice() * (1 - discount);
    }

    @Override
    public void visitBundle(Bundle bundle) {
        Iterator<Item> iterator = bundle.iterator(); 
        while (iterator.hasNext()) {
            iterator.next().accept(this);
        }
    }

    @Override
    public void visitDiscountItem(DiscountItem discountItem) {
        double tmpDiscount = discount;
        discount = 1 - (1 - discount) * (1 - discountItem.getDiscount());
        discountItem.getItem().accept(this);
        discount = tmpDiscount;
    }

    @Override
    public Double getResult() {
        return price;
    }
}
