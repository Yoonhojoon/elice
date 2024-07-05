package chapter2_5.practice4;

// PowerControl 인터페이스를 선언합니다.
interface PowerControl{
    String turnOn();
    String turnOff();
}
// Tv, Computer, Ac 클래스를 구현합니다.

class Tv implements PowerControl{
    public String turnOn(){
        return "티비를 켭니다.";
    }

    public String turnOff(){
        return "티비를 끕니다.";
    }
}

class Computer implements PowerControl{
    public String turnOn(){
        return "컴퓨터를 켭니다.";
    }

    public String turnOff() {
        return "컴퓨터를 끕니다.";
    }
}

class Ac implements PowerControl{
    public String turnOn(){
        return "에어컨을 켭니다.";
    }

    public String turnOff(){
        return "에어컨을 끕니다.";
    }
}





// Main 부분은 수정하지 말아주세요! 채점이 정상적으로 진행되지 않을 수 있습니다.
public class Main {
    public static void main(String args[]) {

        Tv tv = new Tv();
        Computer computer = new Computer();
        Ac ac = new Ac();

        System.out.println(tv.turnOn());
        System.out.println(tv.turnOff());
        System.out.println(computer.turnOn());
        System.out.println(computer.turnOff());
        System.out.println(ac.turnOn());
        System.out.println(ac.turnOff());

    }
}

