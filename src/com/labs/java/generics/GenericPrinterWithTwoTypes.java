package com.labs.java.generics;

public class GenericPrinterWithTwoTypes<T, U> {

    private T someValue;
    private U otherValue;
    public GenericPrinterWithTwoTypes(T someValue, U otherValue) {
    this.someValue = someValue;
    this.otherValue = otherValue;
    }
    public T getSomeValue() {
        return someValue;
    }
    public void setSomeValue(T someValue) {
        this.someValue = someValue;
    }
    public U getOtherValue() {
        return otherValue;
    }
    public void setOtherValue(U otherValue) {
        this.otherValue = otherValue;
    }

    public static void main(String[] args) {
        //GenericPrinterWithTwoTypes<Integer , String> printer = new GenericPrinterWithTwoTypes<>();
        //printer.setSomeValue(1);
        //printer.otherValue = "Hello World";

        //Raw Type
        //GenericPrinterWithTwoTypes<Integer,S>

    }
}
