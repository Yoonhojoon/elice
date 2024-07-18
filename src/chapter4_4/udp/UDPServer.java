package chapter4_4.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {
    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {
            socket = new DatagramSocket(9876);
            byte[] reciveData = new byte[1024];

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(reciveData, reciveData.length);
                socket.receive(receivePacket);

                String message = new String(receivePacket.getData(),0,receivePacket.getLength());
                System.out.println("수신된 클라이언트 메시지: "+ message);
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (socket != null){
                socket.close();
            }
        }
    }
}
