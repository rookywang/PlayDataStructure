package com.kaiyanky2.custom_data_structure.heap;

import com.kaiyanky2.custom_data_structure.array.Array;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> array;

    public MaxHeap(int capacity) {
        array = new Array<>(capacity);
    }

    public MaxHeap() {
        array = new Array<>();
    }

    public MaxHeap(E[] arr) {
        array = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    /**
     * 返回堆中元素个数
     *
     * @return 元素个数
     */
    public int getSize() {
        return array.getSize();
    }

    /**
     * 堆是否为空
     *
     * @return true: 空
     */
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 找到堆中元素父节点索引
     *
     * @param index
     * @return 父节点索引
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("Index - 0 does not have parent.");
        }

        return (index - 1) / 2;
    }

    /**
     * 找到堆中元素左子节点索引
     *
     * @param index
     * @return 左子节点索引
     */
    private int left(int index) {
        return 2 * index + 1;
    }

    /**
     * 找到堆中元素右子节点索引
     *
     * @param index
     * @return 右子节点索引
     */
    private int right(int index) {
        return 2 * index + 2;
    }


    /**
     * 向堆中添加元素
     *
     * @param e
     */
    public void add(E e) {
        array.addLast(e);
        siftUp(array.getSize() - 1);
    }

    /**
     * 当 index 节点大于父节点的时候，"上浮"操作，交换此节点与父节点
     *
     * @param index 节点在数组中的索引
     */
    private void siftUp(int index) {
        while (index > 0 && array.get(parent(index)).compareTo(array.get(index)) < 0){
            array.swap(index, parent(index));
            index = parent(index);
        }
    }

    /**
     * 找到堆中最大元素
     *
     * @return 最大元素
     */
    public E findMax() {
        if (array.getSize() == 0) {
            throw new IllegalArgumentException("Heap is empty.");
        }

        return array.get(0);
    }

    /**
     * 堆中提取最大值
     *
     * @return
     */
    public E extractMax() {
        E max = findMax();
        array.swap(0, array.getSize() - 1);
        array.removeLast();

        siftDown(0);

        return max;
    }

    /**
     * 当节点小于它的子节点时，"下沉"操作，交换此节点与子节点
     *
     * 非常重要啊
     *
     * @param index
     */
    private void siftDown(int index) {
        while (left(index) < array.getSize()) {
            int j = left(index);

            // 找到左子节点与右子节点的最大的一个
            if (j + 1 < array.getSize()
                    && array.get(j + 1).compareTo(array.get(j)) > 0) {
                j++;
            }

            // 如果这个节点比它的两个子节点都大，就 OK 了
            if (array.get(index).compareTo(array.get(j)) > 0) {
                break;
            }

            array.swap(index, j);
            index = j;
        }

    }

    /**
     * 取出堆中最大元素，并替换成 e
     *
     * @param e
     * @return 取出的元素
     */
    public E replace(E e) {
        E root = findMax();
        array.set(0, e);
        siftDown(0);
        return root;
    }
}
