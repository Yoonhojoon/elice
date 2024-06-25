package chapter1_2;

import java.util.Scanner;
import java.time.LocalDate;

public class YourAgeThisYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 사용자로부터 태어난 연도를 정수형으로 입력받습니다.
        int myBirthYear = scanner.nextInt();

        // 현재 년도를 나타내는 변수를 선언하고, 값을 할당합니다.
        int currentYear = LocalDate.now().getYear();

        // 사용자의 현재 나이를 계산합니다.
        int myAge = currentYear - myBirthYear;

        // 올해의 나이를 출력합니다.
        System.out.println("올해 당신의 나이는 " + myAge + "살 입니다.");
    }
}
