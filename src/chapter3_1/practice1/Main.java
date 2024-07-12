package chapter3_1.practice1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 카드 셔플

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 첫 번째 줄부터 각 줄에 1이상, 20 이하의 정수가 하나씩 입력이 된다.
        List<Integer> deck = new ArrayList<Integer>();

        for (int i = 1; i <= 20; i++) {
            deck.add(i);
        }

        //입력된 정수를 N이라고 할 때, 아래에서부터 N번째 카드를 뽑아 덱의 가장 위로 올린다.
        int input;
        while ((input = sc.nextInt()) != -1) {
            Integer card = deck.remove(input - 1);
            deck.add(card);
        }

        System.out.println(deck);


    }
}

