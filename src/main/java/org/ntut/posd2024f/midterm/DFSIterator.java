package org.ntut.posd2024f.midterm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DFSIterator implements Iterator<Item> {
    private Iterator<Item> it;
    private List<Item> items;

    public DFSIterator(Item item) {
        items = new ArrayList<Item>();
        getNext(item);

        it = items.iterator();
    }
    
    private void getNext(Item item) {
        Item myItem = item;
        
        items.add(myItem);
        if (!(myItem instanceof Book)) {
            Iterator<Item> it = myItem.iterator();
            while (it.hasNext()) {
                getNext(it.next());
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
