package org.lld.prep.random_questions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    private Double salary;
    private Integer age;
    private String gender;
    private String department;
}
