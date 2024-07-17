import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class WeatherAPISocketPractice {
    private static final String HOST = "api.openweathermap.org";
    // https 통신 443
    private static final int PORT = 443;

    public static void main(String[] args) {

        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();

        try (Socket socket = factory.createSocket(HOST, PORT);
             OutputStream outputStream = socket.getOutputStream();
             PrintWriter writer = new PrintWriter(outputStream, true);

             InputStream inputStream = socket.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            // GET 응답
            //latitude 위도 longitude 경도
            //계정 가입하고 일정 시간 지나야 함
            //1.1 1997년 만들어진 표준 프로토콜 => HTTP/2가 더 성능이 좋음 하지만 서버에서 지원해줘야함
            writer.println("GET /data/2.5/weather?q=Seoul&APPID=f57d579de7b0fbf006e81423934de112 HTTP/1.1");
//            writer.println("GET /data/2.5/weather?lat=37.5665&lon=126.9779&appid=f57d579de7b0fbf006e81423934de112");
            writer.println("Host: " + HOST);
            writer.println("User-Agent: Chrome");
            writer.println("Connection: close");
            writer.println();
            //헤더 끝
            StringBuilder response = new StringBuilder();
            String line;
            boolean isContent = false;
            while((line = reader.readLine()) != null) {
                if (!isContent) {
                    if (line.isEmpty()) {
                        isContent = true;
                    }
                    continue;
                }
                response.append(line);
            }
            // byte단위 스트림을 받는다면 .toString() 필요
//            System.out.println(response.toString());
            System.out.println(response);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
