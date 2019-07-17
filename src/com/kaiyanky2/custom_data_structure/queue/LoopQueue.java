package com.kaiyanky2.custom_data_structure.queue;

/**
 * 循环队列
 * 新增维护 front 与 tail 索引
 * 解决数组队列出队操作复杂度 O(n) 的问题
 * <p>
 * 重点就在于 front 与 tail 之间的关系
 * 队列空：front == tail
 * 队列满：front == (tail + 1) % data.length
 */
public class LoopQueue<E> implements Queue<E> {


    private E[] data;

    private int front, tail;

    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(2 * getCapacity());
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty!");
        }

        E e = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty！");
        }
        return data[front];
    }

    /**
     * 获取队列容量
     *
     * @return 队列容量
     */
    public int getCapacity() {
        return data.length - 1; // 循环队列浪费一个空间，所以数组的容量是 data.length - 1
    }

    /**
     * 动态调整队列容量
     *
     * @param newCapacity 新的容量
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length]; // 复制是从 data 的 front 开始，一直到 tail
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("LoopQueue: size = %d, capacity = %d\n", size, getCapacity()));
        sb.append("Front: [");
        for (int i = front; i != tail; i = (i + 1) % data.length) { // 打印是从 front 开始，一直到 tail
            sb.append(data[i]);
            if ((i + 1) % data.length != tail) {
                sb.append(", ");
            }
        }
        sb.append("] Tail\n");

        return sb.toString();
    }
}
