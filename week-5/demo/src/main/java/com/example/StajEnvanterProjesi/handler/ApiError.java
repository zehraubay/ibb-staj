package com.example.StajEnvanterProjesi.handler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiError {
    private Integer status;
    private ExceptionDetail exception;
}
