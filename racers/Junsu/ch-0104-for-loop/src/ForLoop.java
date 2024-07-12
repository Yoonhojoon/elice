public class ForLoop {
    public static void main(String[] args) {
        //초기화, 조건, 증감연산자
//        for(int i = 0 ; i<= 100 ; i++){
//            System.out.println(i);
//        }
        //구구단
        for (int i = 2; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
//                System.out.println(i * j);
//                System.out.printf("%d * %d = %d\n",i,j,i*j);
                //jdk 21 preview 기능 스트링포맷 지원, 파이썬 자바스크립트
                //후에 어떻게 기능이 추가될지 모르는 기능
//                System.out.println(STR."\{i} 곱하기 \{j} = \{i*j}");
                System.out.println(STR."\{i} * \{j} = \{i*j}");
            }
        }
    }
}
