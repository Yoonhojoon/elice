Contact.java
```java

package com.elice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


// 지시 사항에 따라 코드를 작성해 보세요.
@Entity
@Getter
@Setter
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모든필드
public class Contact  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactId;
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // 이 메서드는 테스트를 위한 것으로 변경하지 않습니다.  
    public ContactResponseDto toContactReponseDto() {
        ContactResponseDto contactResponseDto = new ContactResponseDto(contactId, name, phoneNumber, email);
        return contactResponseDto;
    }
}
```