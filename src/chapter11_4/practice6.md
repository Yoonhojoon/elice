
ContactRepository
```java
package com.elice.repository;

import java.util.List;
import com.elice.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    
    // 지시사항에 따라 코드를 작성해 보세요.
    @Query(value = "SELECT * FROM contact WHERE name LIKE ?1%", nativeQuery = true)
    List<Contact> findByNameStartingWith(String name);

    @Query(value = "SELECT * FROM contact WHERE email LIKE %?1", nativeQuery = true)
    List<Contact> findByEmailEndingWith(String email);
}
```



ContactController
```java
package com.elice.controller;

import com.elice.entity.Contact;
import com.elice.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    
    private final ContactService contactService;
    
    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }
    
    
    // 지시사항에 따라 코드를 작성해 보세요. 
    @GetMapping("/name-search")
    public List<Contact> getContactByStartingWith(@RequestParam(name = "name") String name) {
        return contactService.getContactByNameStartingWith(name);
    }

    @GetMapping("/email-search")
    public List<Contact> getContactByEmailEndingWith(@RequestParam(name = "email") String email) {
        return contactService.getContactByEmailEndingWith(email);
    }
}
```



ContactService
```java
package com.elice.service;

import com.elice.entity.Contact;
import com.elice.repository.ContactRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    
    private final ContactRepository contactRepository;
    
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
    
    public List<Contact> getContactByNameStartingWith(String name) {
        return contactRepository.findByNameStartingWith(name);
    }
    
    public List<Contact> getContactByEmailEndingWith(String email) {
        return contactRepository.findByEmailEndingWith(email);
    }

}
```

