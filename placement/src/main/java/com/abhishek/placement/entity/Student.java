package com.abhishek.placement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String fullName;
    @Email
    @Column(unique = true)
    private String email;
    private String phone;
    private String college;
    private Integer graduationYear;
    public Student(){

    }
}
