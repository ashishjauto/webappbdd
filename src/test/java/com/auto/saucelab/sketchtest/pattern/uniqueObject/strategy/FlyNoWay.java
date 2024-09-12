package com.auto.saucelab.sketchtest.pattern.uniqueObject.strategy;

public class FlyNoWay implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("I cant fly ");
    }
}
