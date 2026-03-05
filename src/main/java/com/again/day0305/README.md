# 식물 광합성하기

## 설명
* ThreadA는 탄소를 방출 합니다.
* ThreadB는 산소를 방출 합니다.
* ThreadC는 산소를 방출 합니다.
* ThreadD는 이산화탄소를 소모해 광합성 합니다.
* 식물이 광합성을 하기 위해선 빛과 이산화탄소(CO2) 가 필요합니다. 따라서 "COO", "OCO", "OOC" 가 아닌 분자는 사용하지 못 합니다.


## Photosynthesis.java

[java]
```
public class H2O {

    private final int count;

    public void carbon(Runnable releaseCarbon) throws InterruptedException {

        //탄소 방출
        releaseCarbon.run();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        //산소 방출
        releaseOxygen.run();
    }

    public void consume(Runnable consumeMolecules) throws InterruptedException{

        //이산화탄소 소모
        consumeMolecules.run();
    }
}


```
## 테스트 입력

* Photosynthesis 객체는 생성시 광합성 횟수를 입력받습니다.
  입력받은 횟수만큼 이산화탄소를 생성하고 분자를 소모하도록 코드를 작성하세요.

* assert 메서드는 각각 남아있는 분자 혹은 원자가 있는지,
  그리고 입력받은 횟수와 실제 광합성 횟수가 동일한지 확인합니다.

