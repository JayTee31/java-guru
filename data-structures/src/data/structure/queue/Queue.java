package data.structure.queue;

public class Queue<E> {
    private final RingBuffer<E> items;
    private final int capacity;

    public Queue(final int capacity) {
        items = new RingBuffer<>(capacity);
        this.capacity = capacity;
    }

    public void add(final E element) {
        items.push(element);
    }

    public E remove() {
        return items.pull();
    }

    public E element() {
        return items.peek();
    }

    public boolean offer(final E element) {
        if (capacity == items.size()) {
            return false;
        }

        items.push(element);
        return true;
    }

    public E poll() {
        if (items.isEmpty()) {
            return null;
        }

        return items.pull();
    }

    public E peek() {
        if (items.isEmpty()) {
            return null;
        }

        return items.peek();
    }
}
