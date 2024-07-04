package chapter2_4.practice3;


// 아래 클래스의 코드는 채점에 영향을 줄 수 있습니다. 수정하지 마세요.
class Animal {
    public void speak() {
        System.out.println("이 동물은 어떤 소리를 낼까요?");
    }
}

class Dog extends Animal {
    @Override
    public void speak() {
        System.out.println("멍멍!");
    }
}

class Cat extends Animal {
    @Override
    public void speak() {
        System.out.println("야옹~");
    }
}

class Bird extends Animal {
    @Override
    public void speak() {
        System.out.println("짹짹!");
    }
}

public class Main {
    public static void main(String[] args) {
        // 지시 사항을 참고하여 코드를 작성해 보세요.
        Animal[] animals = {new Dog(),new Cat(), new Bird()};

        for (Animal animal : animals){
            animal.speak();
        }
    }
}
