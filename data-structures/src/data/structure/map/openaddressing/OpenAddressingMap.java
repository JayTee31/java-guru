package data.structure.map.openaddressing;

import java.util.Arrays;
import static  java.util.Objects.*;

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

        Entry(final K key, final V value) {
            this.key = key;
            this.value = value;
        }
    }

    public OpenAddressingMap(final int capacity) {
        this.capacity = capacity;
        size = 0;
        items = new Object[capacity];
        loadFactor = 0;
    }

    @SuppressWarnings("unchecked")
    public V get(final K key) {
        requireNonNull(key, "The key must not be null!");

        final int keysHashCode = Math.abs(key.hashCode());

        for (int i = 0; i < capacity; i++) {
            final int index = (keysHashCode + i) % capacity;

            if (isNull(items[index])) {
                continue;
            }

            if (((Entry)items[index]).key.equals(key)) {
                return ((Entry)items[index]).value;
            }
        }

        return null;
    }

    public boolean has(final K key) {
        return !isNull(get(key));
    }

    @SuppressWarnings("unchecked")
    public void put(final K key, final V value) {
        requireNonNull(key, "The key must not be null!");

        final int keysHashCode = Math.abs(key.hashCode());

        for (int i = 0; i < capacity; i++) {
            final int index = (keysHashCode + i) % capacity;

            if (isNull(items[index])) {
                items[index] = new Entry(key, value);
                size++;
                computeLoadFactor();

                if (loadFactor >= MAXIMUM_LOAD) {
                    capacity *= RESIZING_FACTOR;
                    resizing();
                    computeLoadFactor();
                }
                return;
            }

            if (((Entry)items[index]).key.equals(key)) {
                items[index] = new Entry(key, value);
                return;
            }
        }

        throw new IllegalStateException();
    }

    @SuppressWarnings("unchecked")
    public void remove(final K key) {
        requireNonNull(key, "The key must not be null!");

        final int keysHashCode = Math.abs(key.hashCode());

        for (int i = 0; i < capacity; i++) {
            final int index = (keysHashCode + i) % capacity;

            if (isNull(items[index])) {
                continue;
            }

            if (((Entry)items[index]).key.equals(key)) {
                items[index] = null;
                size--;
                computeLoadFactor();
                return;
            }
        }

        throw new IllegalArgumentException();
    }

    @SuppressWarnings("unchecked")
    private void resizing() {
        capacity *= RESIZING_FACTOR;
        final Object[] newArray = new Object[capacity];

        for (Object item : items) {
            if (!isNull(item)) {
                final int keyHashCode = Math.abs(((Entry)item).key.hashCode());

                for (int j = 0; j < capacity; j++) {
                    final int index = (keyHashCode + j) % capacity;

                    if (isNull(newArray[index])) {
                        newArray[index] = item;
                        break;
                    }
                }
            }
        }

        items = newArray;
    }

    private void computeLoadFactor() {
        loadFactor = (double)size / (double)capacity;
    }
}
