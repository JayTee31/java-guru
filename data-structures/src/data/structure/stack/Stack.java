package data.structure.stack;

import data.structure.arraylist.ArrayList;

public class Stack<E> {
    private final ArrayList<E> items = new ArrayList<>();

    public void push(final E element) {
        items.add(element);
    }

    public E pop() {
        if (items.size() == 0) {
            throw new ArrayStoreException();
        }

        return items.remove(items.size() - 1);
    }

    public E peek() {
        if (items.size() == 0) {
            return null;
        }

        return items.get(items.size() - 1);
    }

    public boolean isEmpty() {
        return items.size() == 0;
    }

    public int size() {
        return items.size();
    }

    @Override
    public String toString() {
        return "Stack{" +
                "items=" + items +
                '}';
    }
}
