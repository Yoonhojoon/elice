package chapter3_3.practice3;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class StringListSorter {

    public static List<String> sortList(List<String> inputList) {
        // 지시 사항을 참고하여 코드를 구현해 보세요.
        Collections.sort(inputList,String::compareToIgnoreCase);
        return inputList;

    }

    public static void main(String[] args) {
        // 테스트를 위한 문자열 리스트 초기화
        List<String> names = Arrays.asList("Steve", "Rachel", "Mike", "peter", "anna");

        // sortList 메서드를 호출하여 리스트를 정렬하세요.
        List<String> strings = sortList(names);

        // 정렬된 리스트를 출력하세요.
        System.out.println(strings);

    }
}
