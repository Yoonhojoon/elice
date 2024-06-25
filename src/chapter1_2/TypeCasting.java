package chapter1_2;

/*
* 자료형 변환
* */

public class TypeCasting {
    public static void main(String[] args) {

        // 정수형 자료를 실수형으로 변환
        int height = 20;
        double weight;
        weight = height;

        System.out.println(weight);

        // 실수형 자료를 정수형으로 변환
        weight = 33.5;
        height = 0;

        // 지시사항 1번을 참고하여 코드를 작성하세요.
        height = (int)weight;
        System.out.println(height);
    }
}
