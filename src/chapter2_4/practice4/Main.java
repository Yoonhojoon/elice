package chapter2_4.practice4;

public class Main {
    public static void main(String[] args) {

        Car car = new Tesla("모델 Y", 2020, 5000);

        // 지시사항을 참고하여 코드를 작성해 보세요.

        if (car instanceof Tesla){
            Tesla tesla = (Tesla) car;
            tesla.autopilot();
        }

    }
}

class Car {
    public String model;
    public int year;

    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    public void start() {
        System.out.println(this.model + "이(가) 출발합니다.");
    }

    public void stop() {
        System.out.println(this.model + "이(가) 정지합니다.");
    }
}

class Tesla extends Car {
    public int batteryCapacity;

    public Tesla(String model, int year, int batteryCapacity) {
        super(model, year);
        this.batteryCapacity = batteryCapacity;
    }

    public void autopilot() {
        System.out.println("테슬라가 오토파일럿 모드로 주행합니다.");
    }
}
