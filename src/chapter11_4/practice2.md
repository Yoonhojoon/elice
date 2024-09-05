
MemberRepository
```java
package com.elice.post.repository;

import com.elice.post.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member save(Member member);
    Optional<Member> findById(Long id);
    
    // 지시사항에 따라 메서드를 작성해 주세요.
    boolean existsByNickname(String nickname);
    boolean existsByEmail(String email);

}
```



MemberService
```java
package com.elice.post.service;

import com.elice.post.domain.Member;
import com.elice.post.dto.SignUpDto;
import com.elice.post.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 지시사항에 따라 기능을 작성해 주세요.
    public Member signUp(SignUpDto signUpDto) {
        Member member;
        
        if(!memberRepository.existsByNickname(signUpDto.getNickname()) && !memberRepository.existsByEmail(signUpDto.getEmail()))
            member = memberRepository.save(signUpDto.toEntity());
        else
            member = null;

        return member;
    }

}
```



SignUpDto
```java
package com.elice.post.dto;

import com.elice.post.domain.Member;

public class SignUpDto {
    private String email;
    private String password;
    private String nickname;

    public SignUpDto() {

    }

    public Member toEntity() {
        return new Member(email, password, nickname);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}

```



MemberController
```java
package com.elice.post.controller;

import com.elice.post.domain.Member;
import com.elice.post.dto.SignUpDto;
import com.elice.post.service.MemberService;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {
    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/signup")
    public Member signupMember(@RequestBody SignUpDto signUpDto) {
        return memberService.signUp(signUpDto);
    }

}

```