package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.*;

@Service
public class StudentService {
    private Map<Long, Student> studentMap = new HashMap<>();
    private Long generatedStudentId = 0L;

    public Student createStudent(Student student) {
        student.setId(generatedStudentId++);
        studentMap.put(student.getId(), student);
        return student;
    }

    public Student getStudentById(Long id) {
        return studentMap.get(id);
    }

    public Collection<Student> getAllStudentByAge(int age) {
        List<Student> students = new ArrayList<>();
        for (Student student : studentMap.values()) {
            if (student.getAge() == age) {
                students.add(student);
            }
        }
        return students;
    }

    public Student updateStudent(Student student) {
        if (!studentMap.containsKey(student.getId())) {
            return null;
        }
        studentMap.put(student.getId(), student);
        return student;
    }

    public Student deleteStudent(Long id) {
        return studentMap.remove(id);
    }
}
