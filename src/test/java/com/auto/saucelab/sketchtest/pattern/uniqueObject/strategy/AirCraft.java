package com.auto.saucelab.sketchtest.pattern.uniqueObject.strategy;

public abstract class AirCraft {

    FlyBehavior flyBehavior;
    ResonateBehavior resonateBehavior;
    public AirCraft(){


    }

    public void setFlyBehavior(FlyBehavior fb){
        flyBehavior=fb;
    }
    public void setResonateBehavior(ResonateBehavior rb){
        resonateBehavior=rb;
    }

    public abstract void display();

    public void performFly(){
        flyBehavior.fly();
    }

    public void performResonate(){
        resonateBehavior.noise();
    }


}
