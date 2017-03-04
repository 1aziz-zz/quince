package org.aziz.quince.rest;

/**
 * Created by aziz on 3-3-17 :)
 */

// Refactoring: Pull Up Method
    
abstract class Calculator {


    protected int numberA, numberB;

    Calculator(int a, int b) {
        this.numberA = a;
        this.numberB = b;
    }


    abstract int calculate();


/*

   CODE SMELL (see the subclasses):

    public boolean checkSum(int numberA, int numberB) {
        int sum = numberA + numberB;
        if (sum < 20) {
            return true;
        }
        return false;


    }*/

    // Refactoring: Inline

    boolean checkSum() {
        return calculate() < 20;
    }

}
