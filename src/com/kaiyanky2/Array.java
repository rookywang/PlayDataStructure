package com.kaiyanky2;

/**
 * 数组
 * <p>
 * 各种方法主要就是围绕 "维护 data 和 size 两个变量" 进行编写
 */
public class Array {

    /**
     * 整型数组
     */
    private int[] data;

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
        data = new int[capacity];
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
    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("Add failed, the array is full!");
        }

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, require \" index > 0 && index < size.\"");
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
    public void addFirst(int e) {
        add(0, e);
    }

    /**
     * 向数组所有元素后添加一个元素
     *
     * @param e 添加元素
     */
    public void addLast(int e) {
        add(size, e);
    }

    /**
     * 获取位置 index 上的元素
     *
     * @param index 数组索引
     * @return
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed, the index is illegal.");
        }

        return data[index];
    }

    /**
     * 修改位置 index 上的元素为 e
     *
     * @param index 数组索引
     * @param e     修改元素
     */
    public void set(int index, int e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed, the index is illegal.");
        }

        data[index] = e;
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
