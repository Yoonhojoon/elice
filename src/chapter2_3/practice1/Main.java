package chapter2_3.practice1;

// 여기에 Animal 클래스와 Mammal클래스를 선언하세요.
class Animal{
    String name;
    int age;

    public Animal(String name, int age){
        this.name = name;
        this.age =age;

    }

    public void printDetails(){
        System.out.println("이름 : "+ this.name);
        System.out.println("나이 : "+ this.age);
    }
}

class Mammal extends Animal{
    String furColor;

    public Mammal(String name,int age,String furColor){
        super(name,age);
        this.furColor = furColor;
    }

    public void printDetails(){
        super.printDetails();
        System.out.println("털 색깔 : "+this.furColor);
    }

}


public class Main {
    public static void main(String args[]) {
        Animal animal = new Animal("Tiger", 5);
        Mammal mammal = new Mammal("Panda", 3, "Black and White");

        animal.printDetails();
        mammal.printDetails();
    }
}
