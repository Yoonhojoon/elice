

```java
import java.util.*;

public class Main {
    static List<Integer> bfsOrder = new ArrayList<>();
    static List<Integer>[] graph = new ArrayList[2001];
    static boolean[] visited = new boolean[30001];
    static int N, M;

    public static void BFS(int x) {
        Queue<Integer> q = new LinkedList<>();

        visited[x] = true;
        q.add(x);
        bfsOrder.add(x);

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int next : graph[node]) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                    bfsOrder.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        for (int i = 0; i < 2001; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            graph[x].add(y);
        }

        for (int i = 0; i < 2001; i++) {
            Collections.sort(graph[i]);
        }

        BFS(1);
        for (int idx : bfsOrder) {
            System.out.print(idx + " ");
        }

        scanner.close();
    }
}

```




```java

```




```java

```




```java

```