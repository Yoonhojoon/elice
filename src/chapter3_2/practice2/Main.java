package chapter3_2.practice2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.nextLine();
        scanner.close();

        System.out.println(solution(first, second));
    }

    public static int solution(String first, String second) {
        String a = first.toLowerCase();
        String b = second.toLowerCase();

        if (a.contains(b) || b.contains(a)) {
            return 1;
        }
        return 0;
    }
}

