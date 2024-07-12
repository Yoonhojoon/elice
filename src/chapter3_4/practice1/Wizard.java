package chapter3_4.practice1;



// 테스트를 위한 코드입니다. 수정하지 마세요.
interface RandomProvider {
    boolean nextBoolean();
}

public class Wizard {

    // 테스트를 위한 코드입니다. 수정하지 마세요.
    private RandomProvider randomProvider;

    public Wizard(RandomProvider randomProvider) {
        this.randomProvider = randomProvider;
    }

    public void castSpell() throws SpellException {
        boolean spellSuccess = this.randomProvider.nextBoolean();
        if (!spellSuccess) {
            // 지시 사항을 참고하여 코드를 작성해 보세요.
            throw new SpellException("🧙: 주문 실패! 다시 시도해야 한다.");
        }
        // 지시 사항을 참고하여 코드를 작성해 보세요.

        System.out.println("🧙: 주문 성공! 마법이 발동되었다.");
    }
}
