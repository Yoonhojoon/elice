
AccountService
```java
package com.elice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transfer(Long fromAccountId, Long toAccountId, double amount) {
        // 출금 계좌와 입금 계좌를 조회합니다.
        Account fromAccount = accountRepository.findById(fromAccountId)
                .orElseThrow(() -> new RuntimeException("출금 계좌가 존재하지 않습니다."));

        Account toAccount = accountRepository.findById(toAccountId)
                .orElseThrow(() -> new RuntimeException("입금 계좌가 존재하지 않습니다."));

        // 잔액이 충분한지 확인하고, 부족할 경우 예외를 발생시킵니다.
        if (fromAccount.getBalance() < amount) {
            throw new InsufficientFundsException("잔액이 부족합니다.");
        }

        // 잔액을 업데이트합니다.
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

    }
}
```


