
Bank.java
```java
package com.elice;

public class Bank {

    private int balance;

    public void deposit(int money) {
        balance = balance + money;
    }

    public void withdraw(int money) throws InsufficientException {
        if (balance < money) {
            throw new InsufficientException("잔고가 부족합니다.");
        }
        balance = balance - money;
    }
}
```



ExceptionHandlingTest.java
```java
package com.elice;

public class ExceptionHandlingTest {

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.deposit(10000000);

        try {
            bank.withdraw(100000000);
        } catch (InsufficientException e) {
            System.out.println("에러 메시지: " + e.getMessage());
        }
    }
}
```



InsufficientException.java
```java
package com.elice;

public class InsufficientException extends Exception {

    public InsufficientException(String message) {
        super(message);
    }
}

```

