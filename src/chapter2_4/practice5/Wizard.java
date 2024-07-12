package chapter2_4.practice5;


// Wizard 클래스가 더 이상 상속되지 못하도록 코드를 수정해 주세요.
final class Wizard extends Character {
    // 상수 값인 MAX_MP 멤버 변수를 추가해 주세요.

    private int MP = 0;
    static final public int MAX_MP = 50;


    Wizard(String name) { super(name); }
    Wizard(String name, int AP) { super(name, AP); }
    Wizard(String name, String nickname) { super(name, nickname); }
    Wizard(String name, String nickname, int AP) { super(name, nickname, AP); }

    public int getMP() { return MP; }
    // MP가 MAX_MP보다 커지지 않도록 setMP 메서드를 수정해 주세요.
    public void setMP(int MP) {
        if(MP < 0) MP = 0;
        this.MP = MP;

        // 매개변수로 전달된 값이 MAX_MP 값 보다 클경우,
        if (MP > this.MAX_MP){
            this.MP = this.MAX_MP;
        }

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
