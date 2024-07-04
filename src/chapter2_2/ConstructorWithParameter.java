package chapter2_2;

//생성자로 멤버 변수 초기화

class Cafe {
    // 멤버 변수 선언 부분은 수정하지 말아주세요! 채점이 정상적으로 진행되지 않을 수 있습니다.
    private String menu;
    private int price;

    // 여기에 생성자 메서드를 작성해주세요.
    Cafe(String menu, int price) {
        this.menu = menu;
        this.price = price;
    }

    public void printMenuInfo() {
        System.out.println(this.menu + "는 " + this.price + "원입니다.");
    }
}

public class ConstructorWithParameter {
    public static void main(String[] args) {

        // 여기를 수정해주세요.
        Cafe cafe = new Cafe("카페라떼", 4000);

        cafe.printMenuInfo();
    }
}
