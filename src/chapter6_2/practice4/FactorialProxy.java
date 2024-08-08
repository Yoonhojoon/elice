package chapter6_2.practice4;

/*
*
*
public class FactorialProxy implements Factorial{

    private Factorial delegator;

    public FactorialProxy(Factorial delegator){
        this.delegator = delegator;
    }


    @Override
    public void factorial(long n) {
        long startTime = System.nanoTime();
        delegator.factorial(n);
        long endTime = System.nanoTime();
        System.out.printf("호출 클래스: %s\n", delegator.getClass().getSimpleName());
        System.out.printf("실행 시간: %dns\n", (endTime - startTime));
        System.out.println("---------------------------------------");
    }
}
*
*/


/*

public class FactorialTest {
    public static void main(String[] args) {

        // 지시사항을 참고하여 코드를 작성해 보세요.
        FactorialProxy factorialProxy = new FactorialProxy(new FactorialWithFor());
        factorialProxy.factorial(20);

        FactorialWithRecursion factorialWithRecursion = new FactorialWithRecursion();
        FactorialProxy factorialProxy2 = new FactorialProxy(factorialWithRecursion);

        factorialProxy2.factorial(20);
    }
}

*/