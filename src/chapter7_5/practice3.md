StudentController.java
```java
package com.elice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    @GetMapping("/students")
    public String getStudents(Model model) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Alice", "alice@example.com", "2학년"));
        students.add(new Student(2, "Bob", "bob@example.com", "3학년"));
        students.add(new Student(3, "Charlie", "charlie@example.com", "1학년"));

        // 지시사항을 참고하여 코드를 작성해 보세요.
        model.addAttribute("students", students);
        return "students";
    }
}

```


students.html
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>학생 목록</title>
    <style>
        .highlight {
            font-weight: bold;
            color: red;
        }
    </style>
</head>
<body>
<h1>학생 목록</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>이름</th>
        <th>이메일</th>
        <th>학년</th>
        <th>비고</th>
    </tr>
    <tr th:each="student : ${students}">
        <td th:text="${student.id}"></td>
        <td th:text="${student.name}"
            th:class="${student.grade == '3학년'} ? 'highlight' : ''"></td>
        <td th:text="${student.email}"></td>
        <td th:text="${student.grade}"></td>
        <!-- 지시사항을 참고하여 코드를 작성해 보세요. -->
        <td th:if="${student.grade == '1학년'}">신입생</td>
    </tr>
</table>
</body>
</html>
```

