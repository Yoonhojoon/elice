package chapter2_5.practice1;


public class Main {
    public static void main(String args[]) {
        Warrior warrior = new Warrior("캐터필러", "Caterpillar", 30);
        Archer archer = new Archer("체셔", "Cheshire", 40);
        Wizard wizard = new Wizard("도도새", "Dodo", 20);

        System.out.println(warrior);
        System.out.println(archer);
        System.out.println(wizard);

        warrior.useSkill(archer);
        System.out.println(archer);

        archer.useSkill(wizard);
        System.out.println("남은 화살 개수: " + archer.getArrowNum());
        System.out.println(wizard);

        wizard.useSkill(warrior);
        System.out.println(warrior);
    }
}