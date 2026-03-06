package com.again.day0227;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import java.util.HashSet;
import java.util.Set;


@Slf4j
public class H2OTest {

    static Set<String> H2OSet = new HashSet<>();

    @BeforeAll
    static void beforeAll() {
        H2OSet.add("HHO");
        H2OSet.add("HOH");
        H2OSet.add("OHH");
    }

    @Test
    @DisplayName("building H2O")
    void buildingH2OTest(){

        H2O h2O = new H2O();
        StringBuffer buffer = new StringBuffer();

        Runnable hydrogenRoom = new Runnable() {
            @Override
            public void run() {
                buffer.append("H");
            }
        };

        Runnable oxygenRoom = new Runnable() {
            @Override
            public void run() {
                buffer.append("O");
            }
        };

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    h2O.hydrogen(hydrogenRoom);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    h2O.hydrogen(hydrogenRoom);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    h2O.oxygen(oxygenRoom);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();


        for (;;) {
            if (threadA.getState().equals(Thread.State.TERMINATED) && threadB.getState().equals(Thread.State.TERMINATED)) {
                break;
            }
            Thread.yield();
        }

        log.info("buffer:{}",buffer.toString());
        Assertions.assertTrue(H2OSet.contains(buffer.toString()));
    }
}