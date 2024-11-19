package com.labs.java.generics;

public class GenericMethodWithBoundedParam {

    public static <E> void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.println(element);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Generic Method with Bounded Param");
        Integer[] intArray = {1, 2, 3, 4, 5};
        printArray(intArray);
        String[] stringArray = {"one", "two", "three", "four", "five"};
        printArray(stringArray);
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        printArray(doubleArray);
    }
}
