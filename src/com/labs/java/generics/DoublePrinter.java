package com.labs.java.generics;

public class DoublePrinter {

    private Double someValue;

    public void setSomeValue(Double someValue) {
        this.someValue = someValue;
    }

    public Double getSomeValue() {
        return someValue;
    }

    public void printSomeValue() {
        System.out.println(someValue);
    }
}
