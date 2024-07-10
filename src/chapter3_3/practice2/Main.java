package chapter3_3.practice2;


@FunctionalInterface
interface StringTransformer {
    // 지시사항을 참고하여 코드를 작성해 보세요.
    public String transform(String s);
}

public class Main {
    // 지시사항을 참고하여 코드를 작성해 보세요.
    public static StringTransformer toUpperCaseTransformer= String::toUpperCase;
    public static StringTransformer removeSpacesTransformer= s -> s.replace(" ", "");
    public static StringTransformer addAsteriskTransformer = s -> "*" + s.trim() + "*";

    public static void main(String[] args) {
        String inputString = " Hello, Functional Interface! ";

        System.out.println("대문자 변환 후: " + toUpperCaseTransformer.transform(inputString));
        System.out.println("공백 제거 후: " + removeSpacesTransformer.transform(inputString));
        System.out.println("\"*\" 기호 추가 후: " + addAsteriskTransformer.transform(inputString));
    }
}
