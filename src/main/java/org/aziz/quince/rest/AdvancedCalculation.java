package org.aziz.quince.rest;

/**
 * Created by aziz on 3-3-17 :)
 */
public class AdvancedCalculation extends Calculator {

    public AdvancedCalculation(int numberA, int numberB) {
        super(numberA, numberB);
    }

    @Override
    public int calculate() {
        return numberA + numberB;
    }


}
