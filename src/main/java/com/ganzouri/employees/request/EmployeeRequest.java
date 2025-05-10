package com.ganzouri.employees.request;

import com.ganzouri.employees.entity.Employee;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeRequest {
    @Size(min = 2, max = 45)
    @NotBlank
    private String firstName;
    @Size(min = 2, max = 45)
    @NotBlank
    private String lastName;
    @Size(min = 5, max = 45)
    @Email
    private String email;


}
