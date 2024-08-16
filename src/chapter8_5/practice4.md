
# 연락처 관리 앱 - 엔티티 매핑 문제 정리

**문제 내용:**  
Contact 엔티티 클래스를 데이터베이스 테이블과 매핑하는 과제입니다.
이 클래스는 JPA의 어노테이션을 사용하여 데이터베이스 테이블 및 컬럼과 연결되며, 필드를 데이터베이스 컬럼과 매핑합니다.

---

### 알아두어야 할 키워드

1. **@Entity**
    - 클래스가 JPA 엔티티임을 나타내는 어노테이션입니다. 이 어노테이션이 붙은 클래스는 데이터베이스 테이블과 연결됩니다.

2. **@Table**
    - 엔티티 클래스가 매핑될 테이블의 이름을 명시하는 어노테이션입니다. `name` 속성을 통해 테이블 이름을 지정할 수 있습니다.

3. **@Id**
    - 엔티티의 기본 키를 나타내는 어노테이션입니다. 이 필드가 엔티티의 식별자로 사용됩니다.

4. **@GeneratedValue**
    - 기본 키의 값을 자동으로 생성해주는 어노테이션입니다. `strategy` 속성을 통해 기본 키 생성 전략을 지정할 수 있으며, 이 문제에서는 `IDENTITY` 전략을 사용합니다.

5. **@Column**
    - 엔티티의 필드를 데이터베이스의 컬럼과 매핑하는 어노테이션입니다. `nullable`, `unique`, `updatable` 등의 속성을 통해 제약 조건을 설정할 수 있습니다.

6. **@Getter, @Setter**
    - Lombok 라이브러리를 사용하여 클래스의 게터와 세터 메서드를 자동으로 생성하는 어노테이션입니다.

7. **@NoArgsConstructor, @AllArgsConstructor**
    - Lombok 라이브러리를 사용하여 매개변수가 없는 생성자와 모든 필드를 매개변수로 받는 생성자를 자동으로 생성하는 어노테이션입니다.

---

### 코드 설명 및 주석 추가

```java
package com.elice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Contacts")  // "Contacts" 테이블과 매핑
@NoArgsConstructor  // 매개변수가 없는 기본 생성자 자동 생성
@AllArgsConstructor // 모든 필드를 매개변수로 받는 생성자 자동 생성
@Getter  
@Setter  
public class Contact {

    @Id  // 기본 키로 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // IDENTITY 전략으로 기본 키 자동 생성
    private Long contactId;

    @Column(nullable = false, unique = true)  // name 필드는 null이 될 수 없고, 유일해야 함
    private String name;

    @Column(nullable = false, updatable = true)  // phoneNumber 필드는 null이 될 수 없고, 수정 가능해야 함
    private String phoneNumber;

    @Column(nullable = true, updatable = false)  // email 필드는 null이 될 수 있으며, 수정 불가능해야 함
    private String email;
}
```
