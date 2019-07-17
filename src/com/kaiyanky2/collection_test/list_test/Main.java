package com.kaiyanky2.collection_test.list_test;

public class Main {

    public static final int DATA_SIZE = 200000;

    public static void main(String[] args) {

        // 比较头部插入元素
        ArrayListTest.addFromHeader(DATA_SIZE);
        LinkedListTest.addFromHeader(DATA_SIZE);

        System.out.println();

        // 比较中间插入元素
        ArrayListTest.addFromMid(DATA_SIZE);
        LinkedListTest.addFromMid(DATA_SIZE);

        System.out.println();

        // 比较尾部插入元素
        ArrayListTest.addFromTail(DATA_SIZE);
        LinkedListTest.addFromTail(DATA_SIZE);

        System.out.println();

        // 比较头部删除元素
        ArrayListTest.deleteFromHeader(DATA_SIZE);
        LinkedListTest.deleteFromHeader(DATA_SIZE);

        System.out.println();

        // 比较中间删除元素
        ArrayListTest.deleteFromMid(DATA_SIZE);
        LinkedListTest.deleteFromMid(DATA_SIZE);

        System.out.println();

        // 比较尾部删除元素
        ArrayListTest.deleteFromTail(DATA_SIZE);
        LinkedListTest.deleteFromTail(DATA_SIZE);

        System.out.println();

        // 比较实用 For 循环遍历
        ArrayListTest.getByFor(DATA_SIZE);
        LinkedListTest.getByFor(DATA_SIZE);

        System.out.println();

        // 比较实用 Iterator 循环遍历
        ArrayListTest.getByIterator(DATA_SIZE);
        LinkedListTest.getByIterator(DATA_SIZE);
    }

    /*
     * 结果，每次跑的结果略有误差，但大差不差
     *
     * ArrayList 从集合头部位置新增元素花费的时间: 2714
     * LinkedList 从集合头部位置新增元素花费的时间: 35
     *
     * ArrayList 从集合中间位置新增元素花费的时间: 1015
     * LinkedList 从集合中间位置新增元素花费的时间: 418171
     *
     * ArrayList 从集合尾部位置新增元素花费的时间: 22
     * LinkedList 从集合尾部位置新增元素花费的时间: 28
     *
     * ArrayList 从集合头部位置删除元素花费的时间: 2140
     * LinkedList 从集合头部位置删除元素花费的时间: 5
     *
     * ArrayList 从集合中间位置删除元素花费的时间: 980
     * LinkedList 从集合中间位置删除元素花费的时间: 142639
     *
     * ArrayList 从集合尾部位置删除元素花费的时间: 1
     * LinkedList 从集合尾部位置删除元素花费的时间: 7
     *
     * ArrayList for(;;) 循环花费的时间: 3
     * LinkedList for(;;) 循环花费的时间: 101448
     *
     * ArrayList 迭代器迭代循环花费的时间: 4
     * LinkedList 迭代器迭代循环花费的时间: 4
     * */
}
