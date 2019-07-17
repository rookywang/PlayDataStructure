package com.kaiyanky2.custom_data_structure.set;

import java.util.ArrayList;

public class Main {

    public static void main(String args[]) {

        String[] texts = {"vjkds" ,"dod", "coabv", "nacjda", "anjda"
                , "dncac", "cnjacoa", "nvjdan", "hhh", "hhh", "cnja"
                , "acajcdna", "jj", "jj", "jj", "kk"};

        ArrayList<String> strings = new ArrayList<>();
        for (String text:
             texts) {
            strings.add(text);
        }

        BinarySearchTreeSet<String> searchTreeSet = new BinarySearchTreeSet<>();
        for (String text:
             strings) {
            searchTreeSet.add(text);
        }

        System.out.println("Total words: " + strings.size());
        System.out.println("Total different words: " + searchTreeSet.getSize());

        System.out.println();

        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        for (String text:
             strings) {
            linkedListSet.add(text);
        }

        System.out.println("Total words: " + strings.size());
        System.out.println("Total different words: " + linkedListSet.getSize());
    }
}
