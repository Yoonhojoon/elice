package chapter2_5.practice6;


// Archer 클래스는 SkillUsable 인터페이스를 구현해야 합니다.
final class Archer extends Character implements SkillUsable {
    private int arrowNum = 10;

    Archer(String name) { super(name); }
    Archer(String name, int AP) { super(name, AP); }
    Archer(String name, String nickname) { super(name, nickname); }
    Archer(String name, String nickname, int AP) { super(name, nickname, AP); }

    public int getArrowNum() { return arrowNum; }
    public void setArrowNum(int arrowNum) {
        if(arrowNum < 0) arrowNum = 0;
        this.arrowNum = arrowNum;
    }

    public void attack(Character target) {
        if(arrowNum == 0) {
            System.out.println(super.getName() + "의 화살 개수가 부족하여 공격하지 못했습니다.");
            return;
        }

        super.attack(target);
        setArrowNum(arrowNum - 1);
        System.out.println(super.getName() + "의 화살이 " + arrowNum + "만큼 남아있습니다.");
    }

    public void printSkill(Character target) {
        String skillName = "조준 사격";

        System.out.println(super.getName() + "은(는) " + target.getName() + "에게 궁수 스킬 [" + skillName + "]을 사용했습니다!");
        System.out.println("[효과: 추가로 30만큼 데미지, 단 화살 두 개 사용]");
    }

    public void useSkill(Character target) {
        target.setHP(target.getHP() - super.getAP() - 30);
        setArrowNum(arrowNum - 2);
        printSkill(target);
    }

    public String toString() {
        String result = "";

        result += "<궁수>\n";
        result += super.toString();

        return result;
    }
}