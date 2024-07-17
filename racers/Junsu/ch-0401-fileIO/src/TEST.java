import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TEST {
    public static void main(String[] args) {
            String inputData = "Hello, Wonder!";
            String directoryName = System.getProperty("user.dir")+"/ch-0401-fileIO"; // Junsu까지만
            System.out.println(directoryName);
            String inputFileDirectory = "./ch-0401-fileIO/Hello.txt";
//
//            // 지시 사항에 따라 코드를 입력해 보세요.
//
             try{
                 FileOutputStream fos = new FileOutputStream(inputFiledirectory);
                 byte[] bytes = inputData.getBytes();
                 fos.write(bytes);

             }catch(IOException e){
                 e.printStackTrace();
             }
            try(FileOutputStream fos = new FileOutputStream("Hello.txt")){
                System.out.println("파일에 데이터가 성공적으로 입력되었습니다.");
                // 성공한다면.
                byte[] bytes = inputData.getBytes();
                fos.write(bytes);

            }catch(FileNotFoundException e){
                System.out.println("파일을 찾을 수 없습니다.");
                //하위객체로 디테일한 오류를 먼저 체크
            }catch(IOException e){
                System.out.println("파일 쓰기 중 오류가 발생했습니다.");
            }
    }
}
