package chapter4_1.practice3;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String projectPath = "/src/chapter4_1/practice3";
        String projectRootPath = System.getProperty("user.dir");
        String inputFilename = projectRootPath + projectPath + "/Hello.txt";


        System.out.println("파일 내용: " + readFileContent(inputFilename));
    }

    public static String readFileContent(String inputFilename) {
        StringBuilder fileContent = new StringBuilder();

        try (FileInputStream fis = new FileInputStream(inputFilename)) {
            int byteData;
            while ((byteData = fis.read()) != -1) {
                fileContent.append((char) byteData);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "파일을 찾을 수 없습니다.";
        } catch (IOException e) {
            e.printStackTrace();
            return "파일 읽기 중 오류가 발생했습니다.";
        }

        return fileContent.toString();
    }
}