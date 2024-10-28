package org.ntut.posd2024f.midterm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bundle implements Item {
    private List<Item> items;
    private String title;

    public Bundle(String title) {
        if (title == null || title.length() == 0) {
            throw new IllegalArgumentException("The bundle should have a title.");
        }

        this.title = title;
        this.items = new ArrayList<Item>();
    }

    @Override
    public Iterator<Item> iterator() {
        return items.iterator();
    }

    @Override
    public void add(Item item) {
        items.add(item);
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public <T> void accept(ItemVisitor<T> visitor) {
        visitor.visitBundle(this);
    }
}
