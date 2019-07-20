package com.kaiyanky2.collection_test.list_test;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {

    public static void addFromHeader(int dataSize) {
        ArrayList<String> list = new ArrayList<>(dataSize);
        int i = 0;
        long timeStart = System.currentTimeMillis();
        while (i < dataSize) {
            list.add(0, i + "al");
            i++;
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("ArrayList 从集合头部位置新增元素花费的时间: " + (timeEnd - timeStart));
    }

    public static void addFromMid(int dataSize) {
        ArrayList<String> list = new ArrayList<>(dataSize);
        int i = 0;
        long timeStart = System.currentTimeMillis();
        while (i < dataSize) {
            int temp = list.size();
            list.add(temp / 2, i + "al");
            i++;
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("ArrayList 从集合中间位置新增元素花费的时间: " + (timeEnd - timeStart));
    }

    public static void addFromTail(int dataSize) {
        ArrayList<String> list = new ArrayList<>(dataSize);
        int i = 0;
        long timeStart = System.currentTimeMillis();
        while (i < dataSize) {
            list.add(i + "al");
            i++;
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("ArrayList 从集合尾部位置新增元素花费的时间: " + (timeEnd - timeStart));
    }

    public static void deleteFromHeader(int dataSize) {
        ArrayList<String> list = new ArrayList<>();
        int i = 0;
        while (i < dataSize) {
            list.add(i + "al");
            i++;
        }
        long timeStart = System.currentTimeMillis();
        i = 0;
        while (i < dataSize) {
            list.remove(0);
            i++;
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("ArrayList 从集合头部位置删除元素花费的时间: " + (timeEnd - timeStart));
    }

    public static void deleteFromMid(int dataSize) {
        ArrayList<String> list = new ArrayList<>();
        int i = 0;
        while (i < dataSize) {
            list.add(i + "al");
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
        System.out.println("ArrayList 从集合中间位置删除元素花费的时间: " + (timeEnd - timeStart));
    }

    public static void deleteFromTail(int dataSize) {
        ArrayList<String> list = new ArrayList<>();
        int i = 0;
        while (i < dataSize) {
            list.add(i + "al");
            i++;
        }
        long timeStart = System.currentTimeMillis();
        i = 0;
        while (i < dataSize) {
            int temp = list.size();
            list.remove(temp - 1);
            i++;
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("ArrayList 从集合尾部位置删除元素花费的时间: " + (timeEnd - timeStart));
    }

    public static void getByFor(int dataSize) {
        ArrayList<String> list = new ArrayList<>();
        int i = 0;
        while (i < dataSize) {
            list.add(i + "al");
            i++;
        }
        long timeStart = System.currentTimeMillis();
        for (int j = 0; j < dataSize; j++) {
            list.get(j);
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("ArrayList for(;;) 循环花费的时间: " + (timeEnd - timeStart));
    }

    public static void getByIterator(int dataSize) {
        ArrayList<String> list = new ArrayList<>();
        int i = 0;
        while (i < dataSize) {
            list.add(i + "al");
            i++;
        }
        long timeStart = System.currentTimeMillis();
        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            it.next();
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("ArrayList 迭代器迭代循环花费的时间: " + (timeEnd - timeStart));
    }

}
