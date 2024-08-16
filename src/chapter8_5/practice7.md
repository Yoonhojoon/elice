
# 양방향 @ManyToOne 문제 정리

**문제 내용:**  
Employee와 Department 엔티티 간의 관계를 양방향 @ManyToOne/@OneToMany 관계로 구현하는 과제입니다. 
하나의 Department는 여러 Employee를 가질 수 있고, 각 Employee는 하나의 Department에 속하는 구조입니다.

---

### 알아두어야 할 키워드

1. **@ManyToOne**
    - JPA에서 다대일(Many-to-One) 관계를 매핑할 때 사용하는 어노테이션입니다. 여러 개의 `Employee`가 하나의 `Department`에 속할 수 있습니다.

2. **@OneToMany**
    - JPA에서 일대다(One-to-Many) 관계를 매핑할 때 사용하는 어노테이션입니다. 하나의 `Department`는 여러 개의 `Employee`를 가질 수 있습니다.

3. **mappedBy**
    - 양방향 관계에서 사용되며, 주인이 아닌 엔티티의 필드에 지정됩니다. 관계의 주인을 지정하여 매핑을 관리하고, 데이터베이스에 불필요한 외래 키 컬럼이 생성되는 것을 방지합니다.

4. **@JoinColumn**
    - 외래 키(Foreign Key)를 명시적으로 지정하는 어노테이션입니다. 주 엔티티(`Employee`)에서 연결된 엔티티(`Department`)를 참조할 때, 외래 키로 사용할 컬럼을 지정합니다.

5. **양방향 관계**
    - 양방향 관계에서는 두 엔티티 모두가 서로를 참조합니다. 이 경우 `Employee`와 `Department`가 서로를 참조하고 있습니다.

---

### 코드 설명 및 주석 추가

**Department.java**

```java
package com.elice;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter 
public class Department {

    @Id  // 기본 키로 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // IDENTITY 전략으로 기본 키 자동 생성
    private Long id;

    private String name;

    // Employee 엔티티와 양방향 @OneToMany 관계 설정
    // mappedBy = "department"는 Employee 엔티티의 department 필드와 연결됨
    @OneToMany(mappedBy = "department")
    private List<Employee> employees = new ArrayList<>();
}
```

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

    // Department 엔티티와 양방향 @ManyToOne 관계 설정
    @ManyToOne
    @JoinColumn(name = "department_id")  // 외래 키로 사용할 컬럼 지정
    private Department department;
}
```

---

### 설명 요약

1. **양방향 @ManyToOne/@OneToMany 관계 설정**
    - `Department` 엔티티에서 `@OneToMany` 관계를 설정하여 여러 `Employee`를 가질 수 있게 하고, `Employee` 엔티티에서 `@ManyToOne` 관계를 설정하여 하나의 `Department`에 속하도록 했습니다.

2. **mappedBy 속성 사용**
    - `Department` 엔티티의 `employees` 필드에 `mappedBy = "department"`를 설정하여, `Employee` 엔티티의 `department` 필드와 연결되도록 했습니다. 이를 통해 관계의 주인을 `Employee`로 설정합니다.

3. **@JoinColumn 사용**
    - `Employee` 엔티티에서 `@JoinColumn(name = "department_id")` 어노테이션을 사용하여 `department_id`라는 외래 키 컬럼을 통해 `Department`와 연결되도록 설정했습니다.
