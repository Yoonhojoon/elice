package chapter2_2;

// this 와 this() 차이

class CafeThis {
    public String menu;
    public int price;

    CafeThis(String menu) {
        this(menu, 3000);
    }

    CafeThis(String menu, int price) {
        this.menu = menu;
        this.price = price;
    }

    public void printMenuInfo() {
        System.out.println(menu + "은 " + price + "원입니다.");
    }
}

public class ThisAndThis {
    // main 메서드 부분은 수정하지 말아주세요! 채점이 정상적으로 진행되지 않을 수 있습니다.
    public static void main(String[] args) {

        CafeThis cafe = new CafeThis("아이스크림");
        CafeThis cafe2 = new CafeThis("아이스크림", 3000);

        cafe.printMenuInfo();
        cafe2.printMenuInfo();
    }
}