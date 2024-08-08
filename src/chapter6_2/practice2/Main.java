package chapter6_2.practice2;

public class Main {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService(paymentService);

        orderService.createOrder();
    }
}