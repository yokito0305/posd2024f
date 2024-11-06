package org.ntut.posd2024f.midterm;

import java.util.Iterator;

public class DiscountItem implements Item {
    private Item item;
    private double discount;

    public DiscountItem(Item item, double discount) {
        if (discount < 0 || discount > 1) {
            throw new IllegalArgumentException("The discount should be between 0 and 1.");
        }

        this.item = item;
        this.discount = discount;
    }

    public Item getItem() {
        return item;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public Iterator<Item> iterator() {
        return item.iterator();
    }

    @Override
    public String getTitle() {
        String discountStr = (discount * 100 % 1 == 0) ? String.format("%.0f", discount * 100) : String.format("%.1f", discount * 100);
        return "<" + item.getTitle() + "> is on sale! " + discountStr + "% off!";

    }

    @Override
    public <T> void accept(ItemVisitor<T> visitor) {
        visitor.visitDiscountItem(this);
    }
}
