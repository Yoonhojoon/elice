package chapter3_4.practice2;

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
        }catch(NetworkException e){
            e.printStackTrace();
        }catch(AccountInfoException e){
            e.printStackTrace();
        }


    }

    static void checkBalance(double randomValue) throws NetworkException, AccountInfoException {

        // 지시 사항을 참고하여 코드를 작성해 보세요.
        if (randomValue > 0.5){
            throw new NetworkException("네트워크 연결 오류가 발생했습니다.");
        }

        if (randomValue <= 0.5){
            throw new AccountInfoException("계좌 정보를 찾을수 없습니다.");

        }

    }
}
