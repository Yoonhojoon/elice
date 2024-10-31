

```java
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static int N;
    private static int M;
    private static char[] answer;
    private static boolean[] isSelected;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        // 입력값 N과 M을 받음
        N = sc.nextInt();
        M = sc.nextInt();

        // 정답을 저장할 배열 및 선택 여부를 저장할 배열 초기화
        answer = new char[M * 2];
        isSelected = new boolean[N];

        // 출력 형식 설정 (숫자 사이에 공백 추가)
        for (int i = 0; i < M; i++)
            answer[i * 2 + 1] = ' ';
        answer[M * 2 - 1] = '\n';

        // 재귀 호출 시작
        recursion(0);
        System.out.println(sb);
    }

    private static void recursion(int num) throws Exception {
        // 모든 숫자를 선택했으면 정답을 StringBuilder에 추가
        if (num == M) {
            sb.append(answer);
            return;
        }

        // 숫자를 선택하고 재귀적으로 다음 숫자를 선택
        for (int i = 0; i < N; i++) {
            if (isSelected[i])
                continue;
            
            // 현재 선택한 숫자를 정답 배열에 저장
            answer[num * 2] = (char) ('1' + i);
            isSelected[i] = true;

            // 다음 숫자 선택을 위한 재귀 호출
            recursion(num + 1);

            // 백트래킹을 위해 선택 해제
            isSelected[i] = false;
        }
    }
}

```




```java

```




```java

```




```java

```