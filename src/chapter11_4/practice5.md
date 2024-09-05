
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

    public Page<Contact> findContacts(int page, int size) {
        return contactRepository.findAll(PageRequest.of(page- 1, size, Sort.by("contactId").descending()));
    }

    public List<Contact> findContacts() {
        return contactRepository.findAll();
    }

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


        @GetMapping
    public ResponseEntity<List<Contact>> getContacts(@RequestParam(name = "page", defaultValue = "1") int page, @RequestParam(name = "size",  defaultValue = "10") int size) {
        Page<Contact> pageContacts = contactService.findContacts(page, size);
        List<Contact> contacts = pageContacts.getContent();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Total-Element", String.valueOf(pageContacts.getTotalElements()));
        headers.add("Total-Pages", String.valueOf(pageContacts.getTotalPages()));
        headers.add("Current-Page", String.valueOf(pageContacts.getNumber() + 1));
        headers.add("Page-Size", String.valueOf(pageContacts.getSize()));

        if (contacts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(contacts, headers, HttpStatus.OK);
    }
}
```

