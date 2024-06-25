package chapter1_2;

import java.util.Scanner;

public class CircleCalculating {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 지시사항 1번을 참고하여 코드를 작성하세요.
        int radius = scanner.nextInt();

        // 지시사항 2번을 참고하여 코드를 작성하세요.
        double pi = 3.14;

        // 지시사항 3번을 참고하여 코드를 작성하세요.
        double area = radius * radius * pi;
        System.out.println("주어진 동그라미의 면적은 " + area + "m^2입니다.");
    }

}
