import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        // 기본적으로 작은 값이 높은 우선순위를 갖도록 하는 우선순위 큐
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // 큐에 요소 추가
        priorityQueue.add(20);
        priorityQueue.add(15);
        priorityQueue.add(10);
        priorityQueue.add(5);

        // 큐의 요소를 하나씩 제거하면서 출력
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }
}