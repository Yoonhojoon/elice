
# 단방향 @OneToOne 문제 정리

**문제 내용:**  
User 엔티티와 UserProfile 엔티티 간의 단방향 @OneToOne 관계를 구현하는 과제입니다.
User 엔티티는 하나의 UserProfile 엔티티를 참조하고, UserProfile 엔티티는 User 엔티티를 참조하지 않는 단방향 매핑을 설정합니다.

---

### 알아두어야 할 키워드

1. **@OneToOne**
    - JPA에서 일대일(One-to-One) 관계를 매핑할 때 사용하는 어노테이션입니다. 단방향 또는 양방향으로 설정할 수 있으며, 한 엔티티가 다른 하나의 엔티티만을 참조합니다.

2. **@JoinColumn**
    - 외래 키(Foreign Key)를 명시적으로 지정하는 어노테이션입니다. 주 엔티티(User)에서 연결된 엔티티(UserProfile)를 참조할 때, 외래 키로 사용할 컬럼을 지정합니다.

3. **단방향 관계**
    - 단방향 관계에서는 한쪽 엔티티만이 다른 엔티티를 참조하며, 반대쪽 엔티티는 참조하지 않습니다. 이 경우, User 엔티티만 UserProfile을 참조하고, UserProfile 엔티티는 User 엔티티를 참조하지 않습니다.

4. **@GeneratedValue**
    - 기본 키 값을 자동으로 생성해주는 어노테이션입니다. 이 문제에서는 `GenerationType.IDENTITY` 전략을 사용하여 ID를 자동 생성합니다.

---

### 코드 설명 및 주석 추가

**User.java**

```java
package com.elice;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")  // "users" 테이블과 매핑
@Getter @Setter  
public class User {

    @Id  // 기본 키로 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // IDENTITY 전략으로 기본 키 자동 생성
    private Long id;

    private String username;

    // UserProfile 엔티티와 단방향 @OneToOne 관계 설정
    @OneToOne
    @JoinColumn(name = "user_profile_id")  // 외래 키로 사용할 컬럼 지정
    private UserProfile userProfile;
}
```

**UserProfile.java**

```java
package com.elice;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter  
public class UserProfile {

    @Id  // 기본 키로 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // IDENTITY 전략으로 기본 키 자동 생성
    private Long id;

    private String address;

}
```

---

### 설명 요약

1. **단방향 @OneToOne 관계 설정**
    - `User` 엔티티에서 `UserProfile` 엔티티와의 단방향 일대일 관계를 설정했습니다. 이 관계에서는 `User` 엔티티만이 `UserProfile` 엔티티를 참조하고 있으며, `UserProfile`은 `User`를 참조하지 않습니다.

2. **@JoinColumn 사용**
    - `User` 엔티티에서 `@JoinColumn(name = "user_profile_id")` 어노테이션을 통해 `user_profile_id`라는 외래 키 컬럼을 사용하여 `UserProfile`과 연결되도록 설정했습니다.

3. **단순한 UserProfile 엔티티**
    - `UserProfile` 엔티티는 `User` 엔티티에 대한 참조를 갖지 않으며, `id`와 `address` 필드만을 갖고 있습니다.

4. **Lombok 사용**
    - `@Getter`와 `@Setter` 어노테이션을 사용하여 Lombok 라이브러리가 자동으로 게터와 세터 메서드를 생성하도록 설정했습니다.
