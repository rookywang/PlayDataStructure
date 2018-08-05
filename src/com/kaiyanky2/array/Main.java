package com.kaiyanky2.array;

import com.kaiyanky2.array.Array;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Array<Integer> array = new Array();

        for (int i = 0; i < 10; i++) {
            array.add(i , i);
        }

        System.out.println(array.toString());

        array.removeFirst();

        System.out.println(array.toString());

        System.out.println("存在 19：" + array.contains(19));

        for (int j = 100; j < 110; j ++ ) {
            array.addLast(j);
        }

        System.out.println(array.toString());

        for (int i = 0; i < 14; i++) {
            array.removeFirst();
        }

        System.out.println(array.toString());
    }
}
