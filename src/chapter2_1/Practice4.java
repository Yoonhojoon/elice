package chapter2_1;

class Character {
    public String name;
    public String nickname;
    public int HP = 100;
    public int AP = 0;
    public String[] inventory = {"물약", "칼", "갑옷"};
}

public class Practice4 {
    public static void main(String[] args) {
        Character ch = new Character();

        ch.name = "Elice";
        ch.nickname = "Hellobit";

        System.out.println("ch.name: " + ch.name);
        System.out.println("ch.nickname: " + ch.nickname);
        System.out.println("ch.HP: " + ch.HP);
        System.out.println("ch.AP: " + ch.AP);
        for (int i = 0; i < ch.inventory.length; i++)
            System.out.print(ch.inventory[i] + ", ");
    }
}
