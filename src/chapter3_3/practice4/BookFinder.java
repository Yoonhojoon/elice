package chapter3_3.practice4;


import java.util.List;
import java.util.stream.Collectors;


public class BookFinder {

    public static List<Book> findBooksPublishedAfter(List<Book> books, int year) {
        // 지시 사항을 참고하여 코드를 작성하세요.
        return books.stream()
                .filter(book -> book.getYearOfPublication() > year)
                .collect(Collectors.toList());
    }

    public static List<Book> findBooksWithMorePagesThan(List<Book> books, int numberOfPages) {
        // 지시 사항을 참고하여 코드를 작성하세요.
        return books.stream()
                .filter(book -> book.getNumberOfPages() > numberOfPages)
                .collect(Collectors.toList());
    }
}