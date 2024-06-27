package chapter1_4;

// 평균은 넘겠지
public class CountAverage {
    public static void main(String[] args) {
        int[] grades = new int[] {100, 90, 70, 85, 60, 100, 90, 85, 75, 50, 65, 95, 90, 100, 75, 100, 70, 90, 95, 75};

        // 아래에 몇 명만이 평균을 넘었는지 계산해 출력해 봅시다.
        int sum = 0;
        int average;
        // 지시사항 1번을 참고하여 코드를 작성하세요.

        for (int grade:grades){
            sum += grade;
        }

        // 지시사항 2번을 참고하여 코드를 작성하세요.
        average = sum / grades.length;

        // 지시사항 3번을 참고하여 코드를 작성하세요.

        int count=0;
        for (int grade:grades){
            if (grade > average){
                count++;
            }
        }

        // 지시사항 4번을 참고하여 코드를 작성하세요.

        System.out.println(count);




    }
}
