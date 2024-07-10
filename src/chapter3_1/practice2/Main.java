package chapter3_1.practice2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// 팀장님

public class Main {
    public static void main(String[] args) {
        // 이곳에 답안 코드를 작성해 주세요.

        Scanner sc = new Scanner(System.in);
        // set 선언
        Set<String> set = new HashSet<>();

        int numberOfInstruction = sc.nextInt();

        // 첫번째 인자로 받은 만큼 for문 돌리기
        for (int i = 0; i < numberOfInstruction; i++) {
            set.add(sc.next());
        }

        // set의 사이즈 출력하기
        System.out.println(set.size());
    }
}
