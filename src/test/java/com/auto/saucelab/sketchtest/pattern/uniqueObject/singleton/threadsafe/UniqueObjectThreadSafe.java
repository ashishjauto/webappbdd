package com.auto.saucelab.sketchtest.pattern.uniqueObject.singleton.threadsafe;

public class UniqueObjectThreadSafe {
    private UniqueObjectThreadSafe(){

    }


private static class SingelTonProvider{
        private static final UniqueObjectThreadSafe SINGLETON_INSTANCE = new UniqueObjectThreadSafe();
}

public static UniqueObjectThreadSafe getInstance(){
        return SingelTonProvider.SINGLETON_INSTANCE;

}


}
