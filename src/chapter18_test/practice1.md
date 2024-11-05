

```java
import java.util.*; 

class Main { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        int n = scanner.nextInt(); // 동전의 종류 수 
        int k = scanner.nextInt(); // 만들고자 하는 금액 
        int[] dp = new int[100001]; // dp 배열 
        int[] coin = new int[101]; // 동전 배열 

        // dp 배열 초기화 
        for (int i = 1; i <= k; ++i) { 
            dp[i] = 987654321; // 큰 값으로 초기화 
        } 

        // 동전 입력 및 dp 배열 업데이트 
        for (int i = 1; i <= n; ++i) { 
            coin[i] = scanner.nextInt(); // 동전의 금액 입력 
            for (int j = coin[i]; j <= k; ++j) { 
                dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1); // 최소 동전 수 업데이트 
            } 
        } 

        // 결과 출력 
        System.out.println(dp[k]); 
        scanner.close(); 
    } 
}
```

