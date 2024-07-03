package chapter2_3.practice3;


public class Main {
    public static void main(String args[]) {
        Character ch = new Character("헬로빗", "Hellobit", 30);

        // public
        ch.printDashboard();
        // protected
        System.out.println(ch.isInventoryEmpty());
        // (default)
        ch.increaseStat();
        // private
        // System.out.println(ch.name);
    }
}