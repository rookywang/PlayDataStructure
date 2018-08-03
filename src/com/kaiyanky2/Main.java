package com.kaiyanky2;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Array array = new Array();

        for (int i = 0; i < 5; i++) {
            array.add(i , i);
        }

        System.out.println(array.toString());
    }
}
