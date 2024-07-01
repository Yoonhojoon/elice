package chapter1_4;

import java.util.Scanner;
//깃 반영을 위한 주석
// 구구단 n단 출력하기
public class TimesTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        // 지시사항 1번을 참고하여 코드를 작성하세요.
        for(int i = 1; i <= 9; i++)
        {
            System.out.println(n * i);
        }

    }
}
