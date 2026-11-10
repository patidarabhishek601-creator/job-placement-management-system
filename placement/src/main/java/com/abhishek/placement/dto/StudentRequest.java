package com.abhishek.placement.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data

public class StudentRequest {
    @NotBlank(message = "Name is required")
    private String fullName;
    @NotBlank(message = "Email is required")
    @Email(message = "Enter a valid email")
    private String email;
    @NotBlank(message = "Phone is required")
    @Pattern(regexp = "^[0-9]{10}$",
            message = "Phone must be 10 digits")
            private String phone;
    @NotBlank(message = "College is required")
    private String college;
    @NotNull(message = "Graduation year is required")
    @Min(2020)
    @Max(2035)
    private Integer graduationYear;

}
