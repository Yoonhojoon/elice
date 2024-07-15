package chapter4_1.practice2;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String projectPath = "/src/chapter4_1/practice2";
        String projectRootPath = System.getProperty("user.dir");
        String sourceFilePath = projectRootPath + projectPath + "/image.png";
        String destinationFilePath = projectRootPath + projectPath + "/copied-image.png";


        // 지시 사항을 참고하여 코드를 작성해 보세요.
        try (
                FileInputStream fis = new FileInputStream(sourceFilePath);
                FileOutputStream fos = new FileOutputStream(destinationFilePath);
        ) {
            // 가져오고,
            byte[] buffer = new byte[1024];
            int bytesRead;

            // 붙여넣고
            while ((bytesRead = fis.read(buffer)) != -1){
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("이미지 파일 복사 완료 됨.");

        }catch(IOException e){
            e.printStackTrace();
        }


    }
}


