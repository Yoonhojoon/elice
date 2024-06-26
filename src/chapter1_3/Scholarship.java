package chapter1_3;

import java.util.Scanner;

public class Scholarship {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int grade = input.nextInt();//성적을 입력받는 변수 grade
        // 지시사항 1번을 참고하여 코드를 작성하세요.
        if(grade >= 70){
            System.out.println("합격입니다.");
            // 지시사항 2번을 참고하여 코드를 작성하세요.
            if(grade >= 90){
                System.out.println("장학금도 받을 수 있습니다.");
            }
        }
        // 지시사항 3번을 참고하여 코드를 작성하세요.
        else{
            System.out.println("불합격입니다.");
        }
    }
}
