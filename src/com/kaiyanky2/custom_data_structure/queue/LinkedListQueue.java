package com.kaiyanky2.custom_data_structure.queue;


/**
 * 使用链表实现 Queue
 */
public class LinkedListQueue<E> implements Queue<E> {


    private Node head, tail;
    private int size;


    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;

        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }

        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }

        Node del = head;
        head = head.next;
        del.next = null;

        if (head == null) {
            tail = null;
        }

        size--;
        return del.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }

        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedListQueue: front ");
        for (Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur + " -> ");
        }
        sb.append("null");

        return sb.toString();
    }

    /**
     * 链表结点内部类
     */
    private class Node{

        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
}
