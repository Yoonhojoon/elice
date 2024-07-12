package chapter3_1.practice4;

import java.util.ListIterator;

class Solution {

    public static void solution(ListIterator<Integer> iterator) {
        int prev = 0;
        int count = 0;

        while (iterator.hasNext()) {
            int cur = iterator.next();
            if (prev < cur) {
                count++;
            }
            prev = cur;
        }

        System.out.println(count);
    }

    private Solution() {}
}

