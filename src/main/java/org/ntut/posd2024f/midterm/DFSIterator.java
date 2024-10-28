package org.ntut.posd2024f.midterm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DFSIterator implements Iterator<Item> {
    private Iterator<Item> it;
    public List<Item> items = new ArrayList<Item>();

    public DFSIterator(Item item) {
        getNext(item);

        it = items.iterator();
    }

    private void getNext(Item item) {
        items.add(item);
        Item myItem = item;
        while (myItem instanceof DiscountItem) {
            myItem = ((DiscountItem)myItem).getItem();
        }
        Iterator<Item> tmpIt = myItem.iterator();
        while (tmpIt.hasNext()) {
            Item tmpItem = tmpIt.next();
            items.add(tmpItem);
            if (tmpItem.iterator().hasNext()) {
                getNext(tmpItem.iterator().next());
            }
        }
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public Item next() {
        return it.next();
    }
}
