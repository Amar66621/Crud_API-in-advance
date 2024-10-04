package com.main.dto;

import lombok.Data;
import java.util.List;

@Data
public class StudentRequest {
    private String name;
    private String course;
    private List<StudentAddressRequest> addresses;
}

