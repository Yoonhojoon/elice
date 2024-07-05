package chapter2_5.practice3;

public class Potion extends Item {
    private int amount;
    private String type;

    public Potion(String name, String description, int amount, String type) {
        super(name, description);
        this.amount = amount;
        this.type = type;
    }

    public void use(Character character) {
        if (type.equals("HP")) {
            character.setHP(character.getHP() + amount);
        } else if (type.equals("AP")) {
            character.setAP(character.getAP() + amount);
        }
    }
}