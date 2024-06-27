package chapter1_4;

import java.util.Scanner;

public class RoomExit {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        boolean success = false;
        int cnt = 1;

        while (cnt <= 5){
            int password = scanner.nextInt();

            if (password == 1198){
                success = true;
                break;
            }

            cnt++;

        }

        if (success){
            System.out.println("탈출 성공");
        }

        if (!success){
            System.out.println("탈출 싪패");
        }

    }
}
