package com.auto.saucelab.sketchtest.pattern.uniqueObject.singleton.stat;

public class UniqueObjectTest {

    public static void main(String[] args) {
        OneObjectClass objectClass =OneObjectClass.getUniqueInstance();

        System.out.println(  objectClass.getDescription());


        OneObjectClass objectClass1 =OneObjectClass.getUniqueInstance();
        System.out.println(  objectClass1.getDescription());



        System.out.println("test");
    }
}
