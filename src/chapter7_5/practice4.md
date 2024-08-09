
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