
MemberService.java
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

    public Member signUp(SignUpDto signUpDto) {
        return memberRepository.save(signUpDto.toEntity());
    }
    
    // updateNickname 메서드를 작성해 주세요.
    public Member updateNickname(Long id, String nickname){
        Member member = memberRepository.findById(id).orElse(null);
        if (!memberRepository.existsByNickname(nickname)){
            member.setNickname(nickname);
        }
        return member;
    }
}

```


