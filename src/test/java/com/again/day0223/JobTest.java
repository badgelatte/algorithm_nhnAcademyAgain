package com.again.day0223;

import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class JobTest {


    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("순서대로 출력")
    void printInOrder(){
        Job job = new Job();

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    job.firstJob(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("first job");
                        }
                    });
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    job.secondJob(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("second job");
                        }
                    });
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    job.thirdJob(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("third job");
                        }
                    });
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();

        for(;;){
            if(threadA.getState().equals(Thread.State.TERMINATED) && threadB.getState().equals(Thread.State.TERMINATED) && threadC.getState().equals(Thread.State.TERMINATED)){
                break;
            }
            Thread.yield();
        }

        String expected="first job"+ System.lineSeparator() + "second job" + System.lineSeparator() + "third job";
        Assertions.assertEquals(expected,outputStreamCaptor.toString().trim());

    }

}