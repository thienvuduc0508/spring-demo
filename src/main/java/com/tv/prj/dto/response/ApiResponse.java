package com.tv.prj.dto.response;

import com.fasterxml.classmate.AnnotationOverrides;
import com.tv.prj.entity.User;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse <T>{
    private int code = 1000;
    private String message;
    private T result;

}
