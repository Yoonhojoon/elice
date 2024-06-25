package chapter1_2;

import java.util.Scanner;

public class LoanEligibilityRequirements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isAdult = scanner.nextBoolean();

        double monthlyIncome = scanner.nextDouble();

        int creditScore = scanner.nextInt();

        System.out.println("성인 여부: " + isAdult);
        System.out.println("월 수입이 기준치 이상인가요? " + (monthlyIncome >= 170));  // 가정하에 월 수입 기준치를 170으로 설정합니다.
        System.out.println("신용 점수가 기준치 이상인가요? " + (creditScore >= 650));  // 신용 점수 기준을 650으로 가정합니다.

        boolean isApproved = isAdult && (monthlyIncome >= 170) && (creditScore >= 650);  // 대출 조건을 기반으로 승인 여부를 계산합니다.
        System.out.println("대출 승인 가능 여부: " + isApproved);

    }
}
