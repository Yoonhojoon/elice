package chapter3_2.practice3;

import java.util.ArrayList;
import java.util.Arrays;

public class Elice {

    public static int solution(int[] input, int target) {
        // 이곳에 코드를 작성해 주세요.
        Arrays.sort(input);
        return Arrays.binarySearch(input, target);
    }

    private Elice() {}
}
