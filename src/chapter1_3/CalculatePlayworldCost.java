package chapter1_3;

import java.util.Scanner;

//놀이공원 입장료 계산하기
public class CalculatePlayworldCost {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int age = scan.nextInt(); // 손님에게 나이를 물어봅니다.
        int price = 0;

        // 지시사항 1번을 참고하여 코드를 작성하세요.
        if(0 <= age && age <= 7 )
        {
            price = 0;
        }
        else if(8 <= age && age <= 13)
        {
            price = 5000;
        }
        else if(14 <= age && age <= 19)
        {
            price = 10000;
        }
        else if(20 <= age)
        {
            price = 20000;
        }

        System.out.println("고객님, 입장료는 " + price + "원이 되겠습니다.");
    }
}
