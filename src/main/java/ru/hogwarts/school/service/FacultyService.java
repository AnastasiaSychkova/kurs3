package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.*;

@Service
public class FacultyService {
    private Map<Long, Faculty> facultyMap = new HashMap<>();
    private Long generatedFacultyId = 0L;

    public Faculty createFaculty(Faculty faculty){
        faculty.setId(generatedFacultyId++);
        facultyMap.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty getFacultyById(Long id){
        return facultyMap.get(id);
    }
    public Collection<Faculty> getAllFacultyByColour(String colour){
        List<Faculty> faculties = new ArrayList<>();
        for (Faculty faculty : facultyMap.values()){
            if(faculty.getColor().equals(colour)){
                faculties.add(faculty);
            }
        }
        return faculties;
    }

    public Faculty updateFaculty(Faculty faculty){
        if (!facultyMap.containsKey(faculty.getId())) {
            return null;
        }
        facultyMap.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty deleteFaculty(Long id){
        return facultyMap.remove(id);
    }
}
