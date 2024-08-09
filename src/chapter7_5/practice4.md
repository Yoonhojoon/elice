
StudentController.java
```java
package com.elice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    private List<Student> students = new ArrayList<>();

    public StudentController() {
        students.add(new Student(1, "Alice", "alice@example.com", "2학년"));
        students.add(new Student(2, "Bob", "bob@example.com", "3학년"));
        students.add(new Student(3, "Charlie", "charlie@example.com", "1학년"));
    }

    @GetMapping("/students")
    public String getStudents(@RequestParam(value = "grade", required = false) String grade, Model model) {
        List<Student> filteredStudents = new ArrayList<>();

        // 지시사항을 참고하여 코드를 작성해 보세요.
        if (grade == null || grade.isEmpty()) {
            filteredStudents = students; // 모든 학생 표시
        } else {
            for (Student student : students) {
                if (student.getGrade().equals(grade)) {
                    filteredStudents.add(student);
                }
            }
        }

        model.addAttribute("students", filteredStudents);
        model.addAttribute("selectedGrade", grade);
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
</head>
<body>
<h1>학생 목록</h1>

<form action="#" th:action="@{/students}" method="get">
    <!-- 지시사항을 참고하여 코드를 작성해 보세요. -->
    <label for="grade">학년 선택:</label>
    <select id="grade" name="grade">
        <option value="">모두</option>
        <option value="1학년" th:selected="${selectedGrade == '1학년'}">1학년</option>
        <option value="2학년" th:selected="${selectedGrade == '2학년'}">2학년</option>
        <option value="3학년" th:selected="${selectedGrade == '3학년'}">3학년</option>
    </select>
    <button type="submit">검색</button>
</form>

<p th:if="${selectedGrade != null}">선택된 학년: <span th:text="${selectedGrade}"></span></p>

<table border="1">
    <tr>
        <th>ID</th>
        <th>이름</th>
        <th>이메일</th>
        <th>학년</th>
    </tr>
    <tr th:each="student : ${students}">
        <td th:text="${student.id}"></td>
        <td th:text="${student.name}"></td>
        <td th:text="${student.email}"></td>
        <td th:text="${student.grade}"></td>
    </tr>
</table>
</body>
</html>
```