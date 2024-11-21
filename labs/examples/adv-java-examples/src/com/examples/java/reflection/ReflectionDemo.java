package com.examples.java.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

class Example {
    private String message;

    public Example() {
        this.message = "Default Message";
    }

    public Example(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println("Message: " + message);
    }

    private void setMessage(String message) {
        this.message = message;
    }
}

public class ReflectionDemo {
    public static void main(String[] args) {
        try {
            // Get the Class object
            Class<?> clazz = Example.class;

            // Print class name
            System.out.println("Class Name: " + clazz.getName());

            // Print constructors
            System.out.println("\nConstructors:");
            for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
                System.out.println(" - " + constructor);
            }

            // Print methods
            System.out.println("\nMethods:");
            for (Method method : clazz.getDeclaredMethods()) {
                System.out.println(" - " + method.getName());
            }

            // Print fields
            System.out.println("\nFields:");
            for (Field field : clazz.getDeclaredFields()) {
                System.out.println(" - " + field.getName());
            }

            // Create an instance using the default constructor
            Object obj = clazz.getDeclaredConstructor().newInstance();

            // Invoke the public method
            Method printMessageMethod = clazz.getMethod("printMessage");
            printMessageMethod.invoke(obj);

            // Access private field and modify it
            Field messageField = clazz.getDeclaredField("message");
            messageField.setAccessible(true); // Make the private field accessible
            messageField.set(obj, "Modified Message");

            // Invoke the private method to set a new message
            Method setMessageMethod = clazz.getDeclaredMethod("setMessage", String.class);
            setMessageMethod.setAccessible(true); // Make the private method accessible
            setMessageMethod.invoke(obj, "Reflection Modified Message");

            // Invoke the public method again to see the changes
            printMessageMethod.invoke(obj);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

