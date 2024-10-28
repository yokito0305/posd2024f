package org.ntut.posd2024f.midterm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DFSIterator implements Iterator<Item> {
    private Iterator<Item> it;
    public List<Item> items = new ArrayList<Item>();
    
    public DFSIterator(Item item) {
        items.add(item);

        Iterator<Item> tmpIt = item.iterator();
        while (tmpIt.hasNext()) {
            items.add(tmpIt.next());
            if (item.iterator().hasNext()) {
                getNext(item.iterator().next());
            }
        }
    }

    private void getNext(Item item) {
        items.add(item);
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public Item next() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'next'");
    }
}
