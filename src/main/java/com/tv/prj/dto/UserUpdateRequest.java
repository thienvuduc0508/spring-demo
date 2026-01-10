package com.tv.prj.dto;

import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class UserUpdateRequest {

    @Size(min = 8, message = "Password at least 8 characters")
    String password;
    String firstName;
    String lastName;
    LocalDate dob;
}
