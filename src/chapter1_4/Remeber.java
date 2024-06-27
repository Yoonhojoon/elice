package chapter1_4;

import java.util.Scanner;

// 암기하기
public class Remeber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 지시사항 1번을 참고하여 코드를 작성하세요.
        // 단어(word)를 입력받습니다.
        String word = scanner.next();

        // 지시사항 2, 3번을 참고하여 코드를 작성하세요.
        // 입력한 단어의 출력을 10번 반복하도록 for문을 작성합니다.

        for (int i = 0; i < 10;i++){
            //반복문
            //내에 단어를 출력하는 출력문을 작성합니다.
            //한 줄에 하나의 단어가 출력되도록 출력문을 작성해야 합니다.
            System.out.println(word);
        }
    }
}
