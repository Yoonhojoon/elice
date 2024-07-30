package chapter6_2.practice1;

public class Main {
    public static void main(String[] args) {
        SimpleApplicationContext context = new SimpleApplicationContext();
        // 지시사항 4번을 참고하여 코드를 작성하세요.
        context.registerBean("name", new UserService());

        Service userService = (Service) context.getBean("name");
        System.out.println(userService.getUserName());
    }
}