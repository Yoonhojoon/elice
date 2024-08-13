
UserInfoForm.java
```java
package com.elice;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoForm {

    @NotBlank(message = "이름은 공백일 수 없습니다.")
    private String name;

    @Min(value = 19, message = "나이는 19세 이상이어야 합니다.")
    private Integer age;

    @AssertTrue(message = "멤버십 회원이어야 합니다.")
    private boolean membership;
}
```