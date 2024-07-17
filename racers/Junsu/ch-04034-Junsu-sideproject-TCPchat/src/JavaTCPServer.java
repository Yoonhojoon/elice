import java.io.*;
import java.net.*;


public class JavaTCPServer {
    public static void main(String[] args) throws IOException {
        int port = 7777;
        ServerSocket welcomeSocket = new ServerSocket(port);
        System.out.println("서버가 " + port + "포트에서 클라이언트의 연결을 기다립니다...");
        Socket connectionSocket = welcomeSocket.accept();
        while(true) {
            System.out.println("클라이언트와 연결되었습니다.");

            BufferedReader inFromClient = new BufferedReader
                    (new InputStreamReader((connectionSocket.getInputStream())));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            String clienSentence = inFromClient.readLine();
            System.out.println("클라이언트로부터 받은 메시지: " + clienSentence);
            if(clienSentence.equals("EXIT")){
                System.out.println("DisConnected");
                System.out.println("서버가 " + port + "포트에서 클라이언트의 연결을 기다립니다...");
                connectionSocket = welcomeSocket.accept();
                continue;
            }
            String capitalizedSentence = clienSentence.toUpperCase() + '\n';
            outToClient.writeBytes(capitalizedSentence);
        }
        // 예네 왜 종료했다고 메세지 안보내냐?

    }
}
