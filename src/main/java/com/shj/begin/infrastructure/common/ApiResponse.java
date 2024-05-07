package com.shj.begin.infrastructure.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ApiResponse<T> {
    private T data;
    private int statusCode;
    private String msg;
}
