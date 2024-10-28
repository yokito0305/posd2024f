package org.ntut.posd2024f.midterm;

public class PriceVisitor implements ItemVisitor<Item> {

    @Override
    public void visitBook(Book book) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitBook'");
    }

    @Override
    public void visitBundle(Bundle bundle) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitBundle'");
    }

    @Override
    public void visitDiscountItem(DiscountItem discountItem) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitDiscountItem'");
    }

    @Override
    public Item getResult() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getResult'");
    }
}
