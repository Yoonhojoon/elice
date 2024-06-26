package chapter1_3;


import java.util.Scanner;

// 커피 자판기 만들기
public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("메뉴 번호를 입력해 주세요.");
        int n = scan.nextInt(); //메뉴 번호를 입력 받습니다.
        // 지시사항 1번을 참고하여 코드를 작성하세요.
        if(n == 1){
            System.out.println("아메리카노를 선택하셨습니다.");
        }
        else if(n == 2){
            System.out.println("카페라떼를 선택하셨습니다.");
        }
        else if(n == 3){
            System.out.println("카푸치노를 선택하셨습니다.");
        }
        else if(n == 4){
            System.out.println("프라푸치노를 선택하셨습니다.");
        }
        // 지시사항 2번을 참고하여 코드를 작성하세요.
        else{
            System.out.println("다른 번호를 입력해 주세요.");
        }
        // 지시사항 3번을 참고하여 코드를 작성하세요.
        System.out.println("이용해주셔서 감사합니다.");
    }
}
