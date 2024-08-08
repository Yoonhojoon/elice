package chapter4_4.tcp;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class TCPServer {
    public static void main (String[] args){
        int port = 6789;

        try (ServerSocket welcomeSocket = new ServerSocket(port)) {
            Socket connectionSocket =  welcomeSocket.accept();
            System.out.println("클라이언트와 연결됨.");

            BufferedReader inFromClient = new BufferedReader(
                    new InputStreamReader(connectionSocket.getInputStream())
            );
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            String clientSentence = inFromClient.readLine();
            System.out.println("클라이언트로 부터 : "+clientSentence);

            String capitalizedSentence = clientSentence.toString() + "\n";
            outToClient.writeBytes(capitalizedSentence.toUpperCase());

        }catch (IOException ioException){
            ioException.printStackTrace();
        }

    }

}
