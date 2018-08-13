package com.kaiyanky2.set;

public interface Set<E> {

    /**
     * 向集合中添加元素 e
     *
     * @param e
     */
    void add(E e);

    /**
     * 集合中是否包含元素 e
     *
     * @param e
     * @return true: 包含
     */
    boolean contains(E e);

    /**
     * 移除元素 e
     *
     * @param e
     */
    void remove(E e);

    /**
     * 集合大小
     *
     * @return 集合大小
     */
    int getSize();

    /**
     * 集合是否为空
     *
     * @return true: 空
     */
    boolean isEmpty();
}
