package data.structure.queue.overlinkedlist;

import data.structure.linkedlist.LinkedList;

public class LinkedQueue<E> {
    private static final int HEAD_OF_THE_QUEUE = 0;

    private final LinkedList<E> items;

    public LinkedQueue() {
        items = new LinkedList<E>();
    }

    public void add(final E element) {
        items.add(element);
    }

    public E remove() {
        return items.remove(HEAD_OF_THE_QUEUE);
    }

    public E element() {
        return items.get(HEAD_OF_THE_QUEUE);
    }

    public E poll() {
        if (items.isEmpty()) {
            return null;
        }

        return items.remove(HEAD_OF_THE_QUEUE);
    }

    public E peek() {
        if (items.isEmpty()) {
            return null;
        }

        return items.get(HEAD_OF_THE_QUEUE);
    }
}
