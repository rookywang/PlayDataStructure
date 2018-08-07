package com.kaiyanky2.stack;

import com.kaiyanky2.linkedlist.LinkedList;

public class Main {

    public static void main(String[] args) {

//        ArrayStack<Integer> arrayStack = new ArrayStack<>();
//        for (int i = 0; i < 6; i++) {
//            arrayStack.push(i);
//            System.out.println(arrayStack);
//        }
//
//        for (int i = 9; i < 13; i++) {
//            arrayStack.push(i);
//            if (i / 3 == 0) {
//                arrayStack.pop();
//            }
//            System.out.println(arrayStack);
//        }
//
//        System.out.println(arrayStack.peek());

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        for (int i = 0; i < 6; i++) {
            linkedListStack.push(i);
            System.out.println(linkedListStack);
        }

        linkedListStack.pop();
        System.out.println(linkedListStack);

        System.out.println(linkedListStack.peek());

    }
}
