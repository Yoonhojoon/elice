package chapter4_4.udp;

import java.io.IOException;
import java.net.*;

public class UDPClient {
    public static void main(String[] args){
        DatagramSocket socket = null;

        try {
            socket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName("localhost");
            String hostName = IPAddress.getHostName();
            String hostAddress = IPAddress.getHostAddress();
            String canonicalHostName =  IPAddress.getCanonicalHostName();

            byte[] sendData = new byte[1024];
            String sentence = "참가자 1 입니다.";

            System.out.println("호스트 네임은  : "+ hostName);
            System.out.println("호스트 주소는  : "+ hostAddress);


            sendData = sentence.getBytes();


            DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length, IPAddress, 9876);
            socket.send(sendPacket);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);

            String modifiedSentence = new String(receivePacket.getData(),0,receivePacket.getLength());
            System.out.println("서버 메시지 : " + modifiedSentence);

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
