package chapter1_3;

import java.util.Scanner;

// 수 비교하기
public class CompareNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        if(a > b)   System.out.println("A가 더 큽니다.");
        else if(a < b)  System.out.println("B가 더 큽니다.");
        else    System.out.println("크기가 같습니다.");

        scanner.close();
    }
}
