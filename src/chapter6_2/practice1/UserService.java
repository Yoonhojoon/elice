package chapter6_2.practice1;

interface Service {
    String getUserName();
}

class UserService implements Service {
    @Override
    public String getUserName() {
        return "Alice";
    }
}