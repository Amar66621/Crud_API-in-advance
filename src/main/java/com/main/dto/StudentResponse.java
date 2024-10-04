package com.main.dto;

import lombok.Data;
import java.util.List;

@Data
public class StudentResponse {
    private Long id;
    private String name;
    private String course;
    private List<StudentAddressResponse> addresses;
}

