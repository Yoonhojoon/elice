
ContactControllerV2.java
```java
package com.elice.controller;

import com.elice.entity.Contact;
import com.elice.entity.ContactPostDto;
import com.elice.entity.ContactResponseDto;
import com.elice.service.ContactService;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/contacts")
@Validated
public class ContactControllerV2 {

    private final ContactService contactService;

    @Autowired
    public ContactControllerV2(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/{contactId}")
    public ResponseEntity<Contact> getContact(@PathVariable("contactId") @Positive long contactId) {
        Contact contact = contactService.findContact(contactId);
        if (contact == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Contact>> getContacts(@RequestParam(name = "page", defaultValue = "1") @Min(1) int page,
                                                     @RequestParam(name = "size",  defaultValue = "10") @Min(1) int size) {
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

    @GetMapping("/name-search")
    public List<Contact> getContactByStartingWith(@RequestParam(name = "name") @NotBlank String name) {
        return contactService.getContactByNameStartingWith(name);
    }

    @GetMapping("/email-search")
    public List<Contact> getContactByEmailEndingWith(@RequestParam(name = "email") @Email String email) {
        return contactService.getContactByEmailEndingWith(email);
    }


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


    @ExceptionHandler
    public ResponseEntity exceptionHandle(MethodArgumentNotValidException e){
        List<FieldError> error = e.getBindingResult().getFieldErrors();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    
}
```
