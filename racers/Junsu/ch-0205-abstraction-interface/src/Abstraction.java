public class Abstraction {
    public static void main(String[] args) {
        // 추상메서드를 오버라이딩 하여 인스턴스화 시켰음
       Animal anm = new Animal() {
           @Override
           public void eat() {
               System.out.println("동물");
           }
       };

//       Dog dg = new Animal();

        anm.eat();
        Dog dg = new Dog();
        dg.eat();

        Programmer worker = new Programmer();
        worker.sayJob();

    }
}

//public abstract class Animal{
abstract class Animal{
    public abstract void eat();
//    추상메소드 논리로직 구현불가
//    public abstract void eat(){
//
//    }
}

//public abstract Dog extends Animal
class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("Dog is eating");
    }
}

abstract class Person{
    protected String name;
    protected int age;

    abstract void sayJob();

}

//class Programmer extends Person{
//    boolean isTried = true;
//
//    void sayJob(){
//        System.out.println("저는 프로그래머입니다.");
//    }
//}