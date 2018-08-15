package com.kaiyanky2.map;

import com.kaiyanky2.binarytree.BinarySearchTree;

public class Main {

    public static void main(String[] args) {

        String[] texts = {"vjkds" ,"dod", "coabv", "nacjda", "anjda"
                , "dncac", "cnjacoa", "nvjdan", "hhh", "hhh", "cnja"
                , "acajcdna", "jj", "jj", "jj", "kk"};

        LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();

        for (String text:
             texts) {
            if (linkedListMap.contains(text)) {
                linkedListMap.add(text, linkedListMap.get(text) + 1);
            } else {
                linkedListMap.add(text, 1);
            }
        }

        System.out.println("LinkedListMap - Total words: " + texts.length);
        System.out.println("LinkedListMap - Total different words: " + linkedListMap.getSize());

        System.out.println();

        BinarySearchTreeMap<String, Integer> binarySearchTreeMap = new BinarySearchTreeMap<>();
        for (String text:
                texts) {
            if (binarySearchTreeMap.contains(text)) {
                binarySearchTreeMap.add(text, linkedListMap.get(text) + 1);
            } else {
                binarySearchTreeMap.add(text, 1);
            }
        }

        System.out.println("BinarySearchTreeMap - Total words: " + texts.length);
        System.out.println("BinarySearchTreeMap - Total different words: " + binarySearchTreeMap.getSize());
        System.out.println("hhh: " + binarySearchTreeMap.get("hhh") );
    }
}
