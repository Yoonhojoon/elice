

```java
import java.io.*;

class Main {
    static int r, c, sum;

    public static void sol(int x, int y, int n) {
        // 목표 위치에 도달했으면 현재까지의 합을 출력하고 종료
        if (x == r && y == c) {
            System.out.print(sum);
            return;
        }

        // 현재 범위에 목표 위치가 포함되어 있는 경우 재귀적으로 4분면 탐색
        if (x <= r && r < x + n && y <= c && c < y + n) {
            sol(x, y, n / 2); // 1사분면
            sol(x, y + n / 2, n / 2); // 2사분면
            sol(x + n / 2, y, n / 2); // 3사분면
            sol(x + n / 2, y + n / 2, n / 2); // 4사분면
        } else {
            // 현재 범위에 목표 위치가 없으면 전체 영역의 크기를 합산
            sum += n * n;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력값을 받아 r, c, n 초기화
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        r = Integer.parseInt(input[1]);
        c = Integer.parseInt(input[2]);
        
        // 전체 영역 탐색 시작 (0, 0)부터 (1 << n) 크기까지
        sol(0, 0, 1 << n);
    }
}

```




```java

```




```java

```




```java

```