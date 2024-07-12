package chapter2_5.practice5;


interface PowerControl {
    String turnOn();
    String turnOff();
}

// VolumeControl 인터페이스를 작성합니다.
interface VolumeControl {
    String volumeUp();
    String volumeDown();
}

// Tv, Computer, Radio 클래스에 VolumeControl 인터페이스를 구현합니다.
class Tv implements PowerControl, VolumeControl {
    public String turnOn() {
        return "티비를 켭니다.";
    }

    public String turnOff() {
        return "티비를 끕니다.";
    }

    public String volumeUp() {
        return "티비 volume Up";
    }

    public String volumeDown() {
        return "티비 volume Down";
    }
}

class Computer implements PowerControl, VolumeControl {
    public String turnOn() {
        return "컴퓨터를 켭니다.";
    }

    public String turnOff() {
        return "컴퓨터를 끕니다.";
    }

    public String volumeUp() {
        return "컴퓨터 volume Up";
    }

    public String volumeDown() {
        return "컴퓨터 volume Down";
    }
}

class Radio implements PowerControl, VolumeControl {
    public String turnOn() {
        return "라디오를 켭니다.";
    }

    public String turnOff() {
        return "라디오를 끕니다.";
    }

    public String volumeUp() {
        return "라디오 volume Up";
    }

    public String volumeDown() {
        return "라디오 volume Down";
    }
}

public class Main {
    public static void main(String args[]) {

        Tv tv = new Tv();
        Computer computer = new Computer();
        Radio radio = new Radio();

        System.out.println(tv.turnOn());
        System.out.println(tv.volumeUp());
        System.out.println(tv.volumeDown());
        System.out.println(tv.turnOff());
        System.out.println(computer.turnOn());
        System.out.println(computer.volumeUp());
        System.out.println(computer.volumeDown());
        System.out.println(computer.turnOff());
        System.out.println(radio.turnOn());
        System.out.println(radio.volumeUp());
        System.out.println(radio.volumeDown());
        System.out.println(radio.turnOff());

    }
}