package chapter1_2;

import java.util.Scanner;

public class AvgCalculating {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 지시사항 1번을 참고하여 코드를 작성하세요.
        int korean = scanner.nextInt();
        int english = scanner.nextInt();
        int math = scanner.nextInt();
        int history = scanner.nextInt();

        // 지시사항 2번을 참고하여 코드를 작성하세요.
        int avg1 = (korean + english + math + history) / 4;
        // 지시사항 3번을 참고하여 코드를 작성하세요.
        double avg2 = (double)(korean + english + math + history) / 4;

        // 지시사항 4번을 참고하여 코드를 작성하세요.
        System.out.println(avg1);
        System.out.println(avg2);
    }
}
