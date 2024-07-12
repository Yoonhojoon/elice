package elice;

class NetworkException extends Exception {
    public NetworkException(String message) {
        super(message);
    }
}

class AccountInfoException extends Exception {
    public AccountInfoException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {

        // 지시 사항을 참고하여 코드를 작성해 보세요.
        try {
            checkBalance(Math.random());
        } catch (NetworkException e) {
            System.out.println(e.getMessage());
        } catch (AccountInfoException e) {
            System.out.println(e.getMessage());
        }

    }

    static void checkBalance(double randomValue) throws NetworkException, AccountInfoException {

        // 지시 사항을 참고하여 코드를 작성해 보세요.
        if(randomValue <= 0.5){
            throw new AccountInfoException("계좌 정보를 찾을 수 없습니다.");
        }
        throw new NetworkException("네트워크 연결 오류가 발생했습니다.");

    }
}
