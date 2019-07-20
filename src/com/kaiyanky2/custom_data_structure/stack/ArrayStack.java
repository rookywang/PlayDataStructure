package com.kaiyanky2.custom_data_structure.stack;

import com.kaiyanky2.custom_data_structure.array.Array;

/**
 * 使用数组实现栈
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    /**
     * 获取栈容量
     *
     * @return 栈容量
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ArrayStack: [");
        for (int i = 0; i < getSize(); i++) {
            sb.append(array.get(i));
            if (i != getSize() - 1) {
                sb.append(", ");
            }
        }
        sb.append("] top\n");

        return sb.toString();
    }
}
