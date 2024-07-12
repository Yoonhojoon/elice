package chapter3_1.practice4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalNumber = sc.nextInt();
        List<Integer> heightList = new ArrayList<>();

        for (int i = 0; i < totalNumber; i++) {
            heightList.add(sc.nextInt());
        }

        Solution.solution(heightList.listIterator());
    }
}