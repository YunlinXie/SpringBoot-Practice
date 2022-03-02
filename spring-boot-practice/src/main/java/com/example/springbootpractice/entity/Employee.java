package com.example.springbootpractice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Employee {
    private int id;
    private int employee_salary;
    private int employee_age;
    private String profile_image;
    private String employee_name;

    public Employee(int id, int employee_salary, int employee_age, String profile_image, String employee_name) {
        this.id = id;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
        this.profile_image = profile_image;
        this.employee_name = employee_name;
    }

    public int getId() {
        return id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public int getEmployee_salary() {
        return employee_salary;
    }

    public int getEmployee_age() {
        return employee_age;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmployee_salary(int employee_salary) {
        this.employee_salary = employee_salary;
    }

    public void setEmployee_age(int employee_age) {
        this.employee_age = employee_age;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String toString() {
        return this.id + " " + this.employee_age + " " + this.employee_salary + " " + this.employee_name;
    }
}
