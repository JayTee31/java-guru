package data.structure.stack.overlinkedlist;

import data.structure.linkedlist.LinkedList;

public class LinkedStack<E> {
    private final LinkedList<E> items = new LinkedList<>();

    public void push(final E element) {
        items.add(element);
    }

    public E pop() {
        if (items.isEmpty()) {
            throw new ArrayStoreException();
        }

        return items.remove(items.size() - 1);
    }

    public E peek() {
        if (items.isEmpty()) {
            return null;
        }

        return items.get(items.size() - 1);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }
}
