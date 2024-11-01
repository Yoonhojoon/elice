

```java
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.Scanner; 

public class Main { 
    static ArrayList<Integer> dfsOrder = new ArrayList<>(); 
    static ArrayList<Integer>[] graph = new ArrayList[1001]; 
    static boolean[] visited = new boolean[1001]; 
    static int N, M; 

    static void DFS(int x) { 
        dfsOrder.add(x); 
        visited[x] = true; 
        for (int next : graph[x]) { 
            if (!visited[next]) { 
                DFS(next); 
            } 
        } 
    } 

    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 

        // 입력받기 
        N = scanner.nextInt(); 
        M = scanner.nextInt(); 

        // 그래프 초기화 
        for (int i = 1; i <= N; i++) { 
            graph[i] = new ArrayList<>(); 
        } 

        // 간선 정보 입력받기 
        for (int i = 0; i < M; i++) { 
            int x = scanner.nextInt(); 
            int y = scanner.nextInt(); 
            graph[x].add(y); 
            graph[y].add(x); 
        } 

        // 인접 리스트 정렬 
        for (int i = 1; i <= N; i++) { 
            Collections.sort(graph[i]); 
        } 

        // DFS 호출 
        DFS(1); 

        // DFS 순서 출력 
        for (int node : dfsOrder) { 
            System.out.print(node + " "); 
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