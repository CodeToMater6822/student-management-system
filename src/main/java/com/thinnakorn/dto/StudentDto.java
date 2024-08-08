package com.thinnakorn.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Long id;
    @NotEmpty(message = "You must fill this field")
    private String firstName;
    @NotEmpty(message = "You must fill this field")
    private String lastName;
    @NotEmpty(message = "You must fill this field")
    @Email(message = "This field must be a email")
    private String email;
}
