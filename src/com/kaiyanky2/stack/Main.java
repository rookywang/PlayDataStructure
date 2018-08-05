package com.kaiyanky2.stack;

public class Main {

    public static void main(String[] args) {

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        for (int i = 0; i < 6; i++) {
            arrayStack.push(i);
            System.out.println(arrayStack);
        }

        for (int i = 9; i < 13; i++) {
            arrayStack.push(i);
            if (i / 3 == 0) {
                arrayStack.pop();
            }
            System.out.println(arrayStack);
        }

        System.out.println(arrayStack.peek());

    }
}
