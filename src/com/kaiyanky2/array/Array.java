package com.kaiyanky2.array;

/**
 * 数组
 * <p>
 * 各种方法主要就是围绕 "维护 data 和 size 两个变量" 进行编写
 */
public class Array<E> {

    /**
     * 整型数组
     */
    private E[] data;

    /**
     * 数组元素数量
     */
    private int size;


    /**
     * 构造数组
     *
     * @param capacity 数组容量
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 构造数组：默认容量为 10
     */
    public Array() {
        this(10);
    }

    /**
     * 判断数组是否为空
     *
     * @return true：空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取数组元素数量
     *
     * @return 数组元素数量
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     *
     * @return 数组容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 向位置 index 添加元素 e
     *
     * @param index 数组索引
     * @param e     添加元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, require \" index > 0 && index < size.\"");
        }

        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;
    }

    /**
     * 向数组所有元素前添加一个元素
     *
     * @param e 添加元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 向数组所有元素后添加一个元素
     *
     * @param e 添加元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获取位置 index 上的元素
     *
     * @param index 数组索引
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed, the index is illegal.");
        }

        return data[index];
    }

    /**
     * 获取数组第一个元素
     *
     * @return 数组第一个元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取数组最后一个元素
     *
     * @return 数组最后一个元素
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改位置 index 上的元素为 e
     *
     * @param index 数组索引
     * @param e     修改元素
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed, the index is illegal.");
        }

        data[index] = e;
    }

    /**
     * 数组是否含有元素 e
     *
     * @return true：含有
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }

        return false;
    }

    /**
     * 查找元素 e 第一次出现在数组中的位置
     *
     * @param e 数组元素
     * @return 元素索引，如果不含元素 e，返回 -1
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 删除数组中索引 index 的元素
     *
     * @param index 数组索引
     * @return 删除的元素
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed, the index is illegal.");
        }

        E removeElement = data[index];

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--; // 涉及到元素数量改变注意维护 size

        // 扩容的时候，数组满则扩容一倍，缩容时数组元素个数变为一半则缩容一半
        // 这种情况容易出现复杂度震荡，不断地缩容扩容会明显增加数组复制次数，增加复杂度
        // data.length 不能是偶数，防止 resize 后的数组长度为 0
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return removeElement;
    }

    /**
     * 删除数组第一个元素
     *
     * @return 数组被删除的第一个元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除数组最后一个元素
     *
     * @return 数组被删除的最后一个元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除数组出现的第一个元素 e
     *
     * @param e 被删除元素 e
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) { // -1 的情况不能忘记处理
            remove(index);
        }
    }

    /**
     * 将原数组容量编程 newCapacity
     *
     * @param newCapacity 数组新容量
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i ++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array：size = %d, capacity = %d\n", size, data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
