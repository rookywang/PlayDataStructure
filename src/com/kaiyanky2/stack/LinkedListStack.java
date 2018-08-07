package com.kaiyanky2.stack;

import com.kaiyanky2.linkedlist.LinkedList;

public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> linkedList;

    public LinkedListStack() {
        linkedList = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addLast(e);
    }

    @Override
    public E pop() {
        return linkedList.removeLast();
    }

    @Override
    public E peek() {
        return linkedList.getLast();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("LinkedListStack: "));
        sb.append("[");
        for (int i = 0; i < getSize(); i++) {
            sb.append(linkedList.get(i));
            if (i != getSize() - 1) {
                sb.append(", ");
            }
        }
        sb.append("] top");

        return sb.toString();
    }
}
