package com.auto.saucelab.sketchtest.pattern.uniqueObject.singleton.threadsafe;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.assertEquals;

public class UniqueObjectThreadSafeTest {



    @Test
   public void givenSynchronizedLazyLoadedImpl_whenCallgetInstance_thenReturnSingleton() {
        Set<UniqueObjectThreadSafe> setHoldingSingletonObj = new HashSet<>();
        List<Future<UniqueObjectThreadSafe>> futures = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Callable<UniqueObjectThreadSafe> runnableTask = () -> {
            System.out.println(("run called for:" + Thread.currentThread().getName()));
            return UniqueObjectThreadSafe.getInstance();
        };

        int count = 0;
        while(count < 10) {
            futures.add(executorService.submit(runnableTask));
            count++;
        }
        futures.forEach(e -> {
            try {
                setHoldingSingletonObj.add(e.get());
                System.out.println(setHoldingSingletonObj.add(e.get()));
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        executorService.shutdown();
        assertEquals(1, setHoldingSingletonObj.size());
    }
}
