package com.auto.saucelab.sketchtest.pattern.uniqueObject.strategy;

public class NonResonate implements ResonateBehavior{
    @Override
    public void noise() {
        System.out.println("Zero Noise");
    }
}
