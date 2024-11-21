package com.examples.java.reflection;

import java.lang.reflect.Method;

public class AccountSaving extends Account {

    @ApplyInterest(roi = 7.5)
    public void applyInterest() {
        double interestRate = 0;
        // Use reflection to get the interest rate from the annotation
        try {
            Method method = this.getClass().getMethod("applyInterest");
            ApplyInterest annotation = method.getAnnotation(ApplyInterest.class);
            if (annotation != null) {
                interestRate = annotation.roi();
            }
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
            //System.out.println("Method not found: " + e.getMessage());
        }

        // Calculate and apply interest
        double interest = getBalance() * (interestRate / 100);
        updateBalance(getBalance() + interest);
        System.out.println("Interest of " + interestRate + "% applied. Updated Balance: " + getBalance());
    }
}

