package chapter3_4.practice4;


public class Order {
    private static final int MAX_CHEESE_ALLOWED = 1000;

    // 지시 사항을 참고하여 코드를 작성해 보세요.
    public void orderCheesePizza(int requestedCheeseAmount) throws ExcessiveCheeseException{
        if (requestedCheeseAmount > MAX_CHEESE_ALLOWED){
            throw new ExcessiveCheeseException("주문 가능한 치즈의 양을 초과하였습니다.",MAX_CHEESE_ALLOWED, requestedCheeseAmount);
        }
        System.out.println("치즈 피자 주문이 성공적으로 완료되었습니다.");
    }

}
