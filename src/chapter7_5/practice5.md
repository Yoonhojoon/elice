
StudentController.java
```java
package com.elice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private List<Student> students = new ArrayList<>();

    public StudentController() {
        students.add(new Student(1, "Alice", "alice@example.com", "2학년"));
        students.add(new Student(2, "Bob", "bob@example.com", "3학년"));
        students.add(new Student(3, "Charlie", "charlie@example.com", "1학년"));
    }

    @GetMapping
    public String getStudents(Model model) {
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/{id}")
    public String getStudentDetails(@PathVariable Integer id, Model model) {
        Student student = students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
        model.addAttribute("student", student);
        return "studentDetail";
    }
}

```


students.html
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
        <th>학년</th>
    </tr>
    <tr th:each="student : ${students}">
        <td th:text="${student.id}"></td>
        <td>
            <a th:href="@{/students/{id}(id=${student.id})}" th:text="${student.name}"></a>
        </td>
        <td th:text="${student.email}"></td>
        <td th:text="${student.grade}"></td>
    </tr>
</table>
</body>
</html>
```


studentDetail.html
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>학생 세부 정보</title>
</head>
<body>
<h1>학생 세부 정보</h1>

<div>
    <!-- 지시사항을 참고하여 코드를 작성해 보세요. -->  

    <p>ID: <span th:text="${student.id}"></span></p>
    <p>이름: <span th:text="${student.name}"></span></p>
    <p>이메일: <span th:text="${student.email}"></span></p>
    <p>학년: <span th:text="${student.grade}"></span></p>
</div>

<a th:href="@{/students}">학생 목록으로 돌아가기</a>
</body>
</html>
```