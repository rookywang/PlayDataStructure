package com.kaiyanky2.linkedlist;


/**
 * 链表
 */
public class LinkedList<E> {


    private Node dummyHead; // 虚头结点
    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    /**
     * 获取链表结点个数
     *
     * @return 结点个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否为空
     *
     * @return true: 空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表 index 处添加元素 e
     * （链表不是这么用的，涉及到 index 的都不是常规用法，练练手）
     *
     * @param e     添加元素
     * @param index 添加元素位置
     */
    public void add(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index is illegal.");
        }

        Node pre = dummyHead;

        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = new Node(e, pre.next);
        size++; // 不要忘记维护这个变量
    }


    /**
     * 在链表头添加元素 e
     *
     * @param e 添加元素
     */
    public void addFirst(E e) {
        add(e, 0);
    }

    /**
     * 在链表尾添加元素 e
     *
     * @param e 添加元素
     */
    public void addLast(E e) {
        add(e, size);
    }


    /**
     * 获取链表 index 结点的元素
     *
     * @param index 位置
     * @return 结点元素
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index is illegal.");
        }

        Node pre = dummyHead.next; // 虚结点只是实现链表添加的小手段，所以此处第一个结点应该是虚结点的下一结点

        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        return pre.e;
    }

    /**
     * 获取链表头结点元素
     *
     * @return 头结点元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取链表尾结点元素
     *
     * @return 尾结点元素
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改 index 结点的元素
     *
     * @param e     修改后的元素
     * @param index 位置
     */
    public void set(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index is illegal.");
        }

        Node pre = dummyHead.next;

        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.e = e;
    }


    /**
     * 移除 index 结点
     *
     * @param index
     * @return 被移除结点元素
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index is illegal.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        Node del = cur.next;
        cur.next = del.next;
        cur.next = null;
        size--;

        return del.e;
    }

    /**
     * 移除链表头结点
     *
     * @return 被移除结点元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 移除链表尾结点
     *
     * @return 被移除结点元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 移除链表中第一个结点元素 e
     *
     * @param e 被移除结点元素
     */
    public void removeElements(E e) {
        Node pre = dummyHead;
        while(pre.next != null){
            if(pre.next.e.equals(e)) {
                break;
            }
            pre = pre.next;
        }

        if (pre.next != null) {
            Node del = pre.next;
            pre.next = del.next;
            del = null;
            size--;
        }
    }

    /**
     * 链表是否包含 e 元素
     *
     * @param e
     * @return true: 包含
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }

            cur = cur.next;
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("head: ");

        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            sb.append(cur.e + " -> ");
        }
        sb.append("null");

        return sb.toString();
    }

    /**
     * 结点内部类
     */
    private class Node {

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
