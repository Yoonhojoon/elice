public class Person {
    int age;
    // 우리가 하고자하는거 int형의 age > double 타입의 age로 자동변환하는 것이 목표.
    float height;
    String grade;
    String name;

    public Person(int age, float height, String grade, String name) {
        this.age = age;
        this.height = height;
        this.grade = grade;
        this.name = name;
    }

    public void displayPerson() {
        double doubleAge = this.age;
        System.out.println(String.format("age: %1$,.2f", doubleAge));
        System.out.println(String.format("키는: %.2f_", this.height));
        System.out.println(String.format("등급 : %s", this.grade));
        System.out.println("이름 : " + this.name);
    }

}
