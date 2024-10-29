

```java
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        
        // 지시사항 1. 정수 자료형을 저장하는 큐를 생성합니다.
        Queue<Integer> q = new LinkedList<>();

        // 지시사항 2. 큐에 4, 5, 2, 1의 값을 순서대로 넣습니다.
        q.add(4);
        q.add(5);
        q.add(2);
        q.add(1);
        
        // 지시사항 3. 큐에 가장 위에 있는 요소를 확인하여 출력합니다.
        System.out.println(q.peek());
        
        // 지시사항 4. 큐에 가장 위에 있는 요소를 제거합니다.
        q.remove();
        
        // 지시사항 5. 큐가 비어있는지 확인합니다.
        if (q.isEmpty()) {
            System.out.println("0");
        } else {
            System.out.println("1");
        }
        
        // 지시사항 6. 큐에 남아있는 모든 요소들을 순서대로 한 줄에 하나씩 출력 후, 제거합니다.
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
        
        // 지시사항 7. 큐에 남아있는 요소의 개수를 확인하여 출력합니다.
        System.out.println(q.size());
    }
}
```


