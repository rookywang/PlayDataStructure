package com.kaiyanky2.custom_data_structure.stack;

public interface Stack<E> {

    /**
     * 获取栈中元素数量
     *
     * @return
     */
    int getSize();

    /**
     * 栈中是否为空
     *
     * @return true：空
     */
    boolean isEmpty();

    /**
     * 元素入栈
     *
     * @param e 入栈元素
     */
    void push(E e);

    /**
     * 元素出栈
     *
     * @return 出栈的栈顶元素
     */
    E pop();

    /**
     * 查看栈顶元素
     *
     * @return 栈顶元素
     */
    E peek();
}
