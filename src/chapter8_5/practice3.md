
# 연락처 관리 앱 - JdbcTemplate DELETE API 문제 정리

**문제 내용:**  
JdbcTemplate을 사용하여 연락처 삭제 API를 구현하는 과제입니다.
구체적으로는 `JdbcContactRepository` 클래스의 `delete` 메서드를 작성하여, 전달받은 데이터를 이용해 연락처를 삭제하는 기능을 구현해야 합니다.

---

### 알아두어야 할 키워드


1. **DELETE 쿼리**
    - 데이터베이스에서 특정 조건에 맞는 데이터를 삭제하는 SQL 문입니다.
    - `DELETE FROM table_name WHERE condition` 형식으로 사용됩니다.

---

### 코드 설명 및 주석 추가

```java
package com.elice.repository;

import com.elice.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JdbcContactRepository {

    private final JdbcTemplate jdbcTemplate;

    // JdbcTemplate 의존성 주입
    @Autowired
    public JdbcContactRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper를 사용하여 ResultSet을 Contact 객체로 변환하는 메서드
    private RowMapper<Contact> contactRowMapper() {
        return (rs, rowNum) -> {
            Contact contact = new Contact();
            contact.setContactId(rs.getLong("contact_id"));
            contact.setName(rs.getString("name"));
            contact.setPhoneNumber(rs.getString("phone_number"));
            contact.setEmail(rs.getString("email"));
            return contact;
        };
    }

    // ID를 통해 연락처를 찾는 메서드. 없을 경우 Optional.empty 반환
    public Optional<Contact> findById(long id) {
        try {
            Contact contact = jdbcTemplate.queryForObject(
                "SELECT * FROM contact WHERE contact_id = ?",
                contactRowMapper(),
                id
            );
            return Optional.ofNullable(contact);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    // 연락처를 삭제하는 메서드. contact 객체에서 ID를 받아 삭제 쿼리 실행
    public void delete(Contact contact) {
        jdbcTemplate.update(
            "DELETE FROM contact WHERE contact_id = ?", // DELETE SQL 쿼리
            contact.getContactId() // 삭제할 대상의 contact_id
        );
    }

}
```

---

### 설명 요약

1. **JdbcTemplate 의존성 주입**
    - `JdbcContactRepository` 클래스는 `JdbcTemplate`을 사용하여 데이터베이스와 상호작용하며, 의존성 주입(@Autowired)을 통해 `JdbcTemplate` 객체를 전달받습니다.

2. **RowMapper 사용**
    - `contactRowMapper()` 메서드는 ResultSet에서 연락처 데이터를 꺼내 `Contact` 객체로 변환합니다.

3. **delete 메서드**
    - `delete(Contact contact)` 메서드는 전달된 `Contact` 객체의 ID를 사용하여 해당 연락처를 삭제합니다. 삭제 쿼리는 `DELETE FROM contact WHERE contact_id = ?`를 사용합니다.
