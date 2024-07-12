package chapter2_5.practice1;


class Wizard extends Character {
    private int MP = 0;

    Wizard(String name) { super(name); }
    Wizard(String name, int AP) { super(name, AP); }
    Wizard(String name, String nickname) { super(name, nickname); }
    Wizard(String name, String nickname, int AP) { super(name, nickname, AP); }

    public int getMP() { return MP; }
    public void setMP(int MP) {
        if(MP < 0) MP = 0;
        this.MP = MP;
    }

    public void attack(Character target) {
        super.attack(target);

        if(MP == 0) {
            System.out.println(super.getName() + "의 MP가 모자라 마법 공격을 할 수 없습니다.");
            return;
        }
        target.setHP(target.getHP() - MP);
        System.out.println(super.getName() + "이(가) " + target.getName() + "을(를) 마법의 힘으로 " + MP + "만큼 추가 데미지를 입혔습니다!");
    }

    private void printSkill(Character target) {
        String skillName = "최면";

        System.out.println(super.getName() + "은(는) " + target.getName() + "에게 마법사 스킬 [" + skillName + "]을 사용했습니다!");
        System.out.println("[효과: 상대의 공격력을 반으로 줄임]");
    }

    // printSkill 메서드를 활용하여 useSkill 추상 메서드를 구현하세요.
    public void useSkill(Character target) {
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
