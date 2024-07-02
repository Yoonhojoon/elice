package chapter2_1;

class Order {

    public String menu;
    public int price;

    public void printOrderInfo() {
        System.out.println("주문한 메뉴는 " + menu + ", 가격은 " + price + "원입니다.");
    }
}
public class OrderMenu {
    public static void main(String[] args) {
        Order order = new Order();

        order.menu = "아메리카노";
        order.price = 4000;

        order.printOrderInfo();
    }
}
