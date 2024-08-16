## 설명        
- JdbcTemplate: 스프링 프레임워크에서 제공하는 JDBC 관련 클래스로, SQL 쿼리를 쉽게 실행하고 데이터베이스 작업을 편리하게 할 수 있도록 도와줌.
- RowMapper: 데이터베이스의 ResultSet을 도메인 객체로 변환해주는 인터페이스로, SQL 쿼리의 결과를 매핑하여 특정 객체로 변환하는 역할을 담당.
- query(): SQL 쿼리를 실행하고, 여러 개의 결과를 리스트로 반환하는 JdbcTemplate 메서드.
- queryForObject(): SQL 쿼리를 실행하여 단일 객체를 반환하는 JdbcTemplate 메서드. 주로 ID나 단일 열을 조회할 때 사용됨.
- EmptyResultDataAccessException: 쿼리 결과가 없을 때 발생하는 예외로, 빈 결과를 처리하기 위한 예외 핸들링이 필요함.
- Optional: 반환값이 null일 가능성을 처리하는 Java 클래스. null을 직접적으로 반환하는 대신 명시적으로 빈 값을 나타낼 수 있음.


JdbcContactRepository.java
```java
package com.elice.repository;

import com.elice.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcContactRepository {

    private final JdbcTemplate jdbcTemplate;

    // JdbcTemplate을 의존성 주입 받음
    @Autowired
    public JdbcContactRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper를 구현하여 ResultSet을 Contact 객체로 매핑
    private RowMapper<Contact> contactRowMapper() {
        return (rs, rowNum) -> {
            Contact contact = new Contact();  // 새로운 Contact 객체 생성
            contact.setContactId(rs.getLong("contact_id"));  // ResultSet에서 contact_id 열의 값을 Contact 객체에 설정
            contact.setName(rs.getString("name"));  // ResultSet에서 name 열의 값을 Contact 객체에 설정
            contact.setPhoneNumber(rs.getString("phone_number"));  // ResultSet에서 phone_number 열의 값을 Contact 객체에 설정
            contact.setEmail(rs.getString("email"));  // ResultSet에서 email 열의 값을 Contact 객체에 설정
            return contact;  // 매핑된 Contact 객체 반환
        };
    }

    // 모든 연락처를 조회하는 메서드 구현
    public List<Contact> findAll() {
        // SELECT 쿼리를 사용하여 모든 연락처를 조회하고, RowMapper를 통해 Contact 객체로 변환
        return jdbcTemplate.query("SELECT * FROM contact", contactRowMapper());
    }

    // ID로 연락처를 조회하는 메서드 구현
    public Optional<Contact> findById(long id) {
        try {
            // 주어진 ID로 연락처를 조회하고, RowMapper를 사용해 Contact 객체로 변환
            Contact contact = jdbcTemplate.queryForObject(
                    "SELECT * FROM contact WHERE contact_id = ?",
                    contactRowMapper(),
                    id
            );
            // 조회된 연락처를 Optional로 반환
            return Optional.ofNullable(contact);
        } catch (EmptyResultDataAccessException e) {
            // 결과가 없을 경우 Optional.empty()를 반환하여 빈 값을 처리
            return Optional.empty();
        }
    }
}

```


