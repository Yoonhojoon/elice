package chapter1_3;

import java.util.Scanner;

public class CalculateGrade {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int grade = input.nextInt();
        // 지시사항 1번을 참고하여 코드를 작성하세요.
        if(90 <= grade){
            System.out.println("학점은 A입니다.");
        }
        // 지시사항 2번을 참고하여 코드를 작성하세요.
        else if(grade >= 80){
            System.out.println("학점은 B입니다.");
        }
        // 지시사항 3번을 참고하여 코드를 작성하세요.
        else if(grade >= 70){
            System.out.println("학점은 C입니다.");
        }
        // 지시사항 4번을 참고하여 코드를 작성하세요.
        else if(grade >= 60){
            System.out.println("학점은 D입니다.");
        }
        // 지시사항 5번을 참고하여 코드를 작성하세요.
        else{
            System.out.println("학점은 F입니다.");
        }

    }
}
