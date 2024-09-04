
ContactService
```java
package com.elice.service;

import com.elice.entity.Contact;
import com.elice.repository.ContactRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Transactional
    public Contact createContact(Contact contact) {

        Contact savedContact = contactRepository.save(contact);

        if (true) {
            // 지시사항을 참고하여 코드를 작성해 보세요.
            throw new RuntimeException("롤백 발생!");
        }

        return savedContact;
    }

}
```
