

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
        students.add(new Student(1, "Alice", "alice@example.com"));
        students.add(new Student(2, "Bob", "bob@example.com"));
        students.add(new Student(3, "Charlie", "charlie@example.com"));

        // 지시사항을 참고하여 코드를 작성해 보세요.
        model.addAttribute("students",students);
        return "students";
    }
}

```

student.html
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>학생 목록</title>
</head>
<body>
<h1>학생 목록</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>이름</th>
        <th>이메일</th>
    </tr>
    <!-- 지시사항을 참고하여 코드를 작성해 보세요. -->
    <tr th:each="student : ${students}">
        <td th:text="${student.id}"></td>
        <td th:text="${student.name}"></td>
        <td th:text="${student.email}"></td>
    </tr>

</table>
</body>
</html>
```