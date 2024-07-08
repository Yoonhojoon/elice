package chapter3_1.practice5;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList<Integer> list = new LinkedList<>();

        int input1, input2;
        while ((input1 = sc.nextInt()) >= 0) {
            if (input1 == 0) {
                input2 = sc.nextInt();
                list.add(input2);
            } else if (input1 == 1) {
                input2 = sc.nextInt();
                list.addFirst(input2);
            } else {
                list.poll();
            }
        }

        while (!list.isEmpty()) {
            System.out.print(list.poll() + " ");
        }
    }
}
