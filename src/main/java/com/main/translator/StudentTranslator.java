package com.main.translator;


import org.springframework.stereotype.Component;

import com.main.dto.StudentAddressRequest;
import com.main.dto.StudentAddressResponse;
import com.main.dto.StudentRequest;
import com.main.dto.StudentResponse;
import com.main.entity.Student;
import com.main.entity.StudentAddress;

import java.util.stream.Collectors;

@Component
public class StudentTranslator {

    public Student requestToEntity(StudentRequest request) {
        Student student = new Student();
        student.setName(request.getName());
        student.setCourse(request.getCourse());
        student.setAddresses(request.getAddresses().stream()
            .map(this::addressRequestToEntity)
            .collect(Collectors.toList()));
        return student;
    }

    public StudentResponse entityToResponse(Student student) {
        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setName(student.getName());
        response.setCourse(student.getCourse());
        response.setAddresses(student.getAddresses().stream()
            .map(this::addressEntityToResponse)
            .collect(Collectors.toList()));
        return response;
    }

    private StudentAddress addressRequestToEntity(StudentAddressRequest addressRequest) {
        StudentAddress address = new StudentAddress();
        address.setStreet(addressRequest.getStreet());
        address.setCity(addressRequest.getCity());
        address.setState(addressRequest.getState());
        address.setZipCode(addressRequest.getZipCode());
        return address;
    }

    private StudentAddressResponse addressEntityToResponse(StudentAddress address) {
        StudentAddressResponse addressResponse = new StudentAddressResponse();
        addressResponse.setStreet(address.getStreet());
        addressResponse.setCity(address.getCity());
        addressResponse.setState(address.getState());
        addressResponse.setZipCode(address.getZipCode());
        return addressResponse;
    }
}