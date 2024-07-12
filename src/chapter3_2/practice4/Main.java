package chapter3_2.practice4;

import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        // main 메소드의 내용은 실행 / 채점을 위한 코드이므로 수정하지 말아주세요.
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.nextLine();
        scanner.close();

        System.out.println(solution(first, second));
    }

    public static BigInteger solution(String first, String second) {
        // 여기에 코드 작성
        BigInteger firstInt = new BigInteger(first);
        BigInteger secondInt = new BigInteger(second);

        return firstInt.multiply(secondInt);

    }
}

