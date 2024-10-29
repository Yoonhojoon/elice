

```java
public class Main {
    public static void main(String[] args) {
        // 지시사항 1. 크기 3 X 5의 배열 arr를 선언합니다.
        int[][] arr = new int[3][5];

        // 지시사항 2. 2중 for문을 사용하여 arr 배열에 1부터 15까지의 수를 순서대로 넣습니다.
        int num = 1;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 5; ++j) {
                arr[i][j] = num;
                num++;
            }
        }

        // 배열 요소 출력
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 5; ++j) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
                     
        // 지시사항 3. 지시사항에 맞게 데이터를 변경합니다.
        
        // arr 배열의 2행 3열의 데이터를 10으로 변경합니다.
        arr[1][2] = 10;
        
        // arr 배열의 1행 1열의 데이터를 7로 변경합니다.
        arr[0][0] = 7;
        
        // 변경 후, 배열 요소 출력
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 5; ++j) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
```


