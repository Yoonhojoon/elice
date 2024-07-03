package chapter2_3.practice3;



public class Other {
    public static void main(String[] args) {
        // public class, constructor
        Character ch = new Character("캐터필러", "Caterpillar", 50);

        // public
        ch.printDashboard();
        // protected
        // System.out.println(ch.isInventoryEmpty());
        // (default)
        // ch.increaseStat();
        // private
        // System.out.println(ch.name);
    }
}