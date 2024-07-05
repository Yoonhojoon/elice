package chapter2_5.practice3;


abstract public class Item {
    private String name;
    private String description;

    Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() { return name; }

    abstract public void use(Character character);

    public String toString() {
        String result = "";

        result += "====================\n";
        result += "아이템 설명\n";
        result += "이름: " + name + "\n";
        result += "설명: " + description + "\n";
        result += "====================\n";

        return result;
    }
}