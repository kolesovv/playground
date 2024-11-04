package com.github.kolesovv.lesson4;

import java.util.Collection;

public interface AstonList<E> {

    boolean add(E e);

    boolean set(int index, E e);

    boolean addAll(Collection<E> collection);

    E get(int index);

    boolean remove(int index);

    int getSize();
}
