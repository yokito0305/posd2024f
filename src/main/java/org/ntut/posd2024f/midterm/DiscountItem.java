package org.ntut.posd2024f.midterm;

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
    public String getTitle() {
        return "<" + item.getTitle() + "> is on sale! " + Integer.toString((int)(discount * 1000 / 10)) + "% off!";
    }

    @Override
    public <T> void accept(ItemVisitor<T> visitor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accept'");
    }
}
