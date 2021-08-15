package data.structure.map.openaddressing;

import java.util.Arrays;

public class OpenAddressingMap<K, V> {
    private static final double MAXIMUM_LOAD = 0.5;
    private static final int RESIZING_FACTOR = 2;

    private int size;
    private int capacity;
    private Object[] items;
    private double loadFactor;


    private class Entry {
        final K key;
        final V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public OpenAddressingMap(final int capacity) {
        size = 0;
        this.capacity = capacity;
        items = new Object[capacity];
        loadFactor = 0;
    }

    @SuppressWarnings("unchecked")
    public V get(final K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < capacity; i++) {
            final int index = Math.abs((key.hashCode() + i) % capacity);

            if ((items[index]) == null) {
                continue;
            }

            if (((Entry) items[index]).key.equals(key)) {
                return ((Entry) items[index]).value;
            }
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    public boolean has(final K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < capacity; i++) {
            final int index = Math.abs((key.hashCode() + i) % capacity);

            if ((items[index]) == null) {
                continue;
            }

            if (((Entry) items[index]).key.equals(key)) {
                return true;
            }
        }

        return false;
    }

    @SuppressWarnings("unchecked")
    public void put(final K key, final V value) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < capacity; i++) {
            final int index = Math.abs((key.hashCode() + i) % capacity);

            if (items[index] == null || ((Entry)items[index]).key.equals(key)) {
                items[index] = new Entry(key, value);
                size++;
                loadFactor = (double)size / (double)capacity;

                if (loadFactor >= MAXIMUM_LOAD) {
                    capacity *= RESIZING_FACTOR;
                    items = Arrays.copyOf(items, capacity);
                    loadFactor = (double)size / (double)capacity;
                }

                return;
            }
        }

        throw new IllegalStateException();
    }

    @SuppressWarnings("unchecked")
    public void remove(final K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < capacity; i++) {
            final int index = Math.abs((key.hashCode() + i) % capacity);

            if ((items[index]) == null) {
                continue;
            }

            if (((Entry)items[index]).key.equals(key)) {
                items[index] = null;
                size--;
                loadFactor = (double)size / (double)capacity;
                return;
            }
        }

        throw new IllegalArgumentException();
    }
}
