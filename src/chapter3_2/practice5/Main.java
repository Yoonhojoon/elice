package chapter3_2.practice5;

import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 이곳에 답안 코드를 작성해 주세요.

        // 시계를 N분 빨리 가도록 조정하는 로직
        // N과 조정한 시간이 주어졌을 때,
        // 엘리스 집에 있는 시계가 가리키는 시각
        // 현재시간 - N분

        // 1. 첫번째 줄, 자연수 N이 입력
        Scanner sc = new Scanner(System.in);
        int nMinutes = sc.nextInt();

        // 2. 두번째 줄에 자연수 세 개가 공백을 기준으로 입력. (시,분,초)

        int hour = sc.nextInt();
        int minute = sc.nextInt();
        int second = sc.nextInt();

        LocalTime localTime = LocalTime.of(hour, minute, second);
        System.out.println(localTime.plusMinutes(nMinutes));

    }
}
