package data.structure.queue.overlinkedlist;

import data.structure.linkedlist.LinkedList;
import data.structure.map.overlinkedlist.LinkedHashMap;

public class LinkedQueue<E> {
    private int size;
    private final LinkedList<E> items;

    public LinkedQueue() {
        size = 0;
        items = new LinkedList<E>();
    }

    public void add(final E element) {
        items.add(element);
        size++;
    }

    public E remove() {
        size--;
        return items.remove(0);
    }

    public E element() {
        return items.get(0);
    }

    public E poll() {
        if (items.isEmpty()) {
            return null;
        }

        return items.remove(0);
    }

    public E peek() {
        if (items.isEmpty()) {
            return null;
        }

        return items.get(0);
    }
}
