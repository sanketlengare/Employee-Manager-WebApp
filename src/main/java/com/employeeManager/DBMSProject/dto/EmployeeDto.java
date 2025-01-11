package com.employeeManager.DBMSProject.dto;


import java.io.Serializable;
import java.util.Objects;

public class EmployeeDto implements Serializable {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String jobTitle;
    private String imageUrl;
    private String employeeCode;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeDto that)) return false;
        EmployeeDto employeeDto = (EmployeeDto) o;
        if (this.id == null) return false;
        return Objects.equals(this.id, employeeDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "email='" + email + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", employeeCode='" + employeeCode + '\'' +
                '}';
    }
}
