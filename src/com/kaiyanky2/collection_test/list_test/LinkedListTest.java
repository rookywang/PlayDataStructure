package com.kaiyanky2.collection_test.list_test;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTest {

    public static void addFromHeader(int dataSize) {
        LinkedList<String> list = new LinkedList<>();
        int i = 0;
        long timeStart = System.currentTimeMillis();
        while (i < dataSize) {
            list.addFirst(i + "ll");
            i++;
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("LinkedList 从集合头部位置新增元素花费的时间: " + (timeEnd - timeStart));
    }

    public static void addFromMid(int dataSize) {
        LinkedList<String> list = new LinkedList<>();
        int i = 0;
        long timeStart = System.currentTimeMillis();
        while (i < dataSize) {
            int temp = list.size();
            list.add(temp / 2, i + "ll");
            i++;
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("LinkedList 从集合中间位置新增元素花费的时间: " + (timeEnd - timeStart));
    }

    public static void addFromTail(int dataSize) {
        LinkedList<String> list = new LinkedList<>();
        int i = 0;
        long timeStart = System.currentTimeMillis();
        while (i < dataSize) {
            list.add(i + "ll");
            i++;
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("LinkedList 从集合尾部位置新增元素花费的时间: " + (timeEnd - timeStart));
    }

    public static void deleteFromHeader(int dataSize) {
        LinkedList<String> list = new LinkedList<>();
        int i = 0;
        while (i < dataSize) {
            list.add(i + "ll");
            i++;
        }
        long timeStart = System.currentTimeMillis();
        i = 0;
        while (i < dataSize) {
            list.removeFirst();
            i++;
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("LinkedList 从集合头部位置删除元素花费的时间: " + (timeEnd - timeStart));
    }

    public static void deleteFromMid(int dataSize) {
        LinkedList<String> list = new LinkedList<>();
        int i = 0;
        while (i < dataSize) {
            list.add(i + "ll");
            i++;
        }
        long timeStart = System.currentTimeMillis();
        i = 0;
        while (i < dataSize) {
            int temp = list.size();
            list.remove(temp / 2);
            i++;
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("LinkedList 从集合中间位置删除元素花费的时间: " + (timeEnd - timeStart));
    }

    public static void deleteFromTail(int dataSize) {
        LinkedList<String> list = new LinkedList<>();
        int i = 0;
        while (i < dataSize) {
            list.add(i + "ll");
            i++;
        }
        long timeStart = System.currentTimeMillis();
        i = 0;
        while (i < dataSize) {
            list.removeLast();
            i++;
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("LinkedList 从集合尾部位置删除元素花费的时间: " + (timeEnd - timeStart));
    }

    public static void getByFor(int dataSize) {
        LinkedList<String> list = new LinkedList<>();
        int i = 0;
        while (i < dataSize) {
            list.add(i + "ll");
            i++;
        }
        long timeStart = System.currentTimeMillis();
        for (int j = 0; j < dataSize; j++) {
            list.get(j);
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("LinkedList for(;;) 循环花费的时间: " + (timeEnd - timeStart));
    }

    public static void getByIterator(int dataSize) {
        LinkedList<String> list = new LinkedList<>();
        int i = 0;
        while (i < dataSize) {
            list.add(i + "ll");
            i++;
        }
        long timeStart = System.currentTimeMillis();
        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            it.next();
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("LinkedList 迭代器迭代循环花费的时间: " + (timeEnd - timeStart));
    }
}
