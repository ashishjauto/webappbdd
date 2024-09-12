package com.auto.saucelab.sketchtest.pattern.uniqueObject.strategy;

public class FlyGasoline implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("to fly need gasoline");
    }
}
