package chapter2_5.practice6;


import java.util.ArrayList;

// 여기에 Attackable 인터페이스를 작성해 주세요.
interface Attackable {
    void attack(Character target);
}

// 여기에 ItemUsable 인터페이스를 작성해 주세요.
interface ItemUsable {
    void addItem(Item item);
    void giveItem(Character receiver, Item item);
    void useItem(Item item);
}

// 여기에 SkillUsable 인터페이스를 작성해 주세요.
interface SkillUsable {
    void printSkill(Character target);
    void useSkill(Character target);
}

// Character 클래스를 추상 클래스가 아닌 일반 클래스로 변경해 주세요.
// 또한 Character 클래스는 Attackable, ItemUsable 인터페이스를 구현해야 합니다.
public class Character implements Attackable, ItemUsable {
    static final public int MAX_HP = 100;

    private String name;
    private String nickname;
    private int HP;
    private int AP;
    private ArrayList<Item> inventory = new ArrayList<Item>();

    static private int characterNum = 0;

    private void addCharacterNum() {
        characterNum++;
        System.out.println("캐릭터가 한 명 추가되었습니다.");
    }

    static public int getCharacterNum() { return characterNum; }

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
        this.HP = MAX_HP;
        this.AP = AP;
        addCharacterNum();
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
        else if(HP > MAX_HP) HP = MAX_HP;
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
        for(Item item: inventory) result += item.getName() + " ";
        result += "\n====================\n";

        return result;
    }

    public void attack(Character target) {
        target.setHP(target.getHP() - AP);
        System.out.println(name + "이(가) " + target.getName() + "을(를) 일반 공격으로 " + AP + "만큼 데미지를 입혔습니다!");
    }

    // 추상 메서드인 useSkill 메서드를 지워주세요.

    public void addItem(Item item) {
        inventory.add(item);
        System.out.println(name + "이(가) " + item.getName() + " 아이템을 얻었습니다!");
    }

    public void giveItem(Character receiver, Item item) {
        inventory.remove(item);
        receiver.addItem(item);
        System.out.println(name + "이(가) " + receiver.getName() + "에게 " + item.getName() + " 아이템을 주었습니다!");
    }

    public void useItem(Item item) {
        item.use(this);
        inventory.remove(inventory.indexOf(item));
        System.out.println(name + "이(가) " + item.getName() + " 아이템을 사용했습니다!");
    }
}