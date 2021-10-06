package data.structure.binarytree.heap.priorityqueue;

import data.structure.binarytree.heap.Heap;

public class PriorityQueue<E extends Comparable<E>> {
    private class Item implements Comparable<Item> {
        E data;
        int priority;

        @Override
        public int compareTo(Item other) {
            return Integer.compare(this.priority, other.priority);
        }
    }

    private final Heap<Item> heap = new Heap<>();

    public void add(int priority, E data) {
        final Item item = new Item();
        item.data = data;
        item.priority = priority;
        heap.insert(item);
    }

    public E peek() {
        return heap.peekTop().data;
    }

    public E poll() {
        if (isEmpty()) {
            return null;
        }

        return heap.removeTop().data;
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
