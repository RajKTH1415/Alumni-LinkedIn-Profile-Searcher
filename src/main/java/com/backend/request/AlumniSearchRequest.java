package com.backend.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlumniSearchRequest {

    @NotBlank
    private String university;

    @NotBlank
    private String designation;

    private Integer passoutYear;
}
