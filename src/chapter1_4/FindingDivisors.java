package chapter1_4;

import java.util.Scanner;

//약수 구하기

public class FindingDivisors {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        // 지시사항을 참고하여 코드를 작성하세요.
        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                System.out.println(i);
            }
        }





    }
}
