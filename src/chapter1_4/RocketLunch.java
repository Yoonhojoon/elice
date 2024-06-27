package chapter1_4;


//로켓 발사하기
public class RocketLunch {
    public static void main(String[] args) {
        int count = 10;

        // 지시사항 1번을 참고하여 코드를 작성하세요.

        while(count > 0){
            System.out.println(count);
            count--;
            try {
                Thread.sleep(1000); // 1000 밀리초 = 1초
            } catch (InterruptedException e) {
                // 예외가 발생하면 스레드 인터럽트 상태를 다시 설정
                Thread.currentThread().interrupt();
                // 예외 메세지를 출력
                System.err.println("Thread was interrupted, Failed to complete operation");
            }
        }

        System.out.println("로켓 발사!");
    }
}
