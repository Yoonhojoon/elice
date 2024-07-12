package chapter2_4.practice5;


// final 클래스를 상속하려고 하면 오류가 발생합니다. 아래 코드의 주석을 풀어 확인해 봅시다.
// class Test1 extends Warrior {}
// class Test2 extends Archer {}
// class Test3 extends Wizard {}

public class Main {
    public static void main(String args[]) {
        Wizard wizard = new Wizard("캐터필러", "Caterpillar", 30);

        wizard.setHP(150);
        System.out.println("HP: " + wizard.getHP());
        wizard.setMP(75);
        System.out.println("MP: " + wizard.getMP());

        // final 멤버 변수를 변경할 수 없습니다. 아래 코드의 주석을 풀어 확인해 봅시다.
        // Wizard.MAX_MP = 30;
    }
}