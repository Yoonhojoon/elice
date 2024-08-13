ContactController.java
```java


package com.elice.controller;

import com.elice.entity.Contact;
import com.elice.entity.ContactPostDto;
import com.elice.entity.ContactResponseDto;
import com.elice.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    // 지시사항에 맞게 코드를 수정해 주세요.
    @PostMapping
    public ResponseEntity<ContactResponseDto> postContact(@RequestBody ContactPostDto contactPostDto) {
        Contact contact = contactPostDto.toEntity();
        Contact newContact = contactService.createContact(contact);

        ContactResponseDto contactResponseDto = newContact.toContactReponseDto();
        return new ResponseEntity<>(contactResponseDto, HttpStatus.CREATED);
    }

}

```

ContactPostDto.java

```java



package com.elice.entity;

public class ContactPostDto {
private String name;
private String phoneNumber;
private String email;

    // 반드시 필요
    public ContactPostDto() {
    }

    public ContactPostDto(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public Contact toEntity() {
        Contact contact = new Contact(name, phoneNumber, email);
        return contact;
    }
}

```

ContactResponseDto.java
```java



package com.elice.entity;

public class ContactResponseDto {

    private Long contactId;
    private String name;
    private String phoneNumber;
    private String email;


    public ContactResponseDto(Long contactId, String name, String phoneNumber, String email) {
        this.contactId = contactId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}

```