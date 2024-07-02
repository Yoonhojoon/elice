package chapter2_1;
class Book {
    String title;
}
public class ManageBookList {
    public static void main(String[] args) {
        Book book1 = new Book();
        book1.title = "자바의 정석";

        Book book2 = new Book();
        book2.title = "클린 코드";

        System.out.println(book1.title);
        System.out.println(book2.title);
    }
}
