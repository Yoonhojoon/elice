
BaseEntity
```java
package com.elice.audit;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter @Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

}
```



Contact
```java
package com.elice.entity;

import com.elice.audit.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Contact extends BaseEntity { // BaseEntity를 상속할 수 있도록 코드를 작성해 보세요. 
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

    public ContactResponseDto toContactReponseDto() {
        ContactResponseDto contactResponseDto = new ContactResponseDto(contactId, name, phoneNumber, email);
        return contactResponseDto;
    }
}
```



EliceApplication
```java
package com.elice;

import com.elice.repository.ContactRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// 지시사항을 참고하여 코드를 작성해 보세요.
@EnableJpaAuditing
@SpringBootApplication
public class EliceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EliceApplication.class, args);
	}

	@Bean
	@Profile("local")
	public DataInit dataInit(ContactRepository contactRepository) {
		return new DataInit(contactRepository);
	}
}
```


