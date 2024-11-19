package com.labs.java.generics;

import java.util.ArrayList;
import java.util.List;

public class WildCardGenericsDemo {

    //private List<Integer> nos = new ArrayList<>();

    //private List<Comparable> nos = new ArrayList<>();

    //private List<Comparable> skills = List.of("A", "B", "C");

    WildCardGenericsDemo() {
//        nos.add(1);
//        nos.add(2);
//        nos.add(3);
//        nos.add(10L);
//        printList(nos);
//        printList(skills);

    }

    // PECS - Producer Extends Consumer Super

    //Upper Bounded Wildcard
//    public void printList(List<? extends Comparable> list) {
//        for (Object obj : list) {
//            System.out.println(obj);
//        }
//    }
//Unbounded wildcard
    public void printList(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        WildCardGenericsDemo demo = new WildCardGenericsDemo();
        //System.out.println(demo.nos);
    }
}
