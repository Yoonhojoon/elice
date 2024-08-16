
# 단방향 @ManyToOne 문제 정리

**문제 내용:**  
Employee 엔티티가 Department 엔티티와의 단방향 @ManyToOne 관계를 가지는 시나리오를 구현하는 과제입니다.
Employee는 하나의 Department에 속하지만, Department는 Employee를 참조하지 않는 단방향 매핑을 설정합니다.

---

### 알아두어야 할 키워드

1. **@ManyToOne**
    - JPA에서 다대일(Many-to-One) 관계를 매핑할 때 사용하는 어노테이션입니다. 하나의 엔티티가 다른 여러 엔티티와 연결될 때 사용됩니다. 
    - 이 경우, 여러 `Employee`가 하나의 `Department`에 속할 수 있습니다.

2. **@JoinColumn**
    - 외래 키(Foreign Key)를 명시적으로 지정하는 어노테이션입니다. 주 엔티티(Employee)에서 연결된 엔티티(Department)를 참조할 때, 외래 키로 사용할 컬럼을 지정합니다.

3. **단방향 관계**
    - 단방향 관계에서는 한쪽 엔티티만이 다른 엔티티를 참조합니다. 이 경우, `Employee` 엔티티가 `Department` 엔티티를 참조하고, `Department` 엔티티는 `Employee`를 참조하지 않습니다.

4. **@GeneratedValue**
    - 기본 키 값을 자동으로 생성해주는 어노테이션입니다. 이 문제에서는 `GenerationType.IDENTITY` 전략을 사용하여 ID를 자동 생성합니다.

---

### 코드 설명 및 주석 추가

**Employee.java**

```java
package com.elice;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter 
public class Employee {

    @Id  // 기본 키로 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // IDENTITY 전략으로 기본 키 자동 생성
    private Long id;

    private String firstName;
    private String lastName;

    // Department 엔티티와 단방향 @ManyToOne 관계 설정
    @ManyToOne
    @JoinColumn(name = "department_id")  // 외래 키로 사용할 컬럼 지정
    private Department department;
}
```

**Department.java**

```java
package com.elice;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter 
public class Department {

    @Id  // 기본 키로 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // IDENTITY 전략으로 기본 키 자동 생성
    private Long id;

    private String name;
}
```

---

### 설명 요약

1. **단방향 @ManyToOne 관계 설정**
    - `Employee` 엔티티에서 `Department` 엔티티와의 단방향 다대일 관계를 설정했습니다. 여러 `Employee`가 하나의 `Department`에 속할 수 있으며, `Employee`만이 `Department`를 참조합니다.

2. **@JoinColumn 사용**
    - `Employee` 엔티티에서 `@JoinColumn(name = "department_id")` 어노테이션을 통해 `department_id`라는 외래 키 컬럼을 사용하여 `Department`와 연결되도록 설정했습니다.
