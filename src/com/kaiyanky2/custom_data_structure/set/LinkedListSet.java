package com.kaiyanky2.custom_data_structure.set;


import com.kaiyanky2.custom_data_structure.linkedlist.LinkedList;

public class LinkedListSet<E extends Comparable<E>> implements Set<E> {


    private LinkedList<E> linkedList;

    public LinkedListSet() {
        linkedList = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!linkedList.contains(e)) {
            linkedList.addFirst(e);
        }
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public void remove(E e) {
        linkedList.removeElements(e);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
