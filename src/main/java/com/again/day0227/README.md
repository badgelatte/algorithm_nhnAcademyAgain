# 동시성 제어 - Building H2O

- 물질은 형태학적으로 크게 고체, 액체, 기체로 나뉜다. 그 중 물은 상온에서는 빛깔과 냄새도 없는 '액체'다. 액체란 담는 그릇에 따라 모양이 변하는 물질의 상태를 뜻한다. 만약 물이 그릇에 따라 크기가 변하지 않는 얼음이 된다면 '고체', 담는 그릇을 전부 채우는 수증기가 된다면 '기체'인 것이다.

- 두 개의 수소(H) 원자와 하나의 산소(O) 원자가 결합한 형태며 화학식으로는 'H2O'로 표기한다.

## 설명

- ThreadA는 수소를 방출합니다.
- ThreadB는 수소를 방출합니다.
- ThreadC는 산소를 방출합니다.

- empty 상태일 때, O(산소)가 방출되면 두 개의 H(수소)가 생성되도록 기다려야 합니다.
- empty 상태일 때, H(수소)가 방출되면 O(산소), H(수소)가 방출될 때까지 기다려야 합니다.
- 즉, 물을 만들기 위해서는 1개의 산소실과 2개의 수소실이 있어야 합니다.


## H2O.java

- ThreadA는 hydrogen - 실1을 실행합니다.
- ThreadB는 hydrogen - 실2을 실행합니다.
- ThreadC는 oxygen을 실행합니다.

```java
public class H2O {
    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        // 수소 방출
        releaseHydrogen.run();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        // 산소 방출
        releaseOxygen.run();
    }
}
```

## 예시

- 1단계 구현 후 2단계를 구현합니다.
- n = 1 (1단계)
    - 출력 : HHO, HOH, OHH
- n = 2 (2단계)
    - 출력 : HOHHHO, OHHHHO, HHOHOH, HOHHOH, OHHHOH, HHOOHH, HOHOHH, OHHOHH
    - 잘못된 출력 : OOHHHH, HOOHHH, HHHHOO

### [ 공부거리 ]

- [java.util.concurrent.CyclicBarrier](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CyclicBarrier.html)
- [java.util.concurrent.Semaphore](https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/java/util/concurrent/Semaphore.html)