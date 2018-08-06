package com.kaiyanky2.queue;

public interface Queue<E> {


    /**
     * 获取队列元素个数
     *
     * @return 元素个数
     */
    int getSize();

    /**
     * 队列是否为空
     *
     * @return true: 空
     */
    boolean isEmpty();

    /**
     * 元素入队
     *
     * @param e 入队元素
     */
    void enqueue(E e);

    /**
     * 元素出队
     *
     * @return 出队元素
     */
    E dequeue();

    /**
     * 获取队头元素
     *
     * @return 队头元素
     */
    E getFront();

}
