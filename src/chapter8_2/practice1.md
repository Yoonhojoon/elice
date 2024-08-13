UserInfoValidator.java
```java


package com.elice;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserInfoValidator implements Validator {
@Override
public boolean supports(Class<?> clazz) {
return UserInfoForm.class.isAssignableFrom(clazz);
}

    @Override
    public void validate(Object target, Errors errors) {

        UserInfoForm userInfo = (UserInfoForm) target;

        if (!StringUtils.hasText(userInfo.getName())) {
            errors.rejectValue("name", "required");
        }

        if (userInfo.getAge() == null || userInfo.getAge() < 19 ) {
            errors.rejectValue("age", "min", new Object[]{19}, null);
        }

        if (!userInfo.isMembership()) {
            errors.rejectValue("membership", "membership");
        }
    }
}

```

EventRegistrationViewController.java
```java


package com.elice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class EventRegistrationViewController {
private final UserInfoValidator userInfoValidator;

    @InitBinder
    public void init(WebDataBinder dataBinder) {
        dataBinder.addValidators(userInfoValidator);
    }

    @GetMapping("/v3/event")
    public String getUserInfo(Model model) {
        model.addAttribute("user", new UserInfoForm());
        return "userInfoForm";
    }

    @PostMapping("/v3/event")
    public String getUserInfo(@Validated @ModelAttribute("user") UserInfoForm userInfoForm, BindingResult bindingResult) {
        log.info("user.isMembership={}", userInfoForm.isMembership());

        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "userInfoForm";
        }

        return "confirmForm";
    }
}

```