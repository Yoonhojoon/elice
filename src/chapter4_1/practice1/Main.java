package chapter4_1.practice1;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String inputData = "Hello, Wonder!";
        String inputFilename = "./Hello.txt";

        // 지시 사항에 따라 코드를 입력해 보세요.
        try (FileOutputStream fos = new FileOutputStream(inputFilename)) {
            System.out.println("파일에 데이터가 성공적으로 입력되었습니다.");
            fos.write(inputData.getBytes());
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        } catch (IOException e) {
            System.out.println("파일 쓰기 중 오류가 발생했습니다.");
        }

    }
}