package org.example.back_end.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobDto {
    private Integer id;

    @NotBlank(message = "Job title is required")
    private String jobTitle;
    @NotBlank(message = "Company name is required")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "Company name can only contain letters, numbers, and spaces")
    @Size(min = 2, max = 50, message = "Company name must be between 2 and 50 characters")
    private String company;
    @NotNull(message = "Location is required")
    private String location;
    private String type;
    @Size(min = 10, max = 500, message = "Job description must be between 10 and 500 characters")
    private String jobDescription;
    private String status;
}
