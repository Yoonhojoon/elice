## 설명
- JdbcTemplate: 스프링 프레임워크에서 제공하는 클래스. SQL 쿼리를 간편하게 실행할 수 있는 도구.
- update(): SQL 쿼리를 실행하여 데이터베이스의 데이터를 수정하거나 삽입할 때 사용되는 JdbcTemplate의 메서드.
- PreparedStatement: SQL 쿼리를 미리 컴파일하여 성능을 향상시키고, 파라미터를 안전하게 전달하는 객체.
- GeneratedKeyHolder: 데이터베이스에 새로운 레코드를 삽입한 후, 자동 생성된 키 값을 저장하는 객체. 주로 기본 키(Primary Key)를 추출할 때 사용.
- KeyHolder: 자동 생성된 키 값을 담고 있는 인터페이스로, 이를 통해 삽입된 레코드의 ID 값을 얻을 수 있음.
- Statement.RETURN_GENERATED_KEYS: SQL 쿼리를 실행한 후, 자동 생성된 키를 반환하도록 설정하는 옵션.


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

    // 연락처를 저장하는 메서드
    public Contact save(Contact contact) {
        // contactId가 없는 경우(새로운 연락처를 저장)
        if (contact.getContactId() == null) {
            KeyHolder keyHolder = new GeneratedKeyHolder();  // 생성된 키를 저장할 KeyHolder 객체 생성
            
            // INSERT 쿼리 실행
            jdbcTemplate.update(
                    connection -> {
                        // PreparedStatement를 통해 SQL 쿼리 작성, 생성된 키 반환 설정
                        PreparedStatement ps = connection.prepareStatement(
                                "INSERT INTO contact (name, phone_number, email) VALUES (?, ?, ?)",
                                Statement.RETURN_GENERATED_KEYS
                        );
                        // 연락처 데이터를 PreparedStatement에 설정
                        ps.setString(1, contact.getName());
                        ps.setString(2, contact.getPhoneNumber());
                        ps.setString(3, contact.getEmail());
                        return ps;  // PreparedStatement 반환
                    },
                    keyHolder  // 생성된 키 값을 저장할 객체 전달
            );
            
            // 삽입된 연락처의 ID 값을 keyHolder로부터 추출하여 contact 객체에 설정
            Number key = keyHolder.getKey();
            if (key != null) {
                contact.setContactId(key.longValue());
            } else {
                throw new RuntimeException("Failed to generate contactId for new contact");  // 키 생성 실패 시 예외 발생
            }
        } else {  
            // contactId가 존재하는 경우(기존 연락처 업데이트)
            jdbcTemplate.update(
                    "UPDATE contact SET name = ?, phone_number = ?, email = ? WHERE contact_id = ?",
                    contact.getName(), contact.getPhoneNumber(), contact.getEmail(), contact.getContactId()  // 업데이트할 데이터를 PreparedStatement에 설정
            );
        }
        
        // 저장 또는 업데이트된 contact 객체 반환
        return contact;
    }
}
```

