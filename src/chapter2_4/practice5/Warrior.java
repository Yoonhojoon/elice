package chapter2_4.practice5;

// Warrior 클래스가 더 이상 상속되지 못하도록 코드를 수정해 주세요.
final class Warrior extends Character {
    Warrior(String name) { super(name); }
    Warrior(String name, int AP) { super(name, AP); }
    Warrior(String name, String nickname) { super(name, nickname); }
    Warrior(String name, String nickname, int AP) { super(name, nickname, AP); }

    private void printSkill(Character target) {
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
