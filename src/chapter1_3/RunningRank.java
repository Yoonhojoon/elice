package chapter1_3;

import java.util.Scanner;
// 달리기 등 수

public class RunningRank {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("달리기 등 수를 입력하세요.");
        int rank = input.nextInt();
        switch(rank){
            // 지시사항 1번을 참고하여 코드를 작성하세요.
            case 1 :
                System.out.println("금메달 입니다!");
                break;

            // 지시사항 2번을 참고하여 코드를 작성하세요.
            case 2 :
                System.out.println("은메달 입니다!");
                break;

            // 지시사항 3번을 참고하여 코드를 작성하세요.
            case 3 :
                System.out.println("동메달 입니다!");
                break;

            // 지시사항 4번을 참고하여 코드를 작성하세요.
            default :
                System.out.println("완주하였습니다!");
                break;
        }
    }
}
