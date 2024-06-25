package chapter1_2;
import java.util.Scanner;

public class HelthCheck {
    public static void main(String args[]) {

        //지시사항 1번을 참고하여 코드를 작성하세요.
        Scanner scanner = new Scanner(System.in);

        //지시사항 2번을 참고하여 코드를 작성하세요.
        String name = scanner.nextLine();

        //지시사항 3번을 참고하여 코드를 작성하세요.
        int age = scanner.nextInt();

        //지시사항 4번을 참고하여 코드를 작성하세요.
        double height = scanner.nextDouble();

        //지시사항 4번을 참고하여 코드를 작성하세요.
        double weight = scanner.nextDouble();

        //지시사항 5번을 참고하여 코드를 작성하세요.
        System.out.println("이름: " + name + "님");
        System.out.println("나이: " + age + "세");
        System.out.println("키: " + height + "cm");
        System.out.print("몸무게: " + weight + "kg");

    }
}
