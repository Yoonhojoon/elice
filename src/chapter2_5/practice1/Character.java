package chapter2_5.practice1;


import java.util.ArrayList;

// Character 클래스를 추상 클래스로 수정해 주세요.
abstract public class Character {
    private String name;
    private String nickname;
    private int HP;
    private int AP;
    private ArrayList<String> inventory = new ArrayList<String>();

    // 생성자 메서드
    public Character(String name) {
        this(name, "별명 없음", 10);
    }

    public Character(String name, int AP) {
        this(name, "별명 없음", AP);
    }

    public Character(String name, String nickname) {
        this(name, nickname, 10);
    }

    public Character(String name, String nickname, int AP) {
        this.name = name;
        this.nickname = nickname;
        this.HP = 100;
        this.AP = AP;
    }

    // getter 메서드
    public String getName() { return name; }
    public String getNickname() { return nickname; }
    public int getHP() { return HP; }
    public int getAP() { return AP; }

    // setter 메서드
    public void setName(String name) { this.name = name; }
    public void setNickName(String nickname) { this.nickname = nickname; }

    public void setHP(int HP) {
        if(HP < 0) HP = 0;
        this.HP = HP;
    }

    public void setAP(int AP) {
        if(AP < 0) AP = 0;
        this.AP = AP;
    }

    // 일반 메서드
    public String toString() {
        String result = "";

        result += "====================\n";
        result += "이름: " + name + "\n";
        result += "별명: " + nickname + "\n";
        result += "체력: " + HP + "\n";
        result += "공격력: " + AP + "\n";
        result += "인벤토리: ";
        for(String item: inventory) result += item + " ";
        result += "\n====================\n";

        return result;
    }

    public void attack(Character target) {
        target.setHP(target.getHP() - AP);
        System.out.println(name + "이(가) " + target.getName() + "을(를) 일반 공격으로 " + AP + "만큼 데미지를 입혔습니다!");
    }

    // 여기에 useSkill 추상 메서드를 추가해 주세요.
    abstract public void useSkill(Character target);

    public void addItem(String item) {
        inventory.add(item);
        System.out.println(name + "이(가) " + item + " 아이템을 얻었습니다!");
    }

    public void giveItem(Character receiver, String item) {
        inventory.remove(item);
        receiver.addItem(item);
        System.out.println(name + "이(가) " + receiver.getName() + "에게 " + item + " 아이템을 주었습니다!");
    }

    public void useItem(String item) {
        inventory.remove(inventory.indexOf(item));
        System.out.println(name + "이(가) " + item + " 아이템을 사용했습니다!");
    }
}