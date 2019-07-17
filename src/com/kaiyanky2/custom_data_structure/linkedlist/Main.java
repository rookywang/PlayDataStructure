package com.kaiyanky2.custom_data_structure.linkedlist;


public class Main {

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            linkedList.addLast(i);
            System.out.println(linkedList);

        }

        linkedList.set(6, 4);
        System.out.println(linkedList);

        linkedList.removeElements(2);
        System.out.println(linkedList);

        linkedList.addFirst(2);
        System.out.println(linkedList);

//        System.out.println("是否包含 5 ：" + linkedList.contains(5));
    }
}
