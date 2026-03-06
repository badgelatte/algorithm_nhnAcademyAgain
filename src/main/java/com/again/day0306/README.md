# Blocking Queue 구현

- Thread safe bounded blocking queue를 구현합니다.

## BoundedBlockingQueue.java

```java
public class BoundedBlockingQueue {
    private Queue<Integer> queue;
    private int capacity;

    public BoundedBlockingQueue(int capacity) {
        // TODO 1.생성자는 capacity 값으로 queue를 초기화 합니다.
        // queue는 LinkedList를 사용합니다.
    }

    public void enqueue(int element) throws InterruptedException {
        // TODO 2.queue에 element를 추가합니다.
        // queue가 가득차면 enqueue 메서드를 호출하는 Thread는 queue가 가득 차지 않을 때까지 대기 합니다.
    }

    public int dequeue() throws InterruptedException {
        // TODO 3.queue에서 뒤쪽에(가장 먼저 들어온) 있는 요소들을 반환하고 제거 합니다.

        return 0;
    }

    public int size() {
        // TODO 4.현재 queue의 size를 반환합니다.
        return 0;
    }
}
```

## [Testcode가 통과하도록 구현합니다.](/src/test/java/com/nhnacademy/aiot/BoundedBlockingQueueTest.java)

## 공부거리
- [BlockingQueue](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/BlockingQueue.html)