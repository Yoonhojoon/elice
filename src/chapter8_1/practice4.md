ContactController.java
```java


package com.elice.controller;

import com.elice.entity.Contact;
import com.elice.entity.ContactPostDto;
import com.elice.entity.ContactResponseDto;
import com.elice.mapper.ContactMapper;
import com.elice.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;
    private final ContactMapper mapper;

    @Autowired
    public ContactController(ContactService contactService, ContactMapper contactMapper) {
        this.contactService = contactService;
        this.mapper = contactMapper;
    }

    // 지시사항에 맞게 코드를 수정해 주세요.
    @PostMapping
    public ResponseEntity<ContactResponseDto> postContact(@RequestBody ContactPostDto contactPostDto) {
//        Contact contact = contactPostDto.toEntity();
Contact contact = mapper.contactPostDtoToContact(contactPostDto);
Contact newContact = contactService.createContact(contact);

//        ContactResponseDto contactResponseDto = newContact.toContactReponseDto();
ContactResponseDto contactResponseDto = mapper.contactToContactResponseDto(newContact);
return new ResponseEntity<>(contactResponseDto, HttpStatus.CREATED);
}
}

```



ContactMapper.java
```java



package com.elice.mapper;

import com.elice.entity.Contact;
import com.elice.entity.ContactPostDto;
import com.elice.entity.ContactResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    Contact contactPostDtoToContact(ContactPostDto contactPostDto);

    ContactResponseDto contactToContactResponseDto(Contact contact);
}

```