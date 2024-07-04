package chapter2_4.practice2;


public class Coffee {
    int price;

    public Coffee(int price) {
        this.price = price;
    }
}

// 아메리카노 클래스
class Americano extends Coffee {
    public Americano() {
        super(4000);
    }

    public String toString() {return "아메리카노";};
};

// 카페라떼 클래스
class CaffeLatte extends Coffee {
    public CaffeLatte() {
        super(5000);
    }

    public String toString() {return "카페라떼";};
};
