import javax.swing.*;

public class Test {
    public static void main(String[] args) {

    }
}


class Wizard extends absCharacter{
    @Override
    public void fireBolt() {

    }
    @Override
    public void Attack() {

    }
    @Override
    public void Item() {

    }
}

abstract class absCharacter implements SkillUseable, AttackUseable, ItemUseable{
//    @Override
//    public void fireBolt() {
//
//    }
//    @Override
//    public void Attack() {
//
//    }
//    @Override
//    public void Item() {
//
//    }
}

interface SkillUseable{
    public void fireBolt();
}
interface AttackUseable{
    public void Attack();
}
interface ItemUseable{
    public void Item();
}


class Warrior extends Character implements SkillUseable {
    @Override
    public void fireBolt() {

    }
}

class Character implements AttackUseable, ItemUseable{
    @Override
    public void Attack() {

    }
    @Override
    public void Item() {

    }
}