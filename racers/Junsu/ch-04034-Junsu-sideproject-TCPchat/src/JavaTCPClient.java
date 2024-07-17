import  java.io.*;
import  java.net.*;

public class JavaTCPClient {
    public static void main(String[] args) throws IOException{
        String sentence;
        String modifiedSentence = "";
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in) );

        Socket clientSocket = new Socket("localhost", 7777);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        boolean isChat = true;

        while(isChat){
            System.out.println("서버에 보낼 메시지를  입력하세요: ");
            sentence = inFromUser.readLine();
            outToServer.writeBytes(sentence + '\n');
            if(sentence.equals("EXIT")){
                System.out.println("채팅끝");
                isChat=false;
                continue;
            }
            modifiedSentence = inFromServer.readLine();

            System.out.println("서버로부터의 응답: " + modifiedSentence);
        }
        clientSocket.close();

    }
}
