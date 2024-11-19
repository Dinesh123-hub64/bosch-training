package com.labs.java.generics;

public class GenericDemo {

//    public static void printArray(Integer[] inputArray){
//        for (Integer element : inputArray){
//            System.out.println(element);
//        }
//        System.out.println();
//    }
//
//    public static void printArray(String[] inputArray){
//        for (String element : inputArray){
//            System.out.println(element);
//        }
//        System.out.println();
//    }

    public static <E> void printArray(E[] inputArray){
        for (E element : inputArray){
            System.out.printf("%s: " , element);
        }
        System.out.println();
    }

    public static void main(String[] args) {
    System.out.println("Generics Demo");
    Integer[] inputArray = {1,2,3,4,5};
    printArray(inputArray);
    String[] inputArray2 = {"a","b","c","d"};
    printArray(inputArray2);
    Double[] inputArray3 = {1.0,2.0,3.0,4.0,5.0};
    printArray(inputArray3);
 }
}