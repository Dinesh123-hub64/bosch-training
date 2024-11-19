package com.labs.java.generics;

public class GenericClassDemo {

    public static void main(String[] args) {

        GenericPrinter<Integer> obj = new GenericPrinter<>();
        obj.setSomeValue(10);
        obj.printSomeValue();

        GenericPrinter<Double> obj1 = new GenericPrinter<>();
        //obj.setSomeValue(10.5);
        obj.printSomeValue();

        GenericPrinter<String> obj2 = new GenericPrinter<>();
        //obj.setSomeValue("Generics Demo");
        obj.printSomeValue();
    }
}