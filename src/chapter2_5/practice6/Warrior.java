package chapter2_5.practice6;


// Warrior 클래스는 SkillUsable 인터페이스를 구현해야 합니다.
final class Warrior extends Character implements SkillUsable {
    Warrior(String name) { super(name); }
    Warrior(String name, int AP) { super(name, AP); }
    Warrior(String name, String nickname) { super(name, nickname); }
    Warrior(String name, String nickname, int AP) { super(name, nickname, AP); }

    public void printSkill(Character target) {
        String skillName = "강타";

        System.out.println(super.getName() + "은(는) " + target.getName() + "에게 용사 스킬 [" + skillName + "]를 사용했습니다!");
        System.out.println("[효과: 공격력의 두 배의 데미지]");
    }

    public void useSkill(Character target) {
        target.setHP(target.getHP() - (super.getAP() * 2));
        printSkill(target);
    }

    public String toString() {
        String result = "";

        result += "<용사>\n";
        result += super.toString();

        return result;
    }
}