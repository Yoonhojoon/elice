package chapter2_5.practice6;


// Wizard 클래스는 SkillUsable 인터페이스를 구현해야 합니다.
final class Wizard extends Character implements SkillUsable {
    static final public int MAX_MP = 50;

    private int MP = 0;

    private Magic normalMagic = new Magic("일반", 1);
    private Magic skillMagic = new Magic("최면", 20);

    Wizard(String name) { super(name); }
    Wizard(String name, int AP) { super(name, AP); }
    Wizard(String name, String nickname) { super(name, nickname); }
    Wizard(String name, String nickname, int AP) { super(name, nickname, AP); }

    public class Magic {
        private String name;
        private int requiredMP;

        private Magic(String name, int requiredMP) {
            this.name = name;
            this.requiredMP = requiredMP;
        }

        private boolean canUseMagic() { return MP >= requiredMP; }
    }

    public int getMP() { return MP; }
    public void setMP(int MP) {
        if(MP < 0) MP = 0;
        else if(MP > MAX_MP) MP = MAX_MP;
        this.MP = MP;
    }

    public void attack(Character target) {
        super.attack(target);

        if(!normalMagic.canUseMagic()) {
            System.out.println(super.getName() + "의 MP가 모자라 마법 공격을 할 수 없습니다.");
            return;
        }
        target.setHP(target.getHP() - MP);
        System.out.println(super.getName() + "이(가) " + target.getName() + "을(를) 마법의 힘으로 " + MP + "만큼 추가 데미지를 입혔습니다!");
    }

    public void printSkill(Character target) {
        System.out.println(super.getName() + "은(는) " + target.getName() + "에게 마법사 스킬 [" + skillMagic.name + "]을 사용했습니다!");
        System.out.println("[효과: 상대의 공격력을 반으로 줄임]");
    }

    public void useSkill(Character target) {
        if(!skillMagic.canUseMagic()) {
            System.out.println(super.getName() + "의 MP가 모자라 마법 공격을 할 수 없습니다.");
            return;
        }
        target.setAP(target.getAP() / 2);
        printSkill(target);
    }

    public String toString() {
        String result = "";

        result += "<마법사>\n";
        result += super.toString();

        return result;
    }
}