package com.auto.saucelab.sketchtest.pattern.uniqueObject.singleton.stat;

public class OneObjectClass {

    private static OneObjectClass uniqueInstance;

   private OneObjectClass(){

    }



    public static OneObjectClass getUniqueInstance(){
        if(uniqueInstance== null){
            uniqueInstance= new OneObjectClass();

        }
        return uniqueInstance;
    }

    public String getDescription(){
       return "I m classic SingleTon";
    }

}
