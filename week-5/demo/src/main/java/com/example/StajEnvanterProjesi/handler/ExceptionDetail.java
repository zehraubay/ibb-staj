package com.example.StajEnvanterProjesi.handler;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class ExceptionDetail {
    private String path;
    private Date createTime;
    private Object message;
}
