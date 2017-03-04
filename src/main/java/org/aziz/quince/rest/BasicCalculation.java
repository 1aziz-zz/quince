package org.aziz.quince.rest;

/**
 * Created by aziz on 3-3-17 :)
 */
public class BasicCalculation extends Calculator {

    BasicCalculation(int numberA, int numberB) {
        super(numberA, numberB);
    }

    @Override
    public int calculate() {
        return numberA + numberB;
    }
}
