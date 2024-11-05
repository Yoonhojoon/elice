

```java
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(scanner.nextInt());
            list.add(scanner.nextInt());
            lists.add(list);
        }

        List<Boolean> check = new ArrayList<>(Collections.nCopies(n, false));
        check.set(k - 1, true);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(k);
        while (!queue.isEmpty()) {
            int front = queue.poll();

            for (int node : lists.get(front - 1)) {
                if (!check.get(node - 1)) {
                    queue.add(node);
                    check.set(node - 1, true);
                }
            }
        }
        System.out.println(Collections.frequency(check, false));
    }
}
```

