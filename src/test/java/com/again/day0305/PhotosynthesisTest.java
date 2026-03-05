package com.again.day0305;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

    public class PhotosynthesisTest {

    @ParameterizedTest(name = "{index} :  Photosynthesis Count -> {0}")
    @ValueSource(ints = { 1, 5, 7, 2, 3 })
    @DisplayName("광합성")
    void photosynthesis(int count) throws InterruptedException {

        Photosynthesis photosynthesis = new Photosynthesis(count);
        Plant plant = new Plant();

        StringBuffer buffer = new StringBuffer();

        Runnable carbonRoom = () -> buffer.append("C");
        Runnable oxygenRoom = () -> buffer.append("O");
        Runnable plantRoom = () -> plant.consumeMolecule(buffer);

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    photosynthesis.carbon(carbonRoom);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    photosynthesis.oxygen(oxygenRoom);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    photosynthesis.oxygen(oxygenRoom);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread threadD = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    photosynthesis.consume(plantRoom);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

        threadD.join();

        assertEquals(0, buffer.length());
        assertEquals(photosynthesis.getCount(), plant.getConsumeCount());

    }

}