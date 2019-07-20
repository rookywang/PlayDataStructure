package com.kaiyanky2.custom_data_structure.queue;

public class Main {

    public static void main(String[] args) {

//        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
//
//        for (int i = 1; i < 13; i++) {
//            arrayQueue.enqueue(i);
//            if (i == 5 || i == 8 || i == 9) {
//                arrayQueue.dequeue();
//            }
//            System.out.println(arrayQueue);
//        }

//        LoopQueue<Integer> queue = new LoopQueue<>();
//        for(int i = 0 ; i < 10 ; i ++){
//            queue.enqueue(i);
//            System.out.println(queue);
//
//            if(i % 3 == 2){
//                queue.dequeue();
//                System.out.println(queue);
//            }
//        }
//
//        System.out.println("front: " + queue.getFront());

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        for (int i = 0; i < 5; i++) {
            linkedListQueue.enqueue(i);
            System.out.println(linkedListQueue);
        }

        linkedListQueue.dequeue();

        System.out.println(linkedListQueue);
    }
}
