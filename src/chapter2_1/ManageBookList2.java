package chapter2_1;
class BookSecond {
    String title; // 도서의 제목
    String author; // 도서의 저자
    int publishYear; // 출판년도
    boolean isAvailable; // 대출 가능 여부
}

public class ManageBookList2 {
    public static void main(String[] args) {
        BookSecond book1 = new BookSecond(); // Book 객체 생성
        book1.title = "자바의 정석"; // 제목 설정
        book1.author = "남궁성"; // 저자 설정
        book1.publishYear = 2013; // 출판년도 설정
        book1.isAvailable = true; // 대출 가능 여부 설정

        System.out.println("제목: " + book1.title); // 도서 제목 출력
        System.out.println("저자: " + book1.author); // 도서 저자 출력
        System.out.println("출판년도: " + book1.publishYear); // 출판년도 출력
        System.out.println("대출 가능: " + (book1.isAvailable ? "예" : "아니오")); // 대출 가능 여부 출력
    }
}
