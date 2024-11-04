package com.github.kolesovv.lesson4;

import java.util.Arrays;
import java.util.Collection;

public class AstonArrayList<E> implements AstonList<E> {

    private Object[] data;
    private int count = 0;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public AstonArrayList() {
        data = new Object[DEFAULT_CAPACITY];
        size = DEFAULT_CAPACITY;
    }

    public AstonArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            data = new Object[initialCapacity];
            size = initialCapacity;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    public AstonArrayList(Collection<? extends E> collection) {
        size = collection.size();
        data = new Object[size];
        for (E e : collection) {
            data[count++] = e;
        }
    }

    @Override
    public boolean add(E e) {
        data[count++] = e;
        grow();
        return true;
    }

    @Override
    public boolean set(int index, E e) {
        if (index >= 0 && index < size) {
            data[index] = e;
            return true;
        } else {
            throw new IndexOutOfBoundsException("Index of bound: " + index);
        }
    }

    @Override
    public boolean addAll(Collection<E> collection) {
        if (size < count - 1 + collection.size()) {
            int newCapacity = size + collection.size();
            grow(newCapacity);
        }
        for (E e : collection) {
            add(e);
        }
        return true;
    }

    @Override
    public E get(int index) {
        return (E) data[index];
    }

    @Override
    public boolean remove(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < count - 1; i++) {
                data[i] = data[i + 1];
            }
            data[count - 1] = null;
            count--;
            return true;
        } else {
            throw new IndexOutOfBoundsException("Index of bound: " + index);
        }
    }

    @Override
    public int getSize() {
        return count;
    }

    private void grow() {
        if (count == size) {
            int newCapacity = size * 3 / 2 + 1;
            grow(newCapacity);
        }
    }

    private void grow(int newCapacity) {
        data = Arrays.copyOf(data, newCapacity);
        size = newCapacity;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(data, 0, count));
    }

    public static <T extends Comparable<T>> void sort(AstonList<T> list) {
        for (int i = 0; i < list.getSize(); i++) {
            for (int j = i; j < list.getSize(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    T temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }
}
