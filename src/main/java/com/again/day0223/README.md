# 순서대로 출력

## 설명
* Job class의 instance가 각각 다른 threadA, threadB, threadC 로 전달 됩니다.
* 호출되는 순서는 다음과 같습니다.
    * threadA는 firstJob() method를 호출합니다.
    * threadB는 secondJob() method를 호출합니다.
    * threadC는 thirdJob() method를 호출합니다.

## 문제
* 다음과 같이 출력되도록 Job.java를 수정하세요
----
first job\
second job\
third job
----

## Job.java

[java]
----
```
public class Job {

    public void firstJob(Runnable job) throws InterruptedException {
        job.run();
    }

    public void secondJob(Runnable job) throws InterruptedException{
        job.run();
    }

    public void thirdJob(Runnable job) throws InterruptedException{
        job.run();
    }

}
```
----

## Test Code

* link:src/test/java/com/nhnacademy/JobTest.java[JobTest.java]를 통과해야 합니다.