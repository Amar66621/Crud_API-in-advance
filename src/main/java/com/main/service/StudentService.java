package com.main.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.StudentDao;
import com.main.dto.StudentRequest;
import com.main.dto.StudentResponse;
import com.main.entity.Student;
import com.main.translator.StudentTranslator;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private StudentTranslator studentTranslator;

    public List<StudentResponse> getAllStudents() {
        return studentDao.getAllStudents().stream()
            .map(studentTranslator::entityToResponse)
            .collect(Collectors.toList());
    }

    public StudentResponse addStudent(StudentRequest request) {
        Student student = studentTranslator.requestToEntity(request);
        Student savedStudent = studentDao.saveStudent(student);
        return studentTranslator.entityToResponse(savedStudent);
    }
}
