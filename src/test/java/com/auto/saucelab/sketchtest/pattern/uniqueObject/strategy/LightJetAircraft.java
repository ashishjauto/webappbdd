package com.auto.saucelab.sketchtest.pattern.uniqueObject.strategy;

public class LightJetAircraft extends AirCraft{


    public LightJetAircraft(){
        flyBehavior= new FlyGasoline();
        resonateBehavior= new LowResonate();
    }


    @Override
    public void display() {

    }
}
