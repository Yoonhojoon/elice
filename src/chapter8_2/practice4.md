ContactPostDto.java

```java


package com.elice.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactPostDto {

    @NotBlank(message = "이름은 필수입니다.")
    private String name;

    @NotBlank(message = "전화번호는 필수입니다.")
    @Pattern(regexp = "[0-9]+", message = "전화번호는 숫자만 포함해야 합니다.")
    @Size(min = 10, max = 15, message = "전화번호는 10자에서 15자 사이여야 합니다.")
    private String phoneNumber;

    @NotBlank(message = "이메일은 필수입니다.")
    @Email(message = "올바른 이메일 형식이어야 합니다.")
    private String email;

    public Contact toEntity() {
        Contact contact = new Contact(name, phoneNumber, email);
        return contact;
    }
}

```

ContactController.java
```java


package com.elice.controller;

import com.elice.entity.Contact;
import com.elice.entity.ContactPostDto;
import com.elice.entity.ContactResponseDto;
import com.elice.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

    @GetMapping("/{contactId}")
    public ResponseEntity<Contact> getContact(@PathVariable("contactId") long contactId) {
        Contact contact = contactService.findContact(contactId);
        if (contact == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @GetMapping("/name-search")
    public List<Contact> getContactByStartingWith(@RequestParam(name = "name") String name) {
        return contactService.getContactByNameStartingWith(name);
    }

    @GetMapping("/email-search")
    public List<Contact> getContactByEmailEndingWith(@RequestParam(name = "email") String email) {
        return contactService.getContactByEmailEndingWith(email);
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

    // 지시사항을 참고하여 코드를 작성해 보세요.
    @PostMapping
    public ResponseEntity<ContactResponseDto> postContact(@RequestBody @Validated ContactPostDto contactPostDto) {
        Contact contact = contactPostDto.toEntity();
        Contact newContact = contactService.createContact(contact);

        ContactResponseDto contactResponseDto = newContact.toContactReponseDto();
        return new ResponseEntity<>(contactResponseDto, HttpStatus.CREATED);
    }

    @PutMapping("/{contactId}")
    public ResponseEntity<Contact> updateContact(@PathVariable("contactId") long contactId, @RequestBody Contact contact) {
        contact.setContactId(contactId);
        Contact updatedContact = contactService.updateContact(contact);
        return new ResponseEntity<>(updatedContact, HttpStatus.OK);
    }

    @DeleteMapping("/{contactId}")
    public ResponseEntity<Void> deleteContact(@PathVariable("contactId") long contactId) {
        contactService.deleteContact(contactId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

```