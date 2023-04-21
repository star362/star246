package com.auth.sunia.star247.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private String name;
    private String sex;
    private List<Student> students;
}
